<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css' />">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/uat/uia/login.css' />">

<script>
	function goJoinPage(){
		/* document.loginForm.action="<c:url value='/members/join.do'/>";
		document.loginForm.method="GET";
        document.loginForm.submit(); */
        
        location.href = "<c:url value='/members/join.do'/>";
	}
	function actionLogin(){
		document.loginForm.action="<c:url value='/members/login.do'/>";
        document.loginForm.submit();
	}
	var message = '${message}';
	if(message != ''){
		alert(message);
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle"><spring:message code="common.noScriptTitle.msg" /></noscript>


<!-- 일반로그인 -->
<div class="login_form">
	<form name="loginForm" id="loginForm" action="<c:url value='/uat/uia/actionLogin.do'/>" method="post">
	<input type="hidden" id="message" name="message" value="<c:out value='${message}'/>">
	
	<fieldset>
		<img src="<c:url value='/images/egovframework/com/uat/uia/login_tit.png'/>" style="margin:30px 0 0px 60px" alt="login title image"  title="login title image">
		<div class="login_type">
			<ul id="ulLoginType">
				<li><a href="javascript:fnLoginTypeSelect('typeGnr');" id="typeGnr" title=""><spring:message code="comUatUia.loginForm.GNR"/></a></li> <!-- 일반 -->
				<li><a href="javascript:fnLoginTypeSelect('typeEnt');" id="typeEnt" title=""><spring:message code="comUatUia.loginForm.ENT"/></a></li> <!-- 기업 -->
				<li><a href="javascript:fnLoginTypeSelect('typeUsr');" id="typeUsr" title=""><spring:message code="comUatUia.loginForm.USR"/></a></li> <!-- 업무 -->
			</ul>
		</div>
	
		<div class="login_input">
			<ul>
				<!-- 아이디 -->
				<c:set var="title"><spring:message code="comUatUia.loginForm.id"/></c:set>
				<li>
					<label for="id">${title}</label>
					<input type="text" name="memberId" id="id" value="${memberForm.memberId }" maxlength="20" title="${title} ${inputTxt}" placeholder="${title} ${inputTxt}">
				</li>
				<!-- 비밀번호 -->
				<c:set var="title"><spring:message code="comUatUia.loginForm.pw"/></c:set>
				<li>
					<label for="password">${title}</label>
					<input type="password" name="password" id="password" value="${memberForm.password }" maxlength="20" title="${title} ${inputTxt}" placeholder="${title} ${inputTxt}">
				</li>
				<!-- 아이디 저장 -->
				<c:set var="title"><spring:message code="comUatUia.loginForm.idSave"/></c:set>
				<li class="chk">
					<input type="checkbox" name="checkId" class="check2" onclick="javascript:saveid(document.loginForm);" id="checkId">${title}
				</li>
				<li>
					<input type="button" class="btn_login" value="<spring:message code="comUatUia.loginForm.login"/>" onclick="actionLogin()"> <!-- 로그인  -->
				</li>
				<li>
					<ul class="btn_idpw" >
						<li><a href="#" onclick="goJoinPage(); return false;"><spring:message code="comUatUia.loginForm.regist"/></a></li> <!-- 회원가입  -->
					</ul>
				</li>
				<li>
					<ul class="btn_idpw" >
						<li><a href="#" onclick="fnShowLogin(1);"><spring:message code="comUatUia.loginForm.login.gpki"/></a></li><!-- 인증서로그인 -->
						<li><a href="<c:url value='/uat/uia/egovGpkiIssu.do'/>"><spring:message code="comUatUia.loginForm.gpki.info"/></a></li><!-- 인증서안내 -->
					</ul>
				</li>
				
			</ul>
		</div>
		
		<div class="login_input" style="display: none">
			<ul>
				<li>
					<label for="password"><spring:message code="comUatUia.loginForm.pw"/></label><!-- 비밀번호 -->
					<input type="password" name="pwd" id="" maxlength="20" title="${title} ${inputTxt}" placeholder="<spring:message code="comUatUia.loginForm.pw"/>"><!-- 비밀번호 -->
				</li>
				<li>
					<input type="button" class="btn_login" value="<spring:message code="comUatUia.loginForm.login.gpki"/>" onclick="actionLogin()"><!-- 인증서로그인 -->
				</li>
				<li>
					<ul class="btn_idpw" >
						<li><a href="#" onclick="fnShowLogin(0);"><spring:message code="comUatUia.loginForm.login.normal"/></a></li><!-- 일반로그인 -->
					</ul>
					<ul class="btn_idpw" >
						<li>※ <spring:message code="comUatUia.loginForm.gpki.descrption"/></li>
					</ul>
				</li>
			</ul>
			
		</div>
	</fieldset>
	
	<input name="userSe" type="hidden" value="GNR"/>
	<input name="j_username" type="hidden"/>
	</form>
</div>

<!-- 팝업 폼 -->
<form name="defaultForm" action ="" method="post" target="_blank">
<div style="visibility:hidden;display:none;">
<input name="iptSubmit3" type="submit" value="<spring:message code="comUatUia.loginForm.submit"/>" title="<spring:message code="comUatUia.loginForm.submit"/>">
</div>
</form>
<!-- login영역 //-->



</body>
</html>