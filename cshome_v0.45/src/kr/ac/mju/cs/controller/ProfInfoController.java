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
		String sql = "select * from professor order by profList";
		profList = new ArrayList<Professor>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(2));
				prof = new Professor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(10));
				this.profList.add(prof);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			adapter.disConnect(conn, pstmt, rs);
		}
			
		return this.profList;
	}
	
	public void modifyProfInfo(Professor prof){
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		String sql = "update professor major=?, engName=?, roomPhone=?, position=?, comment=?, homepage=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prof.getMajor());
			pstmt.setString(2, prof.getEngName());
			pstmt.setString(3, prof.getRoomPhone());
			pstmt.setString(4, prof.getPosition());
			pstmt.setString(5, prof.getComment());
			pstmt.setString(6, prof.getHomepage());
			pstmt.setString(7, prof.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			adapter.disConnect(conn, pstmt);
		}
	}
}
