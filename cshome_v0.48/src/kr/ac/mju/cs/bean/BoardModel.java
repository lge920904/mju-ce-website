package kr.ac.mju.cs.bean;

import java.sql.Blob;

import javax.servlet.http.Part;


public class BoardModel {
	/** board_pk */
    private int board_id;
    /** 말머리 */
    private String tab;
    /** 제목 */
    private String title;
    /** 사용자 아이디 */
    private String author_email;
    /** 내용 */
    private String content;
    /** 조회수 */
    private int hit;
    /** 등록일 */
    private String date;
    /**  이미지 파일 저장 */
    private Part image;
    /** 이미지 불러오기 용 */
    private Blob Bimage;
    
    /** 게시판 번호 */
    private int num;
    /** 댓글 수 */
    private int count;
    
    //////////////////////////////////////
    /** 수정일? */
    private String modDate;
    /** ip */
    private String ip;
    //////////////////////////////////////
    
    public BoardModel() {
    	hit = 0;
    }
    public int getNum() {
		return num;
	}
    public int getCount() {
		return count;
	}
    public void setCount(int count) {
		this.count = count;
	}
    
    public String getTab() {
		return tab;
	}
    public int getBoardId() {
		return board_id;
	}
    public String getTitle() {
		return title;
	}
    public String getId() {
		return author_email;
	}
    public String getContent() {
		return content;
	}
    public String getIp() {
		return ip;
	}
    public int getHit() {
		return hit;
	}
    public String getDate() {
		return date;
	}
    public String getModDate() {
		return modDate;
	}
    public Part getImage() {
		return image;
	}
    public Blob getBimage() {
		return Bimage;
	}
    public void setNum(int num) {
		this.num = num;
	}
    public void setTab(String tab) {
		this.tab = tab;
	}
    public void setBoardId(int board_pk) {
		this.board_id = board_pk;
	}
    public void setTitle(String subject) {
		this.title = subject;
	}
    public void setId(String author_email) {
		this.author_email = author_email;
	}
    public void setContent(String content) {
		this.content = content;
	}
    public void setIp(String ip) {
		this.ip = ip;
	}
    public void setHit(int hit) {
		this.hit = hit;
	}
    public void setDate(String date) {
		this.date = date;
	}
    public void setModDate(String modDate) {
		this.modDate = modDate;
	}
    public void setImage(Part image) {
		this.image = image;
	}
    public void setBimage(Blob bimage) {
		Bimage = bimage;
	}
}
