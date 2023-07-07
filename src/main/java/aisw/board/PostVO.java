package aisw.board;

import org.springframework.stereotype.Component;

@Component
public class PostVO {
	//카테고리, 글번호, 작성자, 제목, 내용, 작성일, 조회수, 게시글 수
	private String p_category;
	private int p_no;
	private String p_writer;
	private String p_title;
	private String p_contents;
	private String p_reg_Date;
	private int p_hit;

	public PostVO() {
		super();
	}

	public String getP_category() {
		return p_category;
	}
	public void setP_category(String p_category) {
		this.p_category = p_category;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_writer() {
		return p_writer;
	}
	public void setP_writer(String p_writer) {
		this.p_writer = p_writer;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_contents() {
		return p_contents;
	}
	public void setP_contents(String p_contents) {
		this.p_contents = p_contents;
	}
	public String getP_reg_Date() {
		return p_reg_Date;
	}
	public void setP_reg_Date(String p_reg_Date) {
		this.p_reg_Date = p_reg_Date;
	}
	public int getP_hit() {
		return p_hit;
	}
	public void setP_hit(int p_hit) {
		this.p_hit = p_hit;
	}

	@Override
	public String toString() {
		return "PostVO [p_category=" + p_category + ", p_no=" + p_no + ", p_writer=" + p_writer + ", p_title=" + p_title
				+ ", p_contents=" + p_contents + ", p_reg_Date=" + p_reg_Date + ", p_hit=" + p_hit + "]";
	}
	
	


//	//신규생성용
//	public PostVO(int no, String writer, String title, String contents, String regDate, int viewCnt) {
//		super();
//		this.no = no;
//		this.writer = writer;
//		this.title = title;
//		this.contents = contents;
//		this.regDate = regDate;
//		this.viewCnt = viewCnt;
//	}
//	
//	//수정용
//	public PostVO(int no, String writer, String title, String contents, String category) {
//		super();
//		this.no = no;
//		this.writer = writer;
//		this.title = title;
//		this.contents = contents;
//		this.category = category;
//	}
//
//	@Override
//	public String toString() {
//		return "PostVO [category=" + category + ", no=" + no + ", writer=" + writer + ", title=" + title + ", contents="
//				+ contents + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
//	}
	
	
}



