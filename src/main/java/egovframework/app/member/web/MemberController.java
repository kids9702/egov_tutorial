package egovframework.app.member.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.app.member.service.MemberService;
import egovframework.app.member.vo.MemberForm;
import egovframework.app.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Resource(name = "memberService")
	private MemberService memberService;
	

	@GetMapping("/members/login.do")
	public String loginPage() {
		return "egovframework/app/members/login";
	}
	
	@PostMapping("/members/login.do")
	public String login(MemberForm memberForm, ModelMap model) {
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
		
		return "redirect:/members/join.do";
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
		
		return "redirect:egovframework/app/members/login";
	}
}
