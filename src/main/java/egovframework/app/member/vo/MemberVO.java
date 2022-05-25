package egovframework.app.member.vo;

public class MemberVO {
	private String memberSeq;
	private String memberId;
	private String memberName;
	private String memberPassword;
	private String memberPhone;
	private String createAt;
	private String updateAt;
	
	public String getMemberSeq() {
		return memberSeq;
	}
	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "MemberVO [memberSeq=" + memberSeq + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", memberPassword=" + memberPassword + ", memberPhone=" + memberPhone + ", createAt=" + createAt
				+ ", updateAt=" + updateAt + "]";
	}
	
	
}
