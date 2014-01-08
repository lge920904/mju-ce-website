package kr.ac.mju.cs.tool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAdapter {
	protected Connection con = null;
	private final static String dbUrl = "jdbc:mysql://localhost:3306/ceunix";
	private final static String dbRootUrl = "jdbc:mysql://localhost:3306/mysql";
	private final static String dbUser = "CEUnix";
	private final static String dbRoot = "root";
	private final static String dbPassword = "2rkdmf";
	private final static String dbRootPassword = "2rkdmf";

	private void loadDriver() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();	
	}

	public void connect() {
		try {
			loadDriver();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void rootConnect(){
		try {
			loadDriver();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dbRootUrl, dbRoot, dbRootPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	public boolean findUserId(String userId){
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			String query = "select userid where userid =\""+ userId + "\"";
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResultSet(rs);
			closeStatement(stmt);
		}
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

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	public boolean changeActive(String number) {
		try {
			Statement stmt = con.createStatement();
			String query = "UPDATE user SET active=1 WHERE stuid='"+number+"'";
			int result = stmt.executeUpdate(query);
			if(result>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public void changeAuthenticode(String number, String authenticode) {
		try{
			Statement stmt = con.createStatement();
			String query = "UPDATE user SET authenticode='"+authenticode+"' WHERE stuid='"+number+"'";
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changePassword(String number, String password) {
		// TODO Auto-generated method stub
		try{	
			Statement stmt = con.createStatement();
			String query = "UPDATE user SET password='"+password+"' WHERE stuid='"+number+"'";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean login(String userId, String password) {
		// TODO Auto-generated method stub
		return true;
	}
}
