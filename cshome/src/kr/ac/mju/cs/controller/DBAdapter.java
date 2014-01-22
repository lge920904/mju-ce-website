package kr.ac.mju.cs.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAdapter {

	protected Connection conn = null;
	private final static String dbUrl = "jdbc:mysql://ce.mju.ac.kr/testD";
	private final static String dbUser = "lgetest";
	private final static String dbPassword = "dlrkdmf0904";

	/** 
	 * 
	 */
	private void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * connect DB
	 * 
	 * @return
	 */
	public Connection connect() {
		loadDriver();
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
		return conn;
	}

	/**
	 * 
	 * @param conn
	 */
	public void disConnect(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	/**
	 * 
	 * @param conn
	 * @param stmt
	 */
	public void disConnect(Connection conn, Statement stmt) {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void disConnect(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
