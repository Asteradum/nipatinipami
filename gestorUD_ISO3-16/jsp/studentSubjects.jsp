<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		
		<h1><s:text name="label.students.subjects"/> <s:property value="#session.nombre"/> ( <s:property value="#session.dni"/> )</h1>
		
		<table>
			<tr>
				<th>
					<a href="<s:url value="/jsp/login.jsp"/>"/>
						<s:text name="label.students.enroll"/>
					</a>	
				</th>
				<th>
					<a href="<s:url value="/jsp/login.jsp"/>"/>
						<s:text name="label.students.grades"/>
					</a>	
				</th>
				<th>					
					<a href="<s:url id="urlLogout" action="logout" escapeAmp="false"/>"/>
						<s:text name="label.logout"/>
					</a>	
				</th>
			</tr>
		</table>
		<br/>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.students.subjects.table.code"/></th>
		        <th><s:text name="label.students.subjects.table.name"/></th>
		        <th><s:text name="label.students.subjects.table.credits"/></th>
		        <th><s:text name="label.students.subjects.table.lecturer"/></th>
		        <th><s:text name="label.students.subjects.table.units"/></th>
		        <th><s:text name="label.students.subjects.table.students"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
		    <s:iterator value="Asignaturas" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="fullName"/></td>
		            <td class="nowrap"><s:property value="nationality"/></td>
		            <td class="nowrap"><s:property value="language"/></td>
		        </tr>
		    </s:iterator>
		</table>
		
	</body>

</html>