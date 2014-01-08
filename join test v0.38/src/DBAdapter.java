import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;


public class DBAdapter {

	protected Connection con = null;
	private final static String dbUrl = "jdbc:mysql://ce.mju.ac.kr/testD";
	private final static String dbUser = "lgetest";
	private final static String dbPassword = "dlrkdmf0904";

	private void loadDriver() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();	
	}

	public Connection connect() {
		try {
			loadDriver();
			con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			return con;
		} catch (Exception e) {
			e.getMessage();
			return null;
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

	public void disConnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	
}

