package kr.ac.mju.cs.bean;

public class MenuConstants {

	public static enum HOMEMENU {
		DEPT("학과소개", "deptinfo.jsp?sub=outline"), GRADU("대학원소개",
				"graduinfo.jsp?sub=outline"), ABEEK("공학인증",
				"abeek.jsp?sub=outline"), NOTICE("공지사항",
				"notice.jsp?sub=notice"), COMMUNITY("커뮤니티",
				"community.jsp?sub=society");
		private String menuName;
		private String menuUrl;

		private HOMEMENU(String menuName, String menuUrl) {
			this.menuName = menuName;
			this.menuUrl = menuUrl;
		}

		public String getMenuName() {
			return menuName;
		}

		public String getMenuUrl() {
			return menuUrl;
		}
	}

	public static enum DEPTMENU {
		OUTLINE("outline", "학과소개", "Dept. Outline"), PROFESSOR("professor",
				"교수소개", "Professor Outline"), CURRICULUM("education", "교육목표",
				"Curriculum"), EDUROAD("education-roadmap", "교과과정 로드맵",
				"Education Roadmap"), DEPTEVENT("dept-event", "학과행사",
				"Dept. Event"), ADMISSIONS("admissions", "입학안내", "Admissions"), SCHOLARSHIP(
				"scholarship", "장학제도", "Scholarship"), LOCATION("location",
				"찾아오시는 길", "Location Information");
		private String subAction;
		private String subMenuName;
		private String subMenuDesc;

		private DEPTMENU(String subAction, String subMenuname,
				String subMenuDesc) {
			this.subAction = subAction;
			this.subMenuName = subMenuname;
			this.subMenuDesc = subMenuDesc;
		}

		public String getSubAction() {
			return subAction;
		}

		public String getSubMenuName() {
			return subMenuName;
		}

		public String getSubMenuDesc() {
			return subMenuDesc;
		}
	}

	public static enum GRADUMENU {
		OUTLINE("outline", "대학원소개", "Graduation School Outline"), LABORATORY(
				"laboratory", "연구실소개", "Laboratory Outline"), RULE("rule",
				"학과내규", "Dept. Rule"), GRADUMAJOR("gradu-major", "심화전공과목", "Graduation School Major");
		private String subAction;
		private String subMenuName;
		private String subMenuDesc;

		private GRADUMENU(String subAction, String subMenuname,
				String subMenuDesc) {
			this.subAction = subAction;
			this.subMenuName = subMenuname;
			this.subMenuDesc = subMenuDesc;
		}

		public String getSubAction() {
			return subAction;
		}

		public String getSubMenuName() {
			return subMenuName;
		}

		public String getSubMenuDesc() {
			return subMenuDesc;
		}
	}

	public static enum ABEEKMENU {
		OUTLINE("outline", "공학인증개요", "Abeek Outline & Process"), BENEFIT(
				"benefit", "도입목적 및 인증혜택", "Perpose & Benefit"), STANDARD(
				"standard", "인증기준", "Authority Standard"), PORTFOLIO(
				"portfolio", "포트폴리오", "Personal Portfolio");
		private String subAction;
		private String subMenuName;
		private String subMenuDesc;

		private ABEEKMENU(String subAction, String subMenuname,
				String subMenuDesc) {
			this.subAction = subAction;
			this.subMenuName = subMenuname;
			this.subMenuDesc = subMenuDesc;
		}

		public String getSubAction() {
			return subAction;
		}

		public String getSubMenuName() {
			return subMenuName;
		}

		public String getSubMenuDesc() {
			return subMenuDesc;
		}
	}

	public static enum NOTICEMENU {
		NOTICE("notice", "공지사항", "Notice"), SCHEDULE("dept-schedule", "학과일정",
				"Dept. Schedule"), RECRUIT("recruit", "구인/취업", "Recruit"), SERVAY(
				"servay", "설문조사", "Servay"), EQUIPMENT("equipment",
				"장비 및 시설 대여 신청", "Equipment & Facilitis"),  INCPERSONAL("increase-request", "증원신청", "Increase The Personal Requesting"), ITNEWS("recent-it",
				"최신 IT뉴스", "Recent IT News");
		private String subAction;
		private String subMenuName;
		private String subMenuDesc;

		private NOTICEMENU(String subAction, String subMenuname,
				String subMenuDesc) {
			this.subAction = subAction;
			this.subMenuName = subMenuname;
			this.subMenuDesc = subMenuDesc;
		}

		public String getSubAction() {
			return subAction;
		}

		public String getSubMenuName() {
			return subMenuName;
		}

		public String getSubMenuDesc() {
			return subMenuDesc;
		}
	}

	public static enum COMMUNITYMENU {
		SOCIETY("society", "학생회", "Society"), STUDY("scholarship-meeting",
				"스터디", "Scholarship Meeting"), CIRCLE("circle", "동아리", "Circle"), QNA(
				"qna", "통합 Q&A", "Q&A"), REFERENCE("reference", "자료실",
				"Reference Library"), INFOSHARE("info-sharing", "지식나눔",
				"Information Sharing"), FREEBOARD("free-board", "자유게시판",
				"Free Bulletin Board");
		private String subAction;
		private String subMenuName;
		private String subMenuDesc;

		private COMMUNITYMENU(String subAction, String subMenuname,
				String subMenuDesc) {
			this.subAction = subAction;
			this.subMenuName = subMenuname;
			this.subMenuDesc = subMenuDesc;
		}

		public String getSubAction() {
			return subAction;
		}

		public String getSubMenuName() {
			return subMenuName;
		}

		public String getSubMenuDesc() {
			return subMenuDesc;
		}
	}
}
