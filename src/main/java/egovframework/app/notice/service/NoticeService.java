package egovframework.app.notice.service;

import java.util.List;

import egovframework.app.member.vo.SearchVO;
import egovframework.app.notice.vo.NoticeDTO;
import egovframework.app.notice.vo.NoticeVO;

public interface NoticeService {
    void write(NoticeVO noticeVO);

    List<NoticeDTO> list(SearchVO searchVO);

    int count(SearchVO searchVO);

    NoticeDTO detail(int noticeSeq);
}
