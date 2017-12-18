package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 工作经历
 * 
 * @author sxx.xu
 *
 */
public class WorkExperience {
	/** 2011.03 ~ 至今. */
	private String beginTime;
	/** 2011.03 ~ 至今. */
	private String endTime;
	/** 公司名字. */
	private String company;
	/** 国企,外企之类. */
	private String companyType;
	/** 公司规模. */
	private String companySize;
	/** 公司行业. */
	private String companyIndustry;
	/** 公司描述. */
	private String companyDesc;
	/** 职位. */
	private String position;
	/** 月薪. */
	private int monthlySalary;
	/** 年薪. */
	private int annualSalary;
	/** 公司所在地区. */
	private String companyArea;
	/** 所在部门. */
	private String departMent;
	/** 工作职责和业绩. */
	private String jobAndPerformance;
	/** 汇报对象. */
	private String directLeader;
	/** 下属. */
	private String underling;

	public String getDirectLeader() {
		return directLeader;
	}

	public void setDirectLeader(String directLeader) {
		this.directLeader = directLeader;
	}

	public String getUnderling() {
		return underling;
	}

	public void setUnderling(String underling) {
		this.underling = underling;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getCompanyIndustry() {
		return companyIndustry;
	}

	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getCompanyArea() {
		return companyArea;
	}

	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}

	public String getDepartMent() {
		return departMent;
	}

	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}

	public String getJobAndPerformance() {
		return jobAndPerformance;
	}

	public void setJobAndPerformance(String jobAndPerformance) {
		this.jobAndPerformance = jobAndPerformance;
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
			params.add(companyType);
			params.add(companySize);
			params.add(companyIndustry);
			params.add(companyDesc);
			params.add(position);
			params.add(monthlySalary);
			params.add(annualSalary);
			params.add(companyArea);
			params.add(departMent);
			params.add(jobAndPerformance);
			params.add(directLeader);
			params.add(underling);
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_WORK_EXPERIENCE, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "WorkExperience [beginTime=" + beginTime + ", endTime=" + endTime + ", company=" + company
				+ ", companyType=" + companyType + ", companySize=" + companySize + ", companyIndustry="
				+ companyIndustry + ", companyDesc=" + companyDesc + ", position=" + position + ", monthlySalary="
				+ monthlySalary + ", annualSalary=" + annualSalary + ", companyArea=" + companyArea + ", departMent="
				+ departMent + ", jobAndPerformance=" + jobAndPerformance + ", getBeginTime()=" + getBeginTime()
				+ ", getEndTime()=" + getEndTime() + ", getCompany()=" + getCompany() + ", getCompanyType()="
				+ getCompanyType() + ", getCompanySize()=" + getCompanySize() + ", getCompanyIndustry()="
				+ getCompanyIndustry() + ", getCompanyDesc()=" + getCompanyDesc() + ", getPosition()=" + getPosition()
				+ ", getMonthlySalary()=" + getMonthlySalary() + ", getAnnualSalary()=" + getAnnualSalary()
				+ ", getCompanyArea()=" + getCompanyArea() + ", getDepartMent()=" + getDepartMent()
				+ ", getJobAndPerformance()=" + getJobAndPerformance() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
