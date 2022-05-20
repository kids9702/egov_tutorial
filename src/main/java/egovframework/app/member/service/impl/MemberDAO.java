package egovframework.app.member.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.app.member.vo.MemberVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends EgovComAbstractDAO{
     public void insertMember(MemberVO memberVO) {
    	 insert("MemberDAO.insertMember", memberVO);
     }
     
     public MemberVO selectLoginCheck(MemberVO memberVO) {
    	 return selectOne("MemberDAO.selectLoginCheck", memberVO);
     }
}
