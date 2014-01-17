package kr.ac.mju.cs.bean;

import java.io.File;

public class NonMember extends User {
	private String option;

	public static enum NON_MEMBER_OPTION {
		business(1, "기업"), parent(2, "학부모"), student(3, "학생");
		int index;
		String value;

		NON_MEMBER_OPTION(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public String getValue() {
			return value;
		}
	}

	public NonMember(String id, String password, String name, String email,
			File photo, int category, String option) {
		// TODO Auto-generated constructor stub
		super(id, password, name, email, photo, category);
		this.option = option;
	}
	public NonMember(String id, String password, String name, String email,
			File photo, int category, int option) {
		// TODO Auto-generated constructor stub
		super(id, password, name, email, photo, category);
		this.option = findValueByIndex(option);
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String findValueByIndex(int index){
		if(index == 1){
			return NON_MEMBER_OPTION.business.getValue();
		}else if(index == 2){
			return NON_MEMBER_OPTION.parent.getValue();
		}else if(index == 3){
			return NON_MEMBER_OPTION.student.getValue();
		}else{
			return "기타";
		}
	}
	
}
