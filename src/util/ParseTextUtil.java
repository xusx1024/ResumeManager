package util;

public class ParseTextUtil {

	/**
	 * 从字符串中提取数字<br/>
	 * eg:10年工作年限<br/>
	 * 264.0万年薪
	 * 
	 * @param s
	 * @return
	 */
	public static int getNumberFromStr(String s) {
		char mid = 'a';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			mid = s.charAt(i);
			if (mid >= 48 && mid <= 57) {
				sb.append(mid);
			} else if (mid == '.') {
				sb.append(mid);
			}
		}
		if (sb.length() == 0)
			return 0;
		String ans = sb.toString();
		if (ans.contains(".")) {
			ans = ans.substring(0, ans.indexOf("."));
		}
		return Integer.parseInt(ans);
	}

	/**
	 * 从字符串中获取年薪
	 * 
	 * @param s
	 * @return
	 */
	public static int getSalaryFormStr(String s) {
		char key1 = '万';
		char key2 = 'w';
		char key3 = 'W';
		char current = s.charAt(0);
		String destStr = s;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			current = s.charAt(i);
			if (current == key1 || current == key2 || current == key3) {
				destStr = s.substring(0, i);
				break;
			}
		}
		return getNumberFromStr(destStr);
	}
}
