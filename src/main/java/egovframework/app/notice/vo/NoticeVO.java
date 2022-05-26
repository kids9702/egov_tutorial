package egovframework.app.notice.vo;

public class NoticeVO {
    private int noticeSeq;
    private String noticeTitle;
    private String noticeContents;
    private int memberSeq;
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
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    public String getNoticeContents() {
        return noticeContents;
    }
    public void setNoticeContents(String noticeContents) {
        this.noticeContents = noticeContents;
    }
    public int getMemberSeq() {
        return memberSeq;
    }
    public void setMemberSeq(int memberSeq) {
        this.memberSeq = memberSeq;
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
        return "NoticeVO [noticeSeq=" + noticeSeq + ", noticeTitle=" + noticeTitle + ", noticeContents="
                + noticeContents + ", memberSeq=" + memberSeq + ", createAt=" + createAt + ", updateAt=" + updateAt
                + ", atchFileId=" + atchFileId + "]";
    }
    
    
}
