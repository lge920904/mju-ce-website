package kr.ac.mju.cs.bean;

import java.io.File;

public class NonMember extends User {
	private int option;

	public static enum NON_MEMBER_OPTION {
		company(1, "기업"), parent(2, "학부모"), student(3, "학생");
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
			File photo, int category, int option) {
		// TODO Auto-generated constructor stub
		super(id, password, name, email, photo, category);
		this.option = option;
	}
	public NonMember(User user, int option) {
		super(user.getId(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoto(), user.getCategory(), user.getActive());
		this.option = option;
	}
	public int getOption() {
		return option;
	}
	public void setOption(int option) {
		this.option = option;
	}
}
