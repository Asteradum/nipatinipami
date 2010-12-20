<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		
		<h1><s:text name="label.units"/> <s:property value="nombreAsig"/> </h1>
		
		<br/>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.students.subjects.table.code"/></th>
		        <th><s:text name="label.students.subjects.table.name"/></th>
		        <th><s:text name="label.students.subjects.table.credits"/></th>
		        <th><s:text name="label.students.subjects.table.lecturer"/></th>		        
		        <th><s:text name="label.students.subjects.table.students"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
		    <s:iterator value="asig" status="status">
		        <tr class="<s:if test="#status.odd">odd</s:if><s:else>even</s:else>">
		            <td class="nowrap"><s:property value="%{ code }"/></td>
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ creditos }"/></td>
		            <td class="nowrap"><s:property value="%{ Profesor.nombre }"/></td>		          
		            <td class="nowrap"><s:property value="%{ alumnos.size }"/></td>		         
		        </tr>
		    </s:iterator>
		</table>
		
		<br/>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.students.unit.table.acronym"/></th>
		        <th><s:text name="label.students.unit.table.tittle"/></th>
		        <th><s:text name="label.students.unit.table.content"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
		    <s:iterator value="unidades" status="status">
		        <tr class="<s:if test="#status.odd">odd</s:if><s:else>even</s:else>">		        
		            <td class="nowrap"><s:property value="%{ acronimo }"/></td>
		            <td class="nowrap"><s:property value="%{ titulo }"/></td>
		            <td class="nowrap"><s:property value="%{ contenido }"/></td>
		        </tr>
		    </s:iterator>
		</table>
		
		<br/>
		<s:if test="#session.rol == 'Alumno'">
			<s:form action="studentSubjects" method="POST">
				<s:submit value="%{getText('label.students.enroll.cancel')}" align="center"/>			
			</s:form>	
		</s:if>
		<s:else>
			<s:form action="lecturerSubjects" method="POST">
				<s:submit value="%{getText('label.students.enroll.cancel')}" align="center"/>			
			</s:form>
		</s:else>
		
	</body>

</html>