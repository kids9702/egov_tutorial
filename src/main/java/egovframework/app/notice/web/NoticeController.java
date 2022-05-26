package egovframework.app.notice.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.app.member.vo.MemberForm;
import egovframework.app.member.vo.MemberVO;
import egovframework.app.member.vo.SearchVO;
import egovframework.app.notice.service.NoticeService;
import egovframework.app.notice.vo.NoticeDTO;
import egovframework.app.notice.vo.NoticeForm;
import egovframework.app.notice.vo.NoticeVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {
    
    private final NoticeService noticeService;
    
    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    
    @GetMapping("/notice/write.do")
    public String writePage(HttpSession session) {
        if(session.getAttribute("memberSeq") == null) {
            return "redirect:/members/main.do";
        }
        return "egovframework/app/notice/write";
    }
    

    @PostMapping("/notice/write.do")
    public String write(NoticeForm noticeForm, HttpSession session) {
        if(session.getAttribute("memberSeq") == null) {
            return "redirect:/members/main.do";
        }
        
//        NoticeVO noticeVO = new NoticeVO();
//        BeanUtils.copyProperties(noticeForm, noticeVO);
        NoticeVO noticeVO = noticeForm.toVO();
        
        int memberSeq = Integer.parseInt(session.getAttribute("memberSeq").toString());
        noticeVO.setMemberSeq(memberSeq);
        
        noticeService.write(noticeVO);
        return "/notice/list.do";
    }
    
    @RequestMapping("/notice/list.do")
    public String noticeList(ModelMap model, @ModelAttribute SearchVO searchVO) {
        System.out.println(searchVO);
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(searchVO.getRecordCountPerPage());
        paginationInfo.setPageSize(searchVO.getPageSize());
        
        searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
        searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        
        List<NoticeDTO> noticeList = noticeService.list(searchVO);
        int totalRecordCount = noticeService.count(searchVO);
        
        paginationInfo.setTotalRecordCount(totalRecordCount);
        
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("searchVO", searchVO);
        
        return "egovframework/app/notice/list";
    }
}