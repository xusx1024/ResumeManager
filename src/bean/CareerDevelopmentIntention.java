package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 职业发展意向
 * 
 * @author sxx.xu
 *
 */
public class CareerDevelopmentIntention {
	/** 期望行业. */
	private String execptIndustry;
	/** 期望职位. */
	private String execptPosition;
	/** 期望地点. */
	private String execptCity;
	/** 期望薪水-单位(万). */
	private int execptSalary;
	/** 勿推企业. */
	private String ignoreCompany;

	public String getExecptIndustry() {
		return execptIndustry;
	}

	public void setExecptIndustry(String execptIndustry) {
		this.execptIndustry = execptIndustry;
	}

	public String getExecptPosition() {
		return execptPosition;
	}

	public void setExecptPosition(String execptPosition) {
		this.execptPosition = execptPosition;
	}

	public String getExecptCity() {
		return execptCity;
	}

	public void setExecptCity(String execptCity) {
		this.execptCity = execptCity;
	}

	public int getExecptSalary() {
		return execptSalary;
	}

	public void setExecptSalary(int execptSalary) {
		this.execptSalary = execptSalary;
	}

	public String getIgnoreCompany() {
		return ignoreCompany;
	}

	public void setIgnoreCompany(String ignoreCompany) {
		this.ignoreCompany = ignoreCompany;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((execptCity == null) ? 0 : execptCity.hashCode());
		result = prime * result + ((execptIndustry == null) ? 0 : execptIndustry.hashCode());
		result = prime * result + ((execptPosition == null) ? 0 : execptPosition.hashCode());
		result = prime * result + execptSalary;
		result = prime * result + ((ignoreCompany == null) ? 0 : ignoreCompany.hashCode());
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
		CareerDevelopmentIntention other = (CareerDevelopmentIntention) obj;
		if (execptCity == null) {
			if (other.execptCity != null)
				return false;
		} else if (!execptCity.equals(other.execptCity))
			return false;
		if (execptIndustry == null) {
			if (other.execptIndustry != null)
				return false;
		} else if (!execptIndustry.equals(other.execptIndustry))
			return false;
		if (execptPosition == null) {
			if (other.execptPosition != null)
				return false;
		} else if (!execptPosition.equals(other.execptPosition))
			return false;
		if (execptSalary != other.execptSalary)
			return false;
		if (ignoreCompany == null) {
			if (other.ignoreCompany != null)
				return false;
		} else if (!ignoreCompany.equals(other.ignoreCompany))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CareerDevelopmentIntention [execptIndustry=" + execptIndustry + ", execptPosition=" + execptPosition
				+ ", execptCity=" + execptCity + ", execptSalary=" + execptSalary + ", ignoreCompany=" + ignoreCompany
				+ "]";
	}

	public void insert(String uUId) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(uUId);
			params.add(execptIndustry);
			params.add(execptPosition);
			params.add(execptCity);
			params.add(execptSalary);
			params.add(ignoreCompany);
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_CAREER_DEV_INTENT, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
