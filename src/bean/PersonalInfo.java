package bean;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.JdbcUtils;
import database.SQLConstant;
import ennum.Education;
import ennum.Gender;
import ennum.MarrySate;

/**
 * 个人信息
 * 
 * @author sxx.xu
 *
 */
public class PersonalInfo {
	/** 姓名. */
	private String name;
	/** 姓名拼音. */
	private String namePinyin;
	/** 花名. */
	private String nickName;
	/** 性别:男(1),女(0),未知(-1). */
	private Gender gender;
	/** 生日. */
	private Date birthday;
	/** 手机. */
	private String mobile;
	/** 年龄. */
	private int age;
	/** 邮箱. */
	private String email;
	/** 最高学历/教育程度. */
	private Education hightestEdu;
	/** 工作经验(工作年限). */
	private int wrokYears;
	/** 是否已婚. */
	private MarrySate isMarried;
	/** 工作城市. */
	private String workCity;
	/** 居住城市. */
	private String homeCity;
	/** 目前职业概况. */
	private CurrentJobProfile cjp;
	/** 职业发展意向. */
	private CareerDevelopmentIntention cdli;
	private String position;
	private String company;
	/** 文件路径. */
	private String filePath;
	private String UUId;
	/** 上次编辑时间. */
	private Date lastEditTime;
	/** 目标公司. */
	private String destCompany;
	/** 备注. */
	private String markTxt;

	public PersonalInfo(String uUID) {
		super();
		UUId = uUID;
	}

	public String getDestCompany() {
		return destCompany;
	}

	public void setDestCompany(String destCompany) {
		this.destCompany = destCompany;
	}

	public String getMarkTxt() {
		return markTxt;
	}

	public void setMarkTxt(String markTxt) {
		this.markTxt = markTxt;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public MarrySate getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(MarrySate isMarried) {
		this.isMarried = isMarried;
	}

	public CurrentJobProfile getCjp() {
		return cjp;
	}

	public void setCjp(CurrentJobProfile cjp) {
		this.cjp = cjp;
	}

	public CareerDevelopmentIntention getCdli() {
		return cdli;
	}

	public void setCdli(CareerDevelopmentIntention cdli) {
		this.cdli = cdli;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePinyin() {
		return namePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Education getHightestEdu() {
		return hightestEdu;
	}

	public void setHightestEdu(Education hightestEdu) {
		this.hightestEdu = hightestEdu;
	}

	public int getWrokYears() {
		return wrokYears;
	}

	public void setWrokYears(int wrokYears) {
		this.wrokYears = wrokYears;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((cdli == null) ? 0 : cdli.hashCode());
		result = prime * result + ((cjp == null) ? 0 : cjp.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hightestEdu == null) ? 0 : hightestEdu.hashCode());
		result = prime * result + ((homeCity == null) ? 0 : homeCity.hashCode());
		result = prime * result + ((isMarried == null) ? 0 : isMarried.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((namePinyin == null) ? 0 : namePinyin.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((workCity == null) ? 0 : workCity.hashCode());
		result = prime * result + wrokYears;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalInfo other = (PersonalInfo) obj;
		if (age != other.age)
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (cdli == null) {
			if (other.cdli != null)
				return false;
		} else if (!cdli.equals(other.cdli))
			return false;
		if (cjp == null) {
			if (other.cjp != null)
				return false;
		} else if (!cjp.equals(other.cjp))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (hightestEdu != other.hightestEdu)
			return false;
		if (homeCity == null) {
			if (other.homeCity != null)
				return false;
		} else if (!homeCity.equals(other.homeCity))
			return false;
		if (isMarried != other.isMarried)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (namePinyin == null) {
			if (other.namePinyin != null)
				return false;
		} else if (!namePinyin.equals(other.namePinyin))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (workCity == null) {
			if (other.workCity != null)
				return false;
		} else if (!workCity.equals(other.workCity))
			return false;
		if (wrokYears != other.wrokYears)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonalInfo [name=" + name + ", namePinyin=" + namePinyin + ", nickName=" + nickName + ", gender="
				+ gender + ", birthday=" + birthday + ", mobile=" + mobile + ", age=" + age + ", email=" + email
				+ ", hightestEdu=" + hightestEdu + ", wrokYears=" + wrokYears + ", isMarried=" + isMarried
				+ ", workCity=" + workCity + ", homeCity=" + homeCity + ", cjp=" + cjp + ", cdli=" + cdli + ", UUID="
				+ UUId + "]";
	}

	public void insert() {
		try {
			if (select()) {
				System.out.println("已经存在的数据!");
				return;
			}
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(UUId);
			params.add(name);
			params.add(namePinyin);
			params.add(nickName);
			params.add(Gender.get(gender));
			params.add(birthday);
			params.add(mobile);
			params.add(age);
			params.add(email);
			params.add(Education.get(hightestEdu));
			params.add(wrokYears);
			params.add(MarrySate.get(isMarried));
			params.add(workCity);
			params.add(homeCity);
			params.add(position);
			params.add(company);
			params.add(filePath);
			params.add(lastEditTime);
			params.add(destCompany);
			params.add(markTxt);
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_PERSONAL_INFO, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean select() {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(name);
			params.add(email);
			Map<String, Object> map = jdbcUtils.findSimpleResult(SQLConstant.QUERY_PERSONAL, params);
			return map.size() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}
