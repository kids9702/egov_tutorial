package egovframework.app.notice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.app.notice.service.NoticeService;
import egovframework.app.notice.vo.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeDAO noticeDAO;
    
    @Autowired
    public NoticeServiceImpl(NoticeDAO noticeDAO) {
        this.noticeDAO = noticeDAO;
    }
    
    @Override
    public void write(NoticeVO noticeVO) {
        noticeDAO.insertNotice(noticeVO);
    }

}
