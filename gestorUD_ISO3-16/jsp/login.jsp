<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<jsp:useBean id="bean" class="iso3.pt.action.LoginAction" scope="session" />
		<div class="titleDiv"><s:text name="application.title"/></div>
		<s:form action="login" method="POST">
			<h1><s:text name="label.login"/></h1>
			<tr>
				<td class="error"><s:actionerror />
					<!--<s:fielderror />-->
				</td>
				<td class="tdLabel"><s:textfield name="username" label="%{getText('label.login.name')}"/></td>
				<td class="tdLabel"><s:password name="password" label="%{getText('label.login.password')}"/></td>
				<td class="tdLabel"><s:select name="selectedRole" label="%{getText('label.login.rol')}" list="#{'01':'Alumno', '02':'Profesor'}"/></td>
				<td class="tdLabel"><s:submit value="%{getText('label.login.button')}" align="center"/></td>
			</tr>		
		</s:form>
	</body>

</html>
