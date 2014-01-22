package kr.ac.mju.cs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.ac.mju.cs.bean.Professor;

public class ProfInfoController {
	private DBAdapter adapter = new DBAdapter();
	private ArrayList<Professor> profList;
	
	public ArrayList<Professor> selecProfInfo(){
		Professor prof;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select profList, engName, major, roomPhone, position, comment, emid from professor order by profList";
		profList = new ArrayList<Professor>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(2));
//				prof = new Professor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
//				this.profList.add(prof);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			adapter.disConnect(conn, pstmt, rs);
		}
			
		return this.profList;
	}
}
