package kr.ac.mju.cs.controller;

public class AccountConstants {

	public final static String INSERT_USER = "insert into user(id,password,name,email,photo,category) values(?,?,?,?,?,?)";
	public final static String INSERT_STUDENT = "insert into student(study,email) values(?,?)";
	public final static String INSERT_NON_MEMBER = "insert into nonmember(nonmember_option_id,email) values(?,?)";

	
	public final static String DELETE_USER_BY_EMAIL = "delete from user where email=?";
	public final static String DELETE_USER_BY_ID = "delete from user where id=?";
		
	public static final String FIND_USER_BY_ID =  "select * from user where id=?";
	public static final String FIND_USER_BY_EMAIL =  "select * from user where email=?";
	
	public static final String MODIFY_USER = "update user set password=?, name=?, email=?, active=? where id=?";
	
	public static String SELECT_PROFESSOR = "select * from professor where email = ?";
	public static String SELECT_STAFF = "select * from staff where email = ?";
	public static String SELECT_STUDENT= "select * from student where email = ?";
	public static String SELECT_NONMEMBER = "select * from nonmember where email = ?";
}