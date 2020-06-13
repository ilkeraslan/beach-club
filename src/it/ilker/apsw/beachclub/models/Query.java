package it.ilker.apsw.beachclub.models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import it.ilker.apsw.beachclub.controllers.Database;

public class Query {
	String sql;
	private int status = -1;
	private List<List<String>> result = new ArrayList<>();
	private int uc = 0;
	private String exc = null;

	public Query(String sql) {
		this.sql = sql;
	}

	public String getSQL() {
		return sql;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<List<String>> getResult() {
		return result;
	}

	public void setResult(ResultSet rs) {
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			// table header
			List<String> header = new ArrayList<>();
			for (int i = 0; i < columnCount; i++) {
				header.add(rsmd.getColumnLabel(i + 1));
			}
			result.add(header);
			
			// the data
			while (rs.next()) {
				List<String> row = new ArrayList<>();
				for (int i = 0; i < columnCount; i++) {
					row.add(rs.getString(i + 1));
				}
				result.add(row);
			}
			setStatus(Database.RESULT);
		} catch (Exception exc) {
			setExceptionMessage(exc.getMessage());
			setStatus(Database.ERROR);
		}
	}

	public int getUpdateCount() {
		return uc;
	}

	public void setUpdateCount(int uc) {
		this.uc = uc;
		setStatus(Database.NORESULT);
	}

	public String getExceptionMessage() {
		return exc;
	}

	public void setExceptionMessage(String exc) {
		this.exc = exc;
		setStatus(Database.ERROR);
	}
}
