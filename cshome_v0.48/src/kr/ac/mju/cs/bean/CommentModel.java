package kr.ac.mju.cs.bean;

public class CommentModel {
	/** comment_pk */
    private int comment_id;

    /** 사용자 */
    private String author_email;
    
    /** 내용 */
    private String postscript;
    
    /** 등록일 */
    private String date;
    
    /** 댓글이 등록된 board_id */
    private int board_id;
    
    /** 수정일? */
    private String modDate;
    /** ip */
    private String ip;
    
    
    
    public CommentModel() {
    }
    public int getCommentId() {
		return comment_id;
	}
    public String getId() {
		return author_email;
	}
    public String getPostscript() {
		return postscript;
	}
    public int getBoardId() {
		return board_id;
	}
    public String getIp() {
		return ip;
	}
    public String getDate() {
		return date;
	}
    public String getModDate() {
		return modDate;
	}
    public void setCommentId(int comment_id) {
		this.comment_id = comment_id;
	}
    public void setId(String author_email) {
		this.author_email = author_email;
	}
    public void setPostscript(String postscript) {
		this.postscript = postscript;
	}
    public void setBoardId(int board_id) {
		this.board_id = board_id;
	}
    public void setIp(String ip) {
		this.ip = ip;
	}
    public void setDate(String date) {
		this.date = date;
	}
    public void setModDate(String modDate) {
		this.modDate = modDate;
	}
}
