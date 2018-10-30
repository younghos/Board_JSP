package kr.or.ddit.attachment.model;

public class AttachmentVo {
	private String file_no;
	private String file_notice;
	private String file_name;
	private int file_chk;
	private String file_path;
	
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getFile_notice() {
		return file_notice;
	}
	public void setFile_notice(String file_notice) {
		this.file_notice = file_notice;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getFile_chk() {
		return file_chk;
	}
	public void setFile_chk(int file_chk) {
		this.file_chk = file_chk;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	@Override
	public String toString() {
		return "AttachmentVo [file_no=" + file_no + ", file_notice="
				+ file_notice + ", file_name=" + file_name + ", file_chk="
				+ file_chk + ", file_path=" + file_path + "]";
	}
	
	
}
