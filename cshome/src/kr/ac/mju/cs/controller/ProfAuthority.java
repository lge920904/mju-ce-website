package kr.ac.mju.cs.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.sun.corba.se.impl.protocol.giopmsgheaders.ProfileAddr;

public class ProfAuthority {
	private DBAdapter adapter = new DBAdapter();
	private HashMap<Integer,String> profEmailMap = new HashMap<Integer,String>();
	private HashMap<Integer,String> profBoardInfoMap = new HashMap<Integer,String>();
	private HashMap<String,Integer> profBoardMap = new HashMap<String,Integer>();
	private HashMap<String,String> profIdMap = new HashMap<String,String>();
	private HashMap<Integer,String> profNameMap = new HashMap<Integer,String>();
	private String[] profId;
	private String[] profName;
	private String[] profEmail;
	
	public ProfAuthority(){
		selectProfId();
		putProfIdMap();
	}
	
	public void putProfIdMap(){
		String key = "prof-";
		for(int i = 1; i <= this.profId.length; i++){
			this.profIdMap.put(this.profId[i-1], key+i);
			this.profIdMap.put(this.profEmail[i-1], key+i);
			this.profBoardMap.put(key+i, i);
			this.profNameMap.put(i, this.profName[i-1]);
			this.profEmailMap.put(i, this.profEmail[i-1]);
			this.profBoardInfoMap.put(i, this.profId[i-1]);
		}
	}
	
	public String[] getNameOfProf(){
		return this.profName;
	}
	
	public void selectProfId(){
		int i = 0;
		int numOfProf = 0;
		Connection conn = adapter.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(id) from professor";
		System.out.println(sql);
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				numOfProf = rs.getInt(1);
			}
			
			sql = "select id, engName, email from professor order by profList";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			this.profId = new String[numOfProf];
			this.profName = new String[numOfProf];
			this.profEmail = new String[numOfProf];
			
			while(rs.next()){
				this.profId[i] = rs.getString(1);
				this.profName[i] = rs.getString(2);
				this.profEmail[i] = rs.getString(3);
				System.out.println("name:"+this.profName[i]);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			adapter.disConnect(conn, pstmt, rs);
		}
	}

	/**
	 *사용자별 게시판 확인
	 *@author Jinhun Kang
	 *@param boardID, userId 
	 */
	
	public String getAuthorityValue(String boardId){
		String result = null;
		int checkBoard;
		
		if(boardId.contains("prof-")){
			checkBoard = this.profBoardMap.get(boardId);
			result = this.profBoardInfoMap.get(checkBoard);
		}
		
		return result;
	}
	
	public boolean checkProfAuth(String boardId, String id){
		boolean result = false;

		if(boardId.equals(profIdMap.get(id))){
			result = true;
		}
				
		return result;
	}
}
