<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			<td class="left" colspan="2">
			    
			</td>
			<th>작성자</th>
			<td class="left">
			    
			</td>
		</tr>
		<!-- 글 내용  -->
		
		<tr>
			<th>내용</th>
			<td class="" colspan="3">
				
			</td>
		</tr>

	</tbody>
	</table>

	<!-- 하단 버튼 -->
	<div class="btn">
		<input type="button" class="s_submit" value="등록" title="등록 버튼" /><!-- 등록 -->
		<span class="btn_s"><a href=""  title="목록  버튼">목록</a></span><!-- 목록 -->
	</div><div style="clear:both;"></div>
	
</div>
</form>
</body>
</html>