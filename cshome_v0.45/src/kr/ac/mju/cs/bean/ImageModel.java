package kr.ac.mju.cs.bean;

import java.sql.Blob;

import javax.servlet.http.Part;

public class ImageModel {
	private int image_id;
	private Part image_save;
	private Blob image_file;
	private int board_id;
	
	public ImageModel() {
		// TODO Auto-generated constructor stub
	}
	
	public int getImage_id() {
		return image_id;
	}
	public Part getImage_save() {
		return image_save;
	}
	public Blob getImage_file() {
		return image_file;
	}
	public int getBoard_id() {
		return board_id;
	}
	
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public void setImage_save(Part image_save) {
		this.image_save = image_save;
	}
	public void setImage_file(Blob image_file) {
		this.image_file = image_file;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
}
