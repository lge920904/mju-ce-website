package kr.ac.mju.cs.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAdapter {

	private Connection conn = null;
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String dbUrl = "jdbc:mysql://ce.mju.ac.kr/testD?autoReconnect=true";
	private final static String dbUser = "lgetest";
	private final static String dbPassword = "dlrkdmf0904";

	/** 
	 * 
	 */
	private void loadDriver() {
		try {
			Class.forName(driver).newInstance();
			System.out.println("db load ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	/**
	 * connect DB
	 * @return
	 */
	public Connection connect() {
		try {
			loadDriver();
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			conn.setAutoCommit(false);
			System.out.println("dbadapter:"+conn);
			
		} catch (Exception e){
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
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
		if (conn != null) {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
			}
		}

	}

	/** 
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void disConnect(Connection conn, Statement stmt,
			ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
			}
		}
		
	}
}

