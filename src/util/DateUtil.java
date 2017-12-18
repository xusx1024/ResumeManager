package util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 时间工具类
 * 
 * @author sxx.xu
 *
 */
public class DateUtil {

	/**
	 * 转化2017-11-21 17:40:27 ==> java.sql.Date
	 * 
	 * @param time
	 * @return
	 */
	public static Date transTime2Date(String time) {
		Date sqlDate = new Date(System.currentTimeMillis());
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			sqlDate = new Date(format.parse(time).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
}
