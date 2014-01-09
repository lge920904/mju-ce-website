package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBAdapter {

	protected Connection conn = null;
	private final static String dbUrl = "jdbc:mysql://ce.mju.ac.kr/testD";
	private final static String dbUser = "lgetest";
	private final static String dbPassword = "dlrkdmf0904";

	private void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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

	protected void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
	}	

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

	public void disConnect(Connection conn, PreparedStatement pstmt) {
		// TODO Auto-generated method stub

	}

	public void disConnect(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
}

