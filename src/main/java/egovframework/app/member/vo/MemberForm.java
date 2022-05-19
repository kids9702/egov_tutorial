package egovframework.app.member.vo;

public class MemberForm {
	// 아이디, 이름, 비밀번호, 핸드폰번호
	private String memberId;
	private String memberName;
	private String password;
	private String phone;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "MemberForm [memberId=" + memberId + ", memberName=" + memberName + ", password=" + password + ", phone="
				+ phone + "]";
	}
	
}
