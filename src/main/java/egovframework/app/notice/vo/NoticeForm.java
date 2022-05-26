package egovframework.app.notice.vo;

public class NoticeForm {
    private String noticeTitle;
    private String noticeContents;
    
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
    
    public NoticeVO toVO() {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle(this.noticeTitle);
        noticeVO.setNoticeContents(this.noticeContents);
        
        return noticeVO;
    }
}
