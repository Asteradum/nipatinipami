<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.login"/></h1>
		<s:form action="login" method="POST">
			<table>	
				<tr>
					<td class="error"><s:actionerror />
						<!--<s:fielderror />-->
					</td>
					<td class="tdLabel"><s:textfield name="username" label="%{getText('label.login.name')}"/></td>
					<td class="tdLabel"><s:password name="password" label="%{getText('label.login.password')}"/></td>
					<td class="tdLabel"><s:select name="selectedRole" label="%{getText('label.login.rol')}" list="{'Alumno', 'Profesor'}"/></td>
					<td class="tdLabel"><s:submit value="%{getText('label.login.button')}" align="center"/></td>
				</tr>
			</table>			
		</s:form>
	</body>

</html>
