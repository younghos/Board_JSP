package kr.or.ddit.comment.model;

import java.util.Date;

public class CommentVo {
	private String ct_id;
	private String ct_notice;
	private String ct_user;
	private String ct_content;
	private Date ct_date;
	private int ct_chk;
	
	public String getCt_id() {
		return ct_id;
	}
	public void setCt_id(String ct_id) {
		this.ct_id = ct_id;
	}
	public String getCt_notice() {
		return ct_notice;
	}
	public void setCt_notice(String ct_notice) {
		this.ct_notice = ct_notice;
	}
	public String getCt_user() {
		return ct_user;
	}
	public void setCt_user(String ct_user) {
		this.ct_user = ct_user;
	}
	public String getCt_content() {
		return ct_content;
	}
	public void setCt_content(String ct_content) {
		this.ct_content = ct_content;
	}
	public Date getCt_date() {
		return ct_date;
	}
	public void setCt_date(Date ct_date) {
		this.ct_date = ct_date;
	}
	public int getCt_chk() {
		return ct_chk;
	}
	public void setCt_chk(int ct_chk) {
		this.ct_chk = ct_chk;
	}
	
	@Override
	public String toString() {
		return "CommentVo [ct_id=" + ct_id + ", ct_notice=" + ct_notice
				+ ", ct_user=" + ct_user + ", ct_content=" + ct_content
				+ ", ct_date=" + ct_date + ", ct_chk=" + ct_chk + "]";
	}
	
	
}
