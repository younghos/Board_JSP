package kr.or.ddit.attachment.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.attachment.model.AttachmentVo;

public interface AttachmentDaoInf {

	public List<AttachmentVo> getAttachment(String notice_no);

	public int attachmentInsert(Map<String, Object> param);

}
