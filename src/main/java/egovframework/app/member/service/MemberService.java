package egovframework.app.member.service;

import java.util.List;

import egovframework.app.member.vo.MemberVO;
import egovframework.app.member.vo.SearchVO;

public interface MemberService {
	void join(MemberVO memberVO);
	MemberVO login(MemberVO memberVO);
	List<MemberVO> list(SearchVO searchVO);
	int count(SearchVO searchVO);
}
