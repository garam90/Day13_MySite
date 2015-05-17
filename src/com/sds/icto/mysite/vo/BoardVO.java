package com.sds.icto.mysite.vo;

import java.sql.Date;

public class BoardVO {

	private int no;
	private String title;
	private String content;
	private String userId;
	private Date reg_date;
	private int viewC;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int no, String title, String content, String userId,
			Date reg_date, int viewC) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.reg_date = reg_date;
		this.viewC = viewC;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getViewC() {
		return viewC;
	}

	public void setViewC(int viewC) {
		this.viewC = viewC;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content="
				+ content + ", userId=" + userId + ", reg_date=" + reg_date
				+ ", viewC=" + viewC + "]";
	}
	
}
