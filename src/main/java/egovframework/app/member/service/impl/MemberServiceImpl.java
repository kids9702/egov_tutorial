package egovframework.app.member.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.app.member.service.MemberService;
import egovframework.app.member.vo.MemberVO;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.com.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService{

//	private final MemberDAO memberDAO;
//	
//	public MemberServiceImpl(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	@Resource(name = "memberDAO")
	private MemberDAO memberDAO;

	@Override
	public void join(MemberVO memberVO) {
		try {
			String hash = EgovFileScrty.encryptPassword(memberVO.getMemberPassword(), EgovStringUtil.isNullToString(memberVO.getMemberId()));
			memberVO.setMemberPassword(hash);
			System.out.println(hash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		memberDAO.insertMember(memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		
		String hash;
		try {
			hash = EgovFileScrty.encryptPassword(memberVO.getMemberPassword(), EgovStringUtil.isNullToString(memberVO.getMemberId()));
			memberVO.setMemberPassword(hash);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberVO member = memberDAO.selectLoginCheck(memberVO);
		return member;
		
	}
}
