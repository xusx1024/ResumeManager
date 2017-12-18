package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;
import ennum.Education;

/**
 * 教育经历
 * 
 * @author sxx.xu
 *
 */
public class EducationExperience {
	/** 学校. */
	private String school;
	/** 2011.03 ~ 至今. */
	private String beginTime;
	/** 2011.03 ~ 至今. */
	private String endTime;
	/** 专业. */
	private String discipline;
	/** 学历. */
	private Education edu;
	/** 是否统招. */
	private boolean isTongZhao;
	private String UUId;

	public boolean isTongZhao() {
		return isTongZhao;
	}

	public void setTongZhao(boolean isTongZhao) {
		this.isTongZhao = isTongZhao;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public Education getEdu() {
		return edu;
	}

	public void setEdu(Education edu) {
		this.edu = edu;
	}

	public void insert(String uUId2) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(uUId2);
			params.add(school);
			params.add(beginTime);
			params.add(endTime);
			params.add(discipline);
			params.add(Education.get(edu));
			params.add(isTongZhao ? "是" : "否");
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_EDUCATION_EXPERIENCE, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "EducationExperience [school=" + school + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", discipline=" + discipline + ", edu=" + edu + ", isTongZhao=" + isTongZhao + ", isTongZhao()="
				+ isTongZhao() + ", getSchool()=" + getSchool() + ", getBeginTime()=" + getBeginTime()
				+ ", getEndTime()=" + getEndTime() + ", getDiscipline()=" + getDiscipline() + ", getEdu()=" + getEdu()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
