package egovframework.app.member.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.app.member.service.MemberService;
import egovframework.app.member.vo.MemberForm;
import egovframework.app.member.vo.MemberVO;
import egovframework.app.member.vo.SearchVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class MemberController {
	
	@Resource(name = "memberService")
	private MemberService memberService;
	

	@GetMapping("/members/login.do")
	public String loginPage(HttpSession session) {
		if(session.getAttribute("memberSeq") != null){
			return "redirect:/members/main.do";
		}
		return "egovframework/app/members/login";
	}
	
	@PostMapping("/members/login.do")
	public String login(MemberForm memberForm, ModelMap model, HttpSession session) {
		System.out.println(memberForm);
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberForm.getMemberId());
		memberVO.setMemberPassword(memberForm.getPassword());
		MemberVO member = memberService.login(memberVO);
		
		System.out.println(member);
		
		if(member==null) {
			//로그인 실패
			model.addAttribute("message", "로그인에 실패하였습니다.");
			model.addAttribute("memberForm", memberForm);
			return "egovframework/app/members/login";
		}
		
		// 로그인 성공
		session.setAttribute("memberSeq", member.getMemberSeq());
		session.setAttribute("memberId", member.getMemberId());
		session.setAttribute("memberName", member.getMemberName());
		
		
		// 메인페이지로 변경
		return "redirect:/members/main.do";
	}
	
	@GetMapping("/members/join.do")
	public String joinPage() {
		return "egovframework/app/members/join";
	}
	
	@PostMapping("/members/join.do")
	public String join(MemberForm memberForm) {
		System.out.println(memberForm);
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemberId(memberForm.getMemberId());
		memberVO.setMemberName(memberForm.getMemberName());
		memberVO.setMemberPassword(memberForm.getPassword());
		memberVO.setMemberPhone(memberForm.getPhone());
		
		memberService.join(memberVO);
		
		return "redirect:/members/login.do";
	}
	
	@GetMapping("members/main.do")
	public String mainPage(HttpSession session) {
		if(session.getAttribute("memberSeq") == null){
			return "redirect:/members/login.do";
		}
		
		return "egovframework/app/members/main";
	}
	
	@RequestMapping("members/list.do")
	public String memberList(ModelMap model, @ModelAttribute SearchVO searchVO) {
		System.out.println(searchVO);
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getRecordCountPerPage());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<MemberVO> memberList = memberService.list(searchVO);
		int totalRecordCount = memberService.count(searchVO);
		
		paginationInfo.setTotalRecordCount(totalRecordCount);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("searchVO", searchVO);
		
		return "egovframework/app/members/list";
	}
}
