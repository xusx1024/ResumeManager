package ennum;

/**
 * 性别
 * 
 * @author sxx.xu
 *
 */
public enum Gender {
	/** 男. */
	MALE(1),
	/** 女. */
	FEMALE(0),
	/** 保密. */
	UNKNOW(-1);

	private int genderValue;

	private Gender(int genderValue) {
		this.setGenderValue(genderValue);
	}

	public int getGenderValue() {
		return genderValue;
	}

	private void setGenderValue(int genderValue) {
		this.genderValue = genderValue;
	}

	public static Gender get(String s) {
		if ("男".equals(s)) {
			return MALE;
		} else if ("女".equals(s)) {
			return FEMALE;
		} else {
			return UNKNOW;
		}
	}

	public static String get(Gender gender) {
		switch (gender) {
		case MALE:
			return "男";
		case FEMALE:
			return "女";
		case UNKNOW:
			return "保密";
		default:
			return "男";

		}
	}
}
