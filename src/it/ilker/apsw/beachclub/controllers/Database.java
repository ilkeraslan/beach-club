package it.ilker.apsw.beachclub.controllers;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import it.ilker.apsw.beachclub.models.Query;

public class Database {
	public static final int RESULT = 1;
	public static final int NORESULT = 2;
	public static final int ERROR = 3;

	public static void execute(Query q) {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/aslan-beachclub");
			try (
				Connection connection = ds.getConnection(); 
				Statement statement = connection.createStatement()
			) {
				boolean b = statement.execute(q.getSQL());
				if (b) {
					q.setResult(statement.getResultSet());
				} else {
					q.setUpdateCount(statement.getUpdateCount());
				}
			}
		} catch (Exception exc) {
			q.setExceptionMessage(exc.getMessage());
		}

	}
}
