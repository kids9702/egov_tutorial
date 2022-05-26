package egovframework.app.notice.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.app.member.vo.SearchVO;
import egovframework.app.notice.service.NoticeService;
import egovframework.app.notice.vo.NoticeDTO;
import egovframework.app.notice.vo.NoticeForm;
import egovframework.app.notice.vo.NoticeVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {
    
    private final NoticeService noticeService;
    
    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;

    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;

    
    @GetMapping("/notice/write.do")
    public String writePage(HttpSession session) {
        if(session.getAttribute("memberSeq") == null) {
            return "redirect:/members/main.do";
        }
        return "egovframework/app/notice/write";
    }
    

    @PostMapping("/notice/write.do")
    public String write(NoticeForm noticeForm, HttpSession session, MultipartHttpServletRequest request) throws Exception {
        
        //NoticeVO noticeVO = new NoticeVO();
        //매번 noticeVO 객체를 불러와 값을 주는 것은 번거로움 => BeanUtils 사용
        //noticeVO.setNoticeTitle(noticeForm.getNoticeTitle());
        //BeanUtils.copyProperties(noticeForm, noticeVO);
        
        if(session.getAttribute("memberSeq") == null) {
            return "redirect:/members/login.do";
        }
        
        List<MultipartFile> files = request.getFiles("file_1");
        
        for(MultipartFile file:files) {
            System.out.println("###############" + file.getOriginalFilename());
        }
        
        String atchFileId = "";
        if (!files.isEmpty()) {
            List<FileVO> result = fileUtil.parseFileInf(files, "BBS_", 0, "", "");
            atchFileId = fileMngService.insertFileInfs(result);
        }
        
        NoticeVO noticeVO = noticeForm.toVO();
        
        int memberSeq = Integer.parseInt(session.getAttribute("memberSeq").toString());
        noticeVO.setMemberSeq(memberSeq);
        noticeVO.setAtchFileId(atchFileId);
        
        //System.out.println(noticeVO.getNoticeTitle());
        noticeService.write(noticeVO);
        
        return "redirect:/notice/list.do";
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
    
    @RequestMapping("/notice/{noticeSeq}")
    public String noticeDetailV1(@PathVariable int noticeSeq, ModelMap model) {
        
        NoticeDTO notice = noticeService.detail(noticeSeq);
        model.addAttribute("notice", notice);
        return "egovframework/app/notice/detail";
    }
    
    @RequestMapping("/notice/detail.do")
    public String noticeDetailV2(int noticeSeq, ModelMap model) {
        
        NoticeDTO notice = noticeService.detail(noticeSeq);
        System.out.println(notice);
        model.addAttribute("notice", notice);
        return "egovframework/app/notice/detail";
    }
}