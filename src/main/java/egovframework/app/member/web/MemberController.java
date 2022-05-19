package egovframework.app.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.app.member.service.MemberService;
import egovframework.app.member.vo.MemberForm;
import egovframework.app.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/members/login.do")
	public String loginPage() {
		return "egovframework/app/members/login";
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
		
		return "egovframework/app/members/join";
	}
}
