package kr.or.ddit.attachment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.attachment.model.AttachmentVo;

public interface AttachmentServiceInf {

	public List<AttachmentVo> getAttachmemt(String notice_no);

	public int attachmentInsert(Map<String, Object> param);

	
	
}
