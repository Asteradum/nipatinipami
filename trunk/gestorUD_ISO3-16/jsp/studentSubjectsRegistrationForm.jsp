<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		
		<h1><s:text name="label.students.subjectsRegistrationForm"/> <s:property value="#session.nombre"/> ( <s:property value="#session.dni"/> )</h1>
		
		<s:form action="enroll!enroll" method="POST">
			<table>	
				<tr>
					<td class="tdLabel">
						<s:select name="subjectId" list="subjectList" listValue="nombre" listKey="code" label="%{getText('label.students.SubjectRegitration')}"/>
					</td>
					<td class="tdLabel"><s:submit value="%{getText('label.students.enroll.button')}" align="center"/></td>
					<s:if test="#session.rol == 'Alumno'">
						<td class="tdLabel"><s:submit value="%{getText('label.students.enroll.cancel')}" align="center" name="redirect-action:studentSubjects"/></td>
					</s:if>	
					<s:else>
						<td class="tdLabel"><s:submit value="%{getText('label.students.enroll.cancel')}" align="center" name="redirect-action:lecturerSubjects"/></td>
					</s:else>
				</tr>
			</table>			
		</s:form>
	</body>

</html>