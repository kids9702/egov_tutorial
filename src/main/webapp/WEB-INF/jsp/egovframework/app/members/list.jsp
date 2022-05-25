<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<link href="<c:url value='/css/egovframework/com/cop/tpl/egovBaseTemplate.css' />" rel="stylesheet" type="text/css">

<script>
    function getMemberList(pageNo){
    	document.frm.pageIndex.value = pageNo;
    	document.frm.action = "<c:url value= '/members/list.do'/>";
    	document.frm.submit();
    }
</script>

</head>
<body>
<div class="board">
	
	<form id="frm" name="frm" method="post">
      <input type="hidden" name="pageIndex"/>
      
      <div class="search_box">
         <ul>
            <li>
               <select name="searchCnd">
                  <option value="0"  <c:if test="${searchVO.searchCnd == '0'}">selected="selected"</c:if> >전체</option>
                  <option value="1"  <c:if test="${searchVO.searchCnd == '1'}">selected="selected"</c:if> >이름</option>
                  <option value="2"  <c:if test="${searchVO.searchCnd == '2'}">selected="selected"</c:if> >아이디</option>
                  <option value="3"  <c:if test="${searchVO.searchCnd == '3'}">selected="selected"</c:if> >휴대폰</option>
               </select>
            </li>
            <!-- 검색키워드 및 조회버튼 -->
            <li>
               <input class="s_input" name="searchWrd" type="text"  size="35" value='<c:out value="${searchVO.searchWrd}"/>'  maxlength="155" >
               <input type="button" class="s_btn" value="검색" onclick="getMemberList(1)"/>
            </li>
         </ul>
      </div>
      
   </form>
	
	<table class="board_list">
		<thead>
			<tr>
				<th></th>
				<th>이름</th>
				<th>아이디</th>
				<th>휴대폰</th>
				<th>생성일</th>
			</tr>
		</thead>
		
		<tbody class="ov">
			<c:forEach var="member" items="${memberList}" varStatus="memberStatus">
			<tr>
				<td>${memberStatus.index + 1}</td>
				<td>${member.memberName}</td>
				<td>${member.memberId}</td>
				<td>${member.memberPhone}</td>
				<td>${member.createAt}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- paging navigation -->
	<div class="pagination">
		<ul>
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="getMemberList"/>
		</ul>
	</div>

</div>
</body>
</html>