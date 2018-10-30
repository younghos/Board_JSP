package kr.or.ddit.attachment.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.attachment.dao.AttachmentDao;
import kr.or.ddit.attachment.dao.AttachmentDaoInf;
import kr.or.ddit.attachment.model.AttachmentVo;

public class AttachmentService implements AttachmentServiceInf{

	AttachmentDaoInf attachmentDao = new AttachmentDao();
	
	@Override
	public List<AttachmentVo> getAttachmemt(String notice_no) {
		return attachmentDao.getAttachment(notice_no);
	}

	@Override
	public int attachmentInsert(Map<String, Object> param) {
		return attachmentDao.attachmentInsert(param);
	}

}
