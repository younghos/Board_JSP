package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	
	private String board_id; // 게시판 아이디
	private String board_user; // 게시판 등록자
	private String board_name; // 게시판 이름
	private int board_chk; // 게시판 사용여부
	private Date board_date; // 게시판 등록일시
	
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getBoard_user() {
		return board_user;
	}
	public void setBoard_user(String board_user) {
		this.board_user = board_user;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public int getBoard_chk() {
		return board_chk;
	}
	public void setBoard_chk(int board_chk) {
		this.board_chk = board_chk;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_id=" + board_id + ", board_user=" + board_user
				+ ", board_name=" + board_name + ", board_chk=" + board_chk
				+ ", board_date=" + board_date + "]";
	}
	
	
}
