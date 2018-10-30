package kr.or.ddit.notice.model;

import java.util.Date;

public class NoticeVo {
	private int rnum;
	private String notice_no;
	private String notice_board;
	private String notice_pno;
	private String notice_user;
	private String notice_name;
	private String notice_content;
	private int notice_chk;
	private Date notice_date;
	private String notice_seq;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_board() {
		return notice_board;
	}
	public void setNotice_board(String notice_board) {
		this.notice_board = notice_board;
	}
	public String getNotice_pno() {
		return notice_pno;
	}
	public void setNotice_pno(String notice_pno) {
		this.notice_pno = notice_pno;
	}
	public String getNotice_user() {
		return notice_user;
	}
	public void setNotice_user(String notice_user) {
		this.notice_user = notice_user;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public int getNotice_chk() {
		return notice_chk;
	}
	public void setNotice_chk(int notice_chk) {
		this.notice_chk = notice_chk;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(String notice_seq) {
		this.notice_seq = notice_seq;
	}
	
	@Override
	public String toString() {
		return "noticeVo [notice_no=" + notice_no + ", notice_board="
				+ notice_board + ", notice_pno=" + notice_pno
				+ ", notice_user=" + notice_user + ", notice_name="
				+ notice_name + ", notice_content=" + notice_content
				+ ", notice_chk=" + notice_chk + ", notice_date=" + notice_date
				+ ", notice_seq=" + notice_seq + "]";
	}
	
}
