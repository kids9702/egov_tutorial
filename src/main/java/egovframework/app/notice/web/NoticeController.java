package egovframework.app.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.app.notice.service.NoticeService;
import egovframework.app.notice.vo.NoticeVO;

@Controller
public class NoticeController {
    
    private final NoticeService noticeService;
    
    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    
    @GetMapping("/notice/write.do")
    public String writePage() {
        return "egovframework/app/notice/write";
    }
    

    @PostMapping("/notice/write.do")
    public String write() {
        NoticeVO noticeVO = new NoticeVO();
        noticeService.write(noticeVO);
        
        return "";
    }
}
