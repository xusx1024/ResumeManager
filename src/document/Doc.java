package document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bean.Candidate;
import bean.CareerDevelopmentIntention;
import bean.CurrentJobProfile;
import bean.EducationExperience;
import bean.ExtraInfo;
import bean.LanguageSkills;
import bean.PersonalInfo;
import bean.ProjectExperience;
import bean.SelfEvaluation;
import bean.WorkExperience;
import ennum.Education;
import ennum.Gender;
import ennum.MarrySate;
import ennum.ReadDocState;
import pinYinDict.PinyinException;
import pinYinDict.PinyinFormat;
import pinYinDict.PinyinHelper;
import util.DateUtil;
import util.ParseTextUtil;
import util.UUIDGenerator;

/**
 * 父类
 * 
 * @author sxx.xu
 *
 */
public abstract class Doc {
	protected String content;
	private Candidate c;
	private PersonalInfo pi;
	private CurrentJobProfile cjp;
	private CareerDevelopmentIntention cdli;
	private List<WorkExperience> wes;
	private List<ProjectExperience> pes;
	private List<EducationExperience> ees;
	private List<LanguageSkills> lss;
	private SelfEvaluation se;
	private ExtraInfo ei;
	private String UUId;
	private ReadDocState currentState;

	protected Doc() {
		c = new Candidate();
		UUId = UUIDGenerator.getUUID();
		pi = new PersonalInfo(UUId);
		cjp = new CurrentJobProfile();
		cdli = new CareerDevelopmentIntention();
		wes = new ArrayList<>();
		pes = new ArrayList<>();
		ees = new ArrayList<>();
		lss = new ArrayList<>();
		se = new SelfEvaluation();
		ei = new ExtraInfo();
		currentState = ReadDocState.NORMAL_STATE;
	}

	/** 将word文档的文本内容写入text. */
	protected void writeContentInFile(String path) {
		try {
			File fileR = new File(path);
			fileR.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(fileR));
			if (content.length() > 0)
				out.write(content);
			out.flush();
			out.close();
			buildCandidate(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/** 构建候选人实体. */
	private void buildCandidate(String path) {
		try {
			FileReader reader = new FileReader(path);
			LineNumberReader br = new LineNumberReader(reader);
			String str = null;
			while ((str = br.readLine()) != null) {
				if (str.contains("个人信息")) {
					currentState = ReadDocState.PERSONAL_INFO_STATE;
				} else if (str.contains("工作经历")) {
					currentState = ReadDocState.WORK_EXPERIENCE_STATE;
				} else if (str.contains("项目经历")) {
					currentState = ReadDocState.PROJECT_EXPERIENCE_STATE;
				} else if (str.contains("教育经历")) {
					ee = new EducationExperience();
					nextLineIsCollege = true;
					currentState = ReadDocState.EDUCATION_EXPERIENCE_STATE;
				} else if (str.contains("语言能力")) {
					currentState = ReadDocState.LANGUAGE_SKILLS_STATE;
				} else if (str.contains("自我评价")) {
					currentState = ReadDocState.SELF_EVALUATION_STATE;
				} else if (str.contains("附加信息")) {
					currentState = ReadDocState.EXTRA_INFO;
				} else {
					resolveOtherInfo(str);
				}

				if (currentState == ReadDocState.PERSONAL_INFO_STATE) {
					resolvePersonInfo(str);
				} else if (currentState == ReadDocState.WORK_EXPERIENCE_STATE) {
					resolveWorkExperience(str);
				} else if (currentState == ReadDocState.PROJECT_EXPERIENCE_STATE) {
					resolveProjectExperience(str);
				} else if (currentState == ReadDocState.EDUCATION_EXPERIENCE_STATE) {
					resloveEducationExperience(str);
				} else if (currentState == ReadDocState.LANGUAGE_SKILLS_STATE) {
					resloveLanguageSkills(str);
				} else if (currentState == ReadDocState.SELF_EVALUATION_STATE) {
					resloveSelfEvaluation(str);
				} else if (currentState == ReadDocState.EXTRA_INFO) {
					resloveExtraInfo(str);
				}
			}
			// pi insert
			pi.setFilePath(path.replace(".txt", ""));
			pi.setPosition(cjp.getPosition());
			pi.setCompany(cjp.getCompany());
			pi.setLastEditTime(new Date(System.currentTimeMillis()));

			if (!pi.select()) {
				pi.insert();
				cjp.insert(UUId);
				cdli.insert(UUId);
				ei.insert(UUId);
				se.insert(UUId);
				for (EducationExperience ee : ees) {
					ee.insert(UUId);
				}
				for (LanguageSkills ls : lss) {
					ls.insert(UUId);
				}
				for (ProjectExperience pe : pes) {
					pe.insert(UUId);
				}
				for (WorkExperience we : wes) {
					we.insert(UUId);
				}
			} else {
				System.out.println(pi.getName() + "已经读取插入过了.");
			}

			pi.setCjp(cjp);
			pi.setCdli(cdli);

			c.setEducationExperience(ees);
			c.setPersonalInfo(pi);
			c.setExtraInfo(ei);
			c.setLanguageSkills(lss);
			c.setProjectExperiences(pes);
			c.setSelfEvaluation(se);
			c.setWorkExperiences(wes);
			br.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析其他信息
	 * 
	 * @param str
	 */
	private void resloveExtraInfo(String str) {
		if (!"附加信息".equals(str.trim()))
			ei.add(str);
	}

	/**
	 * 解析自我评价
	 * 
	 * @param str
	 */
	private void resloveSelfEvaluation(String str) {
		if (!"自我评价".equals(str.trim()))
			se.add(str);
	}

	LanguageSkills ls;

	/**
	 * 解析语言能力
	 * 
	 * @param str
	 */
	private void resloveLanguageSkills(String str) {
		if (str.contains("、")) {
			String[] split = str.split("、");
			for (int i = 0; i < split.length; i++) {
				ls = new LanguageSkills();
				ls.setKind(split[i]);
				lss.add(ls);
			}
		}

	}

	EducationExperience ee;
	boolean nextLineIsCollege;

	/**
	 * 解析教育经历
	 * 
	 * @param str
	 */
	private void resloveEducationExperience(String str) {
		if (str.contains("-")) {
			str = str.replace("（ ", "").replace("）", "");
			String[] split = str.split("-");
			ee.setBeginTime(split[0]);
			ee.setEndTime(split[1]);
		} else if (str.contains(":")) {
			String[] split = str.split(":");
			String s1 = split[0];
			String s2 = split[1];
			if (s1.contains("专业")) {
				ee.setDiscipline(s2);
			} else if (s1.contains("学历")) {
				ee.setEdu(Education.get(s2));
			} else if (s1.contains("是否统招")) {
				ee.setTongZhao("是".equals(s2) ? true : false);
				ees.add(ee);
			}
		} else {
			ee.setSchool(str);
		}
	}

	ProjectExperience pe;

	/**
	 * 解析项目经历
	 * 
	 * @param str
	 */
	private void resolveProjectExperience(String str) {

		if (str.contains("-") || str.contains("–")) {
			pe = new ProjectExperience();
			String[] split = str.split("–");
			if (split.length < 2)
				split = str.split("-");
			pe.setBeginTime(split[0]);
			pe.setEndTime(split[1]);
			nextLineIsCompany = true;
		} else if (nextLineIsCompany) {
			pe.setCompany(str);
			nextLineIsCompany = false;
		} else if (str.contains(":")) {
			String[] split = str.split(":");
			String s1 = split[0];
			String s2 = split[1];
			if (s1.contains("项目职务")) {
				pe.setProjectPosition(s2);
			} else if (s1.contains("所在公司")) {
				pe.setCompany(s2);
			} else if (s1.contains("项目简介")) {
				pe.setProjectDesc(s2);
			} else if (s1.contains("项目职责")) {
				pe.setProjectResponse(s2);
			} else if (s1.contains("项目业绩")) {
				pe.setProjectPerformance(s2);
				pes.add(pe);
			}
		}
	}

	WorkExperience we;
	boolean nextLineIsCompany = false;
	boolean nextLineIsPosition = false;
	boolean nextLineIsSalary = false;

	/**
	 * 解析工作经历
	 * 
	 * @param str
	 */
	private void resolveWorkExperience(String str) {
		if (str.contains("-") || str.contains("–")) {
			we = new WorkExperience();
			String[] split = str.split("–");
			if (split.length < 2)
				split = str.split("-");
			we.setBeginTime(split[0]);
			we.setEndTime(split[1]);
			nextLineIsCompany = true;
			split = null;
		} else if (nextLineIsCompany) {
			we.setCompany(str.trim());
			nextLineIsCompany = false;
		} else if (nextLineIsPosition) {
			we.setPosition(str);
			nextLineIsPosition = false;
			nextLineIsSalary = true;
		} else if (nextLineIsSalary) {
			if (str.contains("月")) {
				we.setMonthlySalary(ParseTextUtil.getNumberFromStr(str));
			} else if (str.contains("年")) {
				we.setAnnualSalary(ParseTextUtil.getNumberFromStr(str));
			}
			nextLineIsSalary = false;
		} else if (str.contains(":")) {
			String[] split = str.split(":");
			String s1 = split[0];
			String s2 = split[1];
			if (s1.contains("公司性质")) {
				we.setCompanyType(s2);
			} else if (s1.contains("公司规模")) {
				we.setCompanySize(s2);
			} else if (s1.contains("公司行业")) {
				we.setCompanyIndustry(s2);
			} else if (s1.contains("公司描述")) {
				we.setCompanyDesc(s2);
				nextLineIsPosition = true;
			} else if (s1.contains("汇报对象")) {
				we.setDirectLeader(s2.trim());
			} else if (s1.contains("下属人数")) {
				we.setUnderling(s2.trim());
			} else if (s1.contains("所在地区")) {
				we.setCompanyArea(s2.trim());
			} else if (s1.contains("所在部门")) {
				we.setDepartMent(s2);
			} else if (s1.contains("工作职责和业绩")) {
				we.setJobAndPerformance(s2);
				wes.add(we);
			}
		}
	}

	boolean nextLineisIgnoreCompany = false;

	/**
	 * 解析个人信息
	 * 
	 * @param str
	 * @throws PinyinException
	 */
	private void resolvePersonInfo(String str) throws PinyinException {
		if (nextLineisIgnoreCompany) {
			cdli.setIgnoreCompany(str);
			nextLineisIgnoreCompany = false;
			return;
		}
		String s1;
		String s2;
		String s3;
		if (str.contains(":")) {
			String[] split = str.split(":");
			if (split.length == 2) {
				s1 = split[0];
				s2 = split[1];
				/**
				 * LIEPIN - 平台分配出来的一些信息
				 * 
				 */
				if (s1.contains("求职状态")) {
					c.setResumeState(s2);
				} else if (s1.contains("应聘职位")) {
					c.setLikePosition(s2);
				} else if (s1.contains("简历编号")) {
					c.setResumeNumber(s2);
				}
				/**
				 * LIEPIN - 个人信息
				 * 
				 */
				else if (s1.contains("姓名")) {
					pi.setName(s2.trim());
					pi.setNamePinyin(PinyinHelper.convertToPinyinString(s2.trim(), "-", PinyinFormat.WITH_TONE_MARK));
				} else if (s1.contains("性别")) {
					pi.setGender(Gender.get(s2.trim()));
				} else if (s1.contains("手机号码")) {
					pi.setMobile(s2.trim());
				} else if (s1.contains("年龄")) {
					pi.setAge(Integer.parseInt(s2.trim()));
				} else if (s1.contains("电子邮件") || s1.contains("email") || s1.contains("E-mail")) {
					pi.setEmail(s2.trim());
				} else if (s1.contains("教育程度")) {
					pi.setHightestEdu(Education.get(s2.trim()));
				} else if (s1.contains("工作年限")) {
					pi.setWrokYears(ParseTextUtil.getNumberFromStr(s2.trim()));
				} else if (s1.contains("婚姻状况")) {
					pi.setIsMarried(MarrySate.get(s2.trim()));
				} else if (s1.contains("所在地")) {
					pi.setWorkCity(s2);
				}
				/**
				 * LIEPIN - 个人信息 - 目前职业概况
				 * 
				 */
				else if (s1.contains("所任职位")) {
					cjp.setPosition(s2);
				} else if (s1.contains("公司名称")) {
					cjp.setCompany(s2);
				} else if (s1.contains("年薪")) {
					cjp.setAnnualSalary(ParseTextUtil.getSalaryFormStr(s2));
				}

				/**
				 * LIEPIN - 个人信息 - 目前职业概况
				 * 
				 */
				else if (s1.contains("期望行业")) {
					cdli.setExecptIndustry(s2);
				} else if (s1.contains("期望职位")) {
					cdli.setExecptPosition(s2);
				} else if (s1.contains("期望地点")) {
					cdli.setExecptCity(s2);
				} else if (s1.contains("期望年薪")) {
					cdli.setExecptSalary(ParseTextUtil.getSalaryFormStr(s2));
				} else if (s1.contains("勿推企业")) {
					cdli.setIgnoreCompany(s2);
				}
			}

			if (split.length == 3) {
				s1 = split[0];
				s2 = split[1];
				s3 = split[2];
				if (s2.contains("所在行业")) {
					cjp.setCurrentIndustry(s3);
				} else if (s2.contains("期望行业")) {
					cdli.setExecptIndustry(s3);
				} else if (s1.contains("期望年薪")) {
					nextLineisIgnoreCompany = true;
					cdli.setExecptSalary((ParseTextUtil.getSalaryFormStr(s3)));
				}
			}
		}
	}

	/**
	 * 解析其余信息
	 * 
	 * @param str
	 */
	private void resolveOtherInfo(String str) {
		if (str.contains(":")) {
			String[] split = str.split(":");
			if (split[0].contains("简历更新时间")) {
				c.setResumeUpdateTime(DateUtil.transTime2Date(split[1].trim()));
			}
		}
	}

	public abstract void readeOriginText(String path) throws Exception;;
}
