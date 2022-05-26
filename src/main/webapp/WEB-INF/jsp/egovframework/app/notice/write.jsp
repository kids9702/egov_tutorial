<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<!DOCTYPE html>
<html>
<head>
<title>공지사항 등록</title><!-- 게시글 등록 -->
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/com/com.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/com/cmm/jqueryui.css">

<script>
    function noticeWrite(){
        document.noticeForm.action="<c:url value='/notice/write.do'/>";
        document.noticeForm.submit();
    }
</script>
</head>
<body>

<form id="noticeForm" name="noticeForm" method="post"> 
<div class="wTableFrm">
    <!-- 타이틀 -->
    <h2>게시글 등록</h2><!-- 게시글 등록 -->

    <!-- 등록폼 -->
    <table class="wTable" summary="게시글의 내역에 대한 목록을 출력합니다.">
    <caption>게시글 등록</caption>
    <colgroup>
        <col style="width: 20%;">
        <col style="width: ;">
        <col style="width: ;">
        <col style="width: ;">
    </colgroup>
    <tbody>
        <!-- 입력 -->
        
        <!-- 글 제목 -->
        
        <tr>
            <th><label for="">제목 <span class="pilsu">*</span></label></th>
            <td class="left" colspan="3">
                <input id="noticeTitle" name="noticeTitle" title="제목 입력" type="text" value="" size="70" maxlength="70"/>
            </td>
        </tr>
        <!-- 글 내용  -->
        
        <tr>
            <th><label for="">내용 <span class="pilsu">*</span></label></th>
            <td class="" colspan="3">
                <textarea id="noticeContents" name="noticeContents" title="내용 입력" rows="20" cols="300"></textarea>
            </td>
        </tr>

    </tbody>
    </table>

    <!-- 하단 버튼 -->
    <div class="btn">
        <input type="button" class="s_submit" value="등록" title="등록 버튼" onclick="noticeWrite();"/><!-- 등록 -->
        <span class="btn_s"><a href=""  title="목록  버튼">목록</a></span><!-- 목록 -->
    </div><div style="clear:both;"></div>
    
</div>
</form>
</body>
</html>