<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		
		<h1> <s:text name="label.professor.Nota"/></h1>
		
		<br/>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.student.table.dni"/></th>
		        <th><s:text name="label.student.table.name"/></th>
		        <th><s:text name="label.student.table.phone"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
		    <tr class="<s:if test="#status.odd">odd</s:if><s:else>even</s:else>">
		    	<td class="nowrap"><s:property value="al.dni"/></td>	
		    	<td class="nowrap"><s:property value="al.nombre"/></td>	
		    	<td class="nowrap"><s:property value="al.telefono"/></td>	
		    </tr>

		  </table>
		
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
		    <tr class="<s:if test="#status.odd">odd</s:if><s:else>even</s:else>">
		    	<td class="nowrap"><s:property value="asig.code"/></td>	
		    	<td class="nowrap"><s:property value="asig.nombre"/></td>	
		    	<td class="nowrap"><s:property value="asig.creditos"/></td>	
		    	<td class="nowrap"><s:property value="asig.profesor.nombre"/></td>	
		    	<td class="nowrap"><s:property value="asig.alumnos.size"/></td>		    			    	
		    </tr>
      
		</table>
		
		<br/>
		
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.students.subjects.table.Id"/></th>
		        <th><s:text name="label.students.subjects.table.concepto"/></th>
		        <th><s:text name="label.students.subjects.table.nota"/></th>
		        <th>&nbsp;&nbsp;</th>		       	
		    </tr>
			<s:iterator value="evaluaciones" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ id }"/></td>
		            <td class="nowrap"><s:property value="%{ concepto }"/></td>
		            <td class="nowrap"><s:property value="%{ nota }"/></td>
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