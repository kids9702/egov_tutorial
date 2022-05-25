package egovframework.app.member.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.app.member.vo.MemberVO;
import egovframework.app.member.vo.SearchVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends EgovComAbstractDAO{
     public void insertMember(MemberVO memberVO) {
    	 insert("MemberDAO.insertMember", memberVO);
     }
     
     public MemberVO selectLoginCheck(MemberVO memberVO) {
    	 return selectOne("MemberDAO.selectLoginCheck", memberVO);
     }
     public List<MemberVO> selectMemberList(SearchVO searchVO){
    	 return selectList("MemberDAO.selectMemberList", searchVO);
     }

	public int selectMemberListCnt(SearchVO searchVO) {
		return selectOne("MemberDAO.selectMemberListCnt", searchVO);
	}
}
