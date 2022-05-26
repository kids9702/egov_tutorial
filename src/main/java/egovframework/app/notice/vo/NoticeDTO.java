package egovframework.app.notice.vo;

public class NoticeDTO {
    private int noticeSeq;
    private String noticeTitle;
    private String noticeContents;
    private String memberName;
    private String createAt;
    private String updateAt;
    private String atchFileId;
    
    public String getAtchFileId() {
        return atchFileId;
    }
    public void setAtchFileId(String atchFileId) {
        this.atchFileId = atchFileId;
    }
    public int getNoticeSeq() {
        return noticeSeq;
    }
    public void setNoticeSeq(int noticeSeq) {
        this.noticeSeq = noticeSeq;
    }
    public String getNoticeTitle() {
        return noticeTitle;
    }
    public String getNoticeContents() {
        return noticeContents;
    }
    public void setNoticeContents(String noticeContents) {
        this.noticeContents = noticeContents;
    }
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
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
        return "NoticeDTO [noticeSeq=" + noticeSeq + ", noticeTitle=" + noticeTitle + ", noticeContents="
                + noticeContents + ", memberName=" + memberName + ", createAt=" + createAt + ", updateAt=" + updateAt
                + ", atchFileId=" + atchFileId + "]";
    }
    
}
