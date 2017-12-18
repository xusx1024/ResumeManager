package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 附加信息
 * 
 * @author sxx.xu
 *
 */
public class ExtraInfo extends SelfEvaluation {

	public void insert(String uUId2) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			for (String content : getContents()) {
				List<Object> params = new ArrayList<Object>();
				params.add(uUId2);
				params.add(content);
				jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_EXTRA_INFO, params);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
