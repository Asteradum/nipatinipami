<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		
		<h1><s:text name="label.students.evaluation"/> <s:property value="#session.nombre"/></h1>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.student.table.dni"/></th>
		        <th><s:text name="label.student.table.name"/></th>
		        <th><s:text name="label.student.table.phone"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
		    <s:iterator value="al" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ dni }"/></td>
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ telefono }"/></td>
		        </tr>
		    </s:iterator>
		</table>

		
		<br/>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.students.evaluation.table.subject"/></th>
		        <th><s:text name="label.students.evaluation.table.id"/></th>
		        <th><s:text name="label.students.evaluation.table.concept"/></th>
		        <th><s:text name="label.students.evaluation.table.grade"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
		    <s:iterator value="evaluations" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ asignatura.nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ id }"/></td>
		            <td class="nowrap"><s:property value="%{ concepto }"/></td>
		            <td class="nowrap"><s:property value="%{ nota }"/></td>
		        </tr>
		    </s:iterator>
		</table>
		
		<s:form action="returnStudentSubjects" method="POST">
			<table>	
					<td class="tdLabel"><s:submit value="%{getText('label.students.enroll.cancel')}" align="center"/></td>
				</tr>
			</table>			
		</s:form>
		
	</body>

</html>