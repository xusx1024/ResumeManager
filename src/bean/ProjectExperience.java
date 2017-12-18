package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 项目经历
 * 
 * @author sxx.xu
 *
 */
public class ProjectExperience {
	/** 2011.03 ~ 至今. */
	private String beginTime;
	/** 2011.03 ~ 至今. */
	private String endTime;
	/** 公司名字. */
	private String company;
	/** 职位. */
	private String projectPosition;
	/** 项目简介. */
	private String projectDesc;
	/** 项目职责. */
	private String projectResponse;
	/** 项目业绩. */
	private String projectPerformance;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProjectPosition() {
		return projectPosition;
	}

	public void setProjectPosition(String projectPosition) {
		this.projectPosition = projectPosition;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectResponse() {
		return projectResponse;
	}

	public void setProjectResponse(String projectResponse) {
		this.projectResponse = projectResponse;
	}

	public String getProjectPerformance() {
		return projectPerformance;
	}

	public void setProjectPerformance(String projectPerformance) {
		this.projectPerformance = projectPerformance;
	}

	public void insert(String uUId2) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(uUId2);
			params.add(beginTime);
			params.add(endTime);
			params.add(company);
			params.add(projectPosition);
			params.add(projectDesc);
			params.add(projectResponse);
			params.add(projectPerformance);
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_PROJECT_EXPERIENCE, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ProjectExperience [beginTime=" + beginTime + ", endTime=" + endTime + ", company=" + company
				+ ", projectPosition=" + projectPosition + ", projectDesc=" + projectDesc + ", projectResponse="
				+ projectResponse + ", projectPerformance=" + projectPerformance + ", getBeginTime()=" + getBeginTime()
				+ ", getEndTime()=" + getEndTime() + ", getCompany()=" + getCompany() + ", getProjectPosition()="
				+ getProjectPosition() + ", getProjectDesc()=" + getProjectDesc() + ", getProjectResponse()="
				+ getProjectResponse() + ", getProjectPerformance()=" + getProjectPerformance() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
