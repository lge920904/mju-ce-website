package kr.ac.mju.cs.constants;

/* 코드 바뀐 부분은 userInfo, Email, CEActive 이부분 입니당 . */

final public class Alter {
	
	/*
	 * UserInfoCheckServlet
	 */
	
	/* servlet setting */
	public final static String ENCODING = "utf-8";
	public final static String CONTENT_TYPE= "text/html;charset=UTF-8";
	
	/* ajax action type */
	public static enum AJAX_ACTION {password, acc_stuid, stuid, phone, authenticode, email} 
	public static enum AJAX_PARAMETER {query, action, password}
	
	/* open span */
	public final static String WRONG_ALTER_OPEN_SPAN = "<span>";
	public final static String RIGHT_ALTER_OPEN_SPAN = "<span class='checked'>";
	
	/* close span */
	public final static String CLOSE_SPAN = "</span>";
	
	/* password alter message */
	public final static String LEGAL_PASSWORD_ALTER_MESSAGE = "비밀번호가 일치합니다.";
	public final static String ILLEGAL_PASSWORD_ALTER_MESSAGE = "비밀번호가 일치하지 않습니다.";
	
	/* account active message */ 
	public final static String ACCOUNT_ALREADY_ACTIVE_MESSAGE = "계정이 이미 활성화 되어 있습니다.";
	public final static String ACCOUNT_ALBE_TO_ACTIVE_MESSAGE = "CEUnix 계정 신청 가능.";
	public final static String ILLEGAL_STUDENTID_ALTER_MESSAGE = "등록되지 않은 학번입니다. 올바른 학번을 입력하세요.";
	public final static String ACCOUNT_NOT_ACTIVE_MESSAGE = "계정이 활성화되지 않았습니다.";
	
	/* authenticode */
	public final static String SEND_AUTHENTICODE_MESSAGE = "인증코드를 전송하엿습니다.";
	public final static String LEGAL_AUTHENTICODE_MESSAGE = "인증이 완료되었습니다.";
	public final static String ILLEGAL_AUTHENTICODE_MESSAGE = "잘못된 인증코드입니다. 올바른 인증코드를 입력하세요.";
	
	/*
	 * EmailSender
	 */
	
	/* mail */
	public final static String AUTHENTICODE_SENDING_MAIL_MESSAGE = "CEUnix 인증코드 발송 메일";
	public final static String AUTHENTICODE_MAIL_CONTENT1 = "인증 코드는 ";
	public final static String AUTHENTICODE_MAIL_CONTENT2 = "입니다. 계정 활성화를 완료하시기 바랍니다.";
	
	/*
	 * CEActiveIDServlet
	 */
	
	public final static String ACCOUNT_ACTIVE_COMPLETE = "계정 생성이 완료되었습니다.";
}
