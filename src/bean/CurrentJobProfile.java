package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 目前职业概况
 * 
 * @author sxx.xu
 *
 */
public class CurrentJobProfile {
	/** 当前行业. */
	private String currentIndustry;
	/** 公司名字. */
	private String company;
	/** 职位. */
	private String position;
	/** 年薪. */
	private int annualSalary;
	/** 月薪. */
	private int monthlySalary;

	public String getCurrentIndustry() {
		return currentIndustry;
	}

	public void setCurrentIndustry(String currentIndustry) {
		this.currentIndustry = currentIndustry;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public float getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annualSalary;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((currentIndustry == null) ? 0 : currentIndustry.hashCode());
		result = prime * result + monthlySalary;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		CurrentJobProfile other = (CurrentJobProfile) obj;
		if (annualSalary != other.annualSalary)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (currentIndustry == null) {
			if (other.currentIndustry != null)
				return false;
		} else if (!currentIndustry.equals(other.currentIndustry))
			return false;
		if (monthlySalary != other.monthlySalary)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrentJobProfile [currentIndustry=" + currentIndustry + ", company=" + company + ", position="
				+ position + ", annualSalary=" + annualSalary + ", monthlySalary=" + monthlySalary + "]";
	}

	public void insert(String uUId2) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(uUId2);
			params.add(currentIndustry);
			params.add(company);
			params.add(position);
			params.add(annualSalary);
			params.add(monthlySalary);
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_CURRENT_JOB_POFILE, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
