package egovframework.app.member.service.impl;

import org.springframework.stereotype.Service;

import egovframework.app.member.service.MemberService;
import egovframework.app.member.vo.MemberVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService{

	@Override
	public void join(MemberVO memberVO) {
		System.out.println(memberVO.toString());
	}
}
