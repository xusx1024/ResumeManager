package database;

public final class SQLConstant {

	private SQLConstant() {
	}

	/**
	 * 插入个人信息
	 */
	public static final String INSERT_PERSONAL_INFO = "insert into personal_info "
			+ "(id, name,name_pinyin,nick_name,gender,birthday,mobile,age,email,"
			+ "hightestEdu,wrokYears,isMarried,workCity,homeCity,position,company,filePath,lastEditTime,destCompany,markTxt) "
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 插入职业发展意向
	 */
	public static final String INSERT_CAREER_DEV_INTENT = "insert into career_development_intention"
			+ "(id,execptIndustry,execptPosition,execptCity,execptSalary,ignoreCompany) " + "values (?,?,?,?,?,?)";
	/**
	 * 插入职业现状
	 */
	public static final String INSERT_CURRENT_JOB_POFILE = "insert into current_job_pofile"
			+ "(id,currentIndustry,company,position,annualSalary,monthlySalary) " + "values (?,?,?,?,?,?)";
	/**
	 * 插入教育经历
	 */
	public static final String INSERT_EDUCATION_EXPERIENCE = "insert into education_experience"
			+ "(id,school,beginTime,endTime,discipline,edu,isTongZhao) " + "values (?,?,?,?,?,?,?)";
	/**
	 * 插入项目经历
	 */
	public static final String INSERT_PROJECT_EXPERIENCE = "insert into project_experience"
			+ "(id,begin_time,end_time,company,projectPosition,projectDesc,projectResponse,projectPerformance) "
			+ "values (?,?,?,?,?,?,?,?)";
	/**
	 * 插入公司经历
	 */
	public static final String INSERT_WORK_EXPERIENCE = "insert into work_experience"
			+ "(id,begin_time,end_time,company,companyType,companySize,companyIndustry,companyDesc,position,"
			+ "monthlySalary,annualSalary,companyArea,departMent,jobAndPerformance,directLeader,underling) "
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	/**
	 * 插入附加信息
	 */
	public static final String INSERT_EXTRA_INFO = "insert into extra_info" + "(id,content) " + "values (?,?)";
	/**
	 * 插入语言
	 */
	public static final String INSERT_LANGUAGE_SKILL = "insert into language_skill" + "(id,language) " + "values (?,?)";
	/**
	 * 插入自我评价
	 */
	public static final String INSERT_SELF_EVALUATION = "insert into self_evaluation" + "(id,content) "
			+ "values (?,?)";

	/**
	 * 根据姓名,邮箱查询是否存在该用户
	 */
	public static final String QUERY_PERSONAL = "select * from personal_info where name= ? and email= ? ";
	/**
	 * 根据姓名查询是否存在该用户
	 */
	public static final String QUERY_BY_NAME = "select * from personal_info where name= ?";
	/**
	 * 根据ID查询是否存在该用户
	 */
	public static final String QUERY_BY_ID = "select * from personal_info where id= ?";
	/**
	 * 更新备注
	 */
	public static final String UPDATE_MARK_TEXT = "update personal_info set markTxt = ? ,lastEditTime = ? where id = ?";
	/**
	 * 更新推荐公司
	 */
	public static final String UPDATE_RECOMMEND_COMPANY = "update personal_info set recommendCompany = ?,lastEditTime = ? where id = ?";
}
