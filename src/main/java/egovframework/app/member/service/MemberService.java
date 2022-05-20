package egovframework.app.member.service;

import egovframework.app.member.vo.MemberVO;

public interface MemberService {
	void join(MemberVO memberVO);

	MemberVO login(MemberVO memberVO);
}
