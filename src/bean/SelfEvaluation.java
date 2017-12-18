package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUtils;
import database.SQLConstant;

/**
 * 自我评价
 * 
 * @author sxx.xu
 *
 */
public class SelfEvaluation {
	/** 有人可能会写个1,2,3,4. */
	private List<String> contents;

	public SelfEvaluation() {
		contents = new ArrayList<String>();
	}

	public void add(String item) {
		contents.add(item);
	}

	public void clear() {
		contents.clear();
	}

	public List<String> getContents() {
		return contents;
	}

	public void insert(String uUId2) {
		try {
			JdbcUtils jdbcUtils = new JdbcUtils();
			jdbcUtils.getConnection();
			for (String content : getContents()) {
				List<Object> params = new ArrayList<Object>();
				params.add(uUId2);
				params.add(content);
				jdbcUtils.updateByPreparedStatement(SQLConstant.INSERT_SELF_EVALUATION, params);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
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
		SelfEvaluation other = (SelfEvaluation) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SelfEvaluation [contents=" + contents + "]";
	}

}
