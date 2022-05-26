package egovframework.app.notice.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.app.member.vo.SearchVO;
import egovframework.app.notice.vo.NoticeDTO;
import egovframework.app.notice.vo.NoticeVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class NoticeDAO extends EgovComAbstractDAO{
    public void insertNotice(NoticeVO noticeVO) {
        insert("NoticeDAO.insertNotice", noticeVO);
    }

    public List<NoticeDTO> getList(SearchVO searchVO) {
        return selectList("NoticeDAO.selectNoticeList", searchVO);
    }

    public int getCount(SearchVO searchVO) {
        return selectOne("NoticeDAO.selectNoticeListCnt", searchVO);
    }

    public NoticeDTO selectNotice(int noticeSeq) {
        return selectOne("NoticeDAO.selectNotice", noticeSeq);
    }
}
