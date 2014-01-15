package kr.ac.mju.cs.controller;

public class AccountConstants {

	public final static String INSERT_USER = "insert into user(id,password,name,email,photo,category) values(?,?,?,?,?,?)";
	public final static String INSERT_STUDENT = "insert into student(study,email) values(?,?)";
	public final static String INSERT_PROFESSOR = "insert into professor(major,email) values(?,?)";
	public final static String INSERT_STAFF = "insert into staff(department,email) values(?,?)";
	
	public final static String DELETE_USER_BY_EMAIL = "delete from user where email=?";
	public final static String DELETE_USER_BY_ID = "delete from user where id=?";
	
	public static final String UPDATE_USER = "update user set id=?, password=?, name=?, email=?, photo=?";
	public static final String UPDATE_STUDENT = "update user natural join student set id=?, password=?, name=?, email=?, photo=?, study=? where email=?";
	public static final String UPDATE_PROFESSOR = "update user natural join professor set id=?, password=?, name=?, email=?, photo=?, major=? where email=?";
	public static final String UPDATE_STAFF = "update user natural join staff set id=?, password=?, name=?, email=?, photo=?, department=? where email=?";
	
	public static final String DOUBLECHECK_BY_ID =  "select id from user where id=?";
	public static final String DOUBLECHECK_BY_EMAIL =  "select email from user where email=?";
	
	public static final String LOGIN_BY_ID = "select * from user where id=? AND password=?";
	public static final String LOGIN_BY_EMAIL = "select * from user where email=? AND password=?";
}