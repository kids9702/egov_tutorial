<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>공지사항 상세</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/com/com.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/com/cmm/jqueryui.css">
</head>
<body>

<form> 
<div class="wTableFrm">
	
	<h2>게시글 상세</h2>

	
	<table class="wTable">
	<caption>게시글 상세</caption>
	<colgroup>
		<col style="width: 20%;">
		<col style="width: ;">
		<col style="width: ;">
		<col style="width: ;">
	</colgroup>
	<tbody>
		<tr>
			<th>제목</th>
			<td class="left">
                ${notice.noticeTitle}
			</td>
			<th>작성자</th>
			<td class="left">
			    ${notice.memberName}
			</td>
		</tr>
		<!-- 글 내용  -->
		
		<tr>
			<th>내용</th>
			<td class="" colspan="3">
				${notice.noticeContents}
			</td>
		</tr>
		
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<c:import url="/cmm/fms/selectFileInfs.do" charEncoding="utf-8">
					<c:param name="param_atchFileId" value="${notice.atchFileId}"/>
				</c:import>
			</td>
		</tr>

	</tbody>
	</table>


</div>
</form>
</body>
</html>