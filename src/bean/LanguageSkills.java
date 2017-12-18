package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 语言能力
 * 
 * @author sxx.xu
 *
 */
public class LanguageSkills {
	/**
	 * <english, cet4>
	 */
	private String kind;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void insert(String uUId2) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			List<Object> params = new ArrayList<Object>();
			params.add(uUId2);
			params.add(kind);
			jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_LANGUAGE_SKILL, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "LanguageSkills [kind=" + kind + "]";
	}

}
