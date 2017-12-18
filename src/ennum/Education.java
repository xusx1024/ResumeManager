package ennum;

/**
 * 学历
 * 
 * @author sxx.xu
 *
 */
public enum Education {
	/** 本科. */
	UNDERGRADUATE,
	/** 硕士. */
	MASTERS_DEGREE,
	/** 博士. */
	DOCTOR,
	/** 未知. */
	UNKNOWN;

	public static Education get(String s) {
		if ("本科".equals(s)) {
			return Education.UNDERGRADUATE;
		} else if ("硕士".equals(s)) {
			return Education.MASTERS_DEGREE;
		} else if ("博士".equals(s)) {
			return Education.DOCTOR;
		} else {
			return Education.UNKNOWN;
		}

	}

	public static String get(Education ede) {
		switch (ede) {
		case UNDERGRADUATE:
			return "本科";
		case MASTERS_DEGREE:
			return "硕士";
		case DOCTOR:
			return "博士";
		case UNKNOWN:
			return "未知";
		default:
			return "本科";
		}
	}
}
