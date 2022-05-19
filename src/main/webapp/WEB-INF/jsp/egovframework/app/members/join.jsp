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
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/uat/uia/login.css' />">

<script>
	function join(){
		document.joinForm.action = '<c:url value="/members/join.do"/>';
		document.joinForm.submit();
	}
</script>
</head>
<body>
	<form id="joinForm" name="joinForm" method="post">
		<div class="wTableFrm">
			<!-- 타이틀 -->
			<h2>${pageTitle} <spring:message code="title.create" /></h2>
		
			<!-- 등록폼 -->
			<table class="wTable" summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
			<caption>${pageTitle} <spring:message code="title.create" /></caption>
			<colgroup>
				<col style="width: 22%;"><col style="width: ;">
			</colgroup>
			<tbody>
				<!-- 입력/선택 -->
				<c:set var="inputTxt"><spring:message code="input.input" /></c:set>
				<c:set var="inputSelect"><spring:message code="input.cSelect" /></c:set>
				<!-- 일반회원아이디 -->
				<c:set var="title"><spring:message code="comUssUmt.userManageRegist.id"/></c:set>
				<tr>
					<th><label for="mberId">${title}</label> <span class="pilsu">*</span></th>
					<td class="left">
					<input type="text" id="memberId" name="memberId"  size="20" maxlength="20" style="width:80%;"/>
						
						<button id="btnMbrId" class="btn_s2" onClick="return false;" title="<spring:message code="button.delete" /> <spring:message code="input.button" />"><spring:message code="comUssUmt.userManageRegistBtn.idSearch" /></button>
						<div></div>
					</td>
				</tr>
				<!-- 일반회원이름 -->
				<c:set var="title"><spring:message code="comUssUmt.userManageRegist.name"/></c:set>
				<tr>
					<th><label for="mberNm">${title}</label> <span class="pilsu">*</span></th>
					<td class="left">
							<input type="text" id="memberName" name="memberName" size="50" maxlength="50"/> 
					</td>
				</tr>
				<!-- 비밀번호 -->
				<c:set var="title"><spring:message code="comUssUmt.userManageRegist.pass"/></c:set>
				<tr>
					<th><label for="password">${title}</label> <span class="pilsu">*</span></th>
					<td class="left">
						<div>
							<input type="password" id="password" name="password" title="${title} ${inputTxt}" size="50" maxlength="20"/> 
						</div>
						<div>
							<div><spring:message code="info.password.rule.password1" /></div> 
							<div><spring:message code="info.password.rule.pwdcheckcomb3" /></div> 
							<div><spring:message code="info.password.rule.pwdcheckseries" /></div> 
						</div>
					</td>
				</tr>
				<!-- 비밀번호확인 -->
				<c:set var="title"><spring:message code="comUssUmt.userManageRegist.passConfirm"/></c:set>
				<tr>
					<th><label for="password2">${title}</label> <span class="pilsu">*</span></th>
					<td class="left">
					<input name="password2" id="password2" title="${title} ${inputTxt}" type="password" size="50" maxlength="20" />
					</td>
				</tr>
				<!-- 헨드폰번호 -->
				<c:set var="title"><spring:message code="comUssUmt.userManageRegist.phone"/></c:set>
				<tr>
					<th><label for="moblphonNo">${title}</label> <span class="pilsu">*</span></th>
					<td class="left">
					<input type="text" id="phone" name="phone" title="${title} ${inputTxt}" class="txaIpUmt" size="20" maxlength="15" />
					</td>
				</tr>
			
			</tbody>
			</table>
		
			<!-- 하단 버튼 --> 
			<div class="btn">
				<input type="submit" onclick = "join();" class="s_submit" value="<spring:message code="button.create" />" title="<spring:message code="button.create" /> <spring:message code="input.button" />" />
			</div><div style="clear:both;"></div>
		
		</div><!-- div end(wTableFrm)  -->
	
		<!-- 우편번호검색 -->
		<input type="hidden" name="zip_url" value="<c:url value='/sym/ccm/zip/EgovCcmZipSearchPopup.do'/>" />
		
		
		<!-- Egov Modal include  -->
		<c:import url="/EgovModal.do" charEncoding="utf-8">
			<c:param name="scriptYn" value="Y" />
			<c:param name="modalName" value="egovModal" />
		</c:import>
	</form>


</body>
</html>