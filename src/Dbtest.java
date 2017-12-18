import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

public class Dbtest {
	public static void main(String[] args) {
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
		String sql = "insert into stu (name, number) values (?, ?), (?, ?), (?, ?)";
		sql = SQLConstant.INSERT_PERSONAL_INFO;
		List<Object> params = new ArrayList<Object>();
		params.add("小明");
		 
		try {
			boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
