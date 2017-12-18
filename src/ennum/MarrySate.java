package ennum;

/**
 * 婚姻状态
 * 
 * @author sxx.xu
 *
 */
public enum MarrySate {
	YES, NO, UNKNOW;
	public static MarrySate get(String str) {
		if ("已婚".equals(str))
			return YES;
		else if ("未婚".equals(str))
			return NO;
		else
			return UNKNOW;
	}

	public static String get(MarrySate state) {
		switch (state) {
		case YES:
			return "已婚";
		case NO:
			return "未婚";
		case UNKNOW:
			return "未知";
		default:
			return "已婚";
		}
	}
}
