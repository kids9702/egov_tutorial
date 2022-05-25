package egovframework.app.notice.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.app.notice.vo.NoticeVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class NoticeDAO extends EgovComAbstractDAO{
    public void insertNotice(NoticeVO noticeVO) {
        insert("NoticeDAO.insertNotice", noticeVO);
    }

}
