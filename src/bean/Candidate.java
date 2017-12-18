package bean;

import java.sql.Date;
import java.util.List;

/**
 * 候选人
 * 
 * @author sxx.xu
 *
 */
public class Candidate {
	/** 求职状态. */
	private String resumeState;
	/** 主动应聘职位. */
	private String likePosition;
	/** 简历编号信息. */
	private String resumeNumber;
	/** 简历更新时间. */
	private Date resumeUpdateTime;
	/** 个人信息. */
	private PersonalInfo personalInfo;
	/** 工作经历. */
	private List<WorkExperience> workExperiences;
	/** 项目经历. */
	private List<ProjectExperience> projectExperiences;
	/** 教育经历. */
	private List<EducationExperience> educationExperiences;
	/** 语言能力. */
	private List<LanguageSkills> languageSkills;
	/** 自我评价. */
	private SelfEvaluation SelfEvaluation;
	/** 附加信息. */
	private ExtraInfo extraInfo;

	public String getResumeState() {
		return resumeState;
	}

	public void setResumeState(String resumeState) {
		this.resumeState = resumeState;
	}

	public String getLikePosition() {
		return likePosition;
	}

	public void setLikePosition(String likePosition) {
		this.likePosition = likePosition;
	}

	public String getResumeNumber() {
		return resumeNumber;
	}

	public void setResumeNumber(String resumeNumber) {
		this.resumeNumber = resumeNumber;
	}

	public Date getResumeUpdateTime() {
		return resumeUpdateTime;
	}

	public void setResumeUpdateTime(Date resumeUpdateTime) {
		this.resumeUpdateTime = resumeUpdateTime;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<WorkExperience> getWorkExperiences() {
		return workExperiences;
	}

	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	public List<ProjectExperience> getProjectExperiences() {
		return projectExperiences;
	}

	public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
		this.projectExperiences = projectExperiences;
	}

	public List<EducationExperience> getEducationExperience() {
		return educationExperiences;
	}

	public void setEducationExperience(List<EducationExperience> educationExperience) {
		this.educationExperiences = educationExperience;
	}

	public List<LanguageSkills> getLanguageSkills() {
		return languageSkills;
	}

	public void setLanguageSkills(List<LanguageSkills> languageSkills) {
		this.languageSkills = languageSkills;
	}

	public SelfEvaluation getSelfEvaluation() {
		return SelfEvaluation;
	}

	public void setSelfEvaluation(SelfEvaluation selfEvaluation) {
		SelfEvaluation = selfEvaluation;
	}

	public ExtraInfo getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(ExtraInfo extraInfo) {
		this.extraInfo = extraInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SelfEvaluation == null) ? 0 : SelfEvaluation.hashCode());
		result = prime * result + ((educationExperiences == null) ? 0 : educationExperiences.hashCode());
		result = prime * result + ((extraInfo == null) ? 0 : extraInfo.hashCode());
		result = prime * result + ((languageSkills == null) ? 0 : languageSkills.hashCode());
		result = prime * result + ((likePosition == null) ? 0 : likePosition.hashCode());
		result = prime * result + ((personalInfo == null) ? 0 : personalInfo.hashCode());
		result = prime * result + ((projectExperiences == null) ? 0 : projectExperiences.hashCode());
		result = prime * result + ((resumeNumber == null) ? 0 : resumeNumber.hashCode());
		result = prime * result + ((resumeState == null) ? 0 : resumeState.hashCode());
		result = prime * result + ((resumeUpdateTime == null) ? 0 : resumeUpdateTime.hashCode());
		result = prime * result + ((workExperiences == null) ? 0 : workExperiences.hashCode());
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
		Candidate other = (Candidate) obj;
		if (SelfEvaluation == null) {
			if (other.SelfEvaluation != null)
				return false;
		} else if (!SelfEvaluation.equals(other.SelfEvaluation))
			return false;
		if (educationExperiences == null) {
			if (other.educationExperiences != null)
				return false;
		} else if (!educationExperiences.equals(other.educationExperiences))
			return false;
		if (extraInfo == null) {
			if (other.extraInfo != null)
				return false;
		} else if (!extraInfo.equals(other.extraInfo))
			return false;
		if (languageSkills == null) {
			if (other.languageSkills != null)
				return false;
		} else if (!languageSkills.equals(other.languageSkills))
			return false;
		if (likePosition == null) {
			if (other.likePosition != null)
				return false;
		} else if (!likePosition.equals(other.likePosition))
			return false;
		if (personalInfo == null) {
			if (other.personalInfo != null)
				return false;
		} else if (!personalInfo.equals(other.personalInfo))
			return false;
		if (projectExperiences == null) {
			if (other.projectExperiences != null)
				return false;
		} else if (!projectExperiences.equals(other.projectExperiences))
			return false;
		if (resumeNumber == null) {
			if (other.resumeNumber != null)
				return false;
		} else if (!resumeNumber.equals(other.resumeNumber))
			return false;
		if (resumeState == null) {
			if (other.resumeState != null)
				return false;
		} else if (!resumeState.equals(other.resumeState))
			return false;
		if (resumeUpdateTime == null) {
			if (other.resumeUpdateTime != null)
				return false;
		} else if (!resumeUpdateTime.equals(other.resumeUpdateTime))
			return false;
		if (workExperiences == null) {
			if (other.workExperiences != null)
				return false;
		} else if (!workExperiences.equals(other.workExperiences))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [resumeState=" + resumeState + ", likePosition=" + likePosition + ", resumeNumber="
				+ resumeNumber + ", resumeUpdateTime=" + resumeUpdateTime + ", personalInfo=" + personalInfo
				+ ", workExperiences=" + workExperiences + ", projectExperiences=" + projectExperiences
				+ ", educationExperience=" + educationExperiences + ", languageSkills=" + languageSkills
				+ ", SelfEvaluation=" + SelfEvaluation + ", extraInfo=" + extraInfo + ", getResumeState()="
				+ getResumeState() + ", getLikePosition()=" + getLikePosition() + ", getResumeNumber()="
				+ getResumeNumber() + ", getResumeUpdateTime()=" + getResumeUpdateTime() + ", getPersonalInfo()="
				+ getPersonalInfo() + ", getWorkExperiences()=" + getWorkExperiences() + ", getProjectExperiences()="
				+ getProjectExperiences() + ", getEducationExperience()=" + getEducationExperience()
				+ ", getLanguageSkills()=" + getLanguageSkills() + ", getSelfEvaluation()=" + getSelfEvaluation()
				+ ", getExtraInfo()=" + getExtraInfo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
