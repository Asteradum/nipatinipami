<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title ><s:text name="application.title"/></title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		
		<h1> <s:text name="label.professor.AddGrade"/></h1>
		
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
		<s:form method="POST">	
			
			<s:textfield name="concepto" label="%{getText('label.professor.Concepto')}"/>
			<s:textfield name="nota" label="%{getText('label.professor.Nota')}"/>
			<s:submit value="%{getText('label.professor.Entregar')}" action="mandarNota" align="right">
				<s:hidden name="dni" value="%{al.dni}"/>
				<s:hidden name="asignatura" value="%{asig.code}"/>	
			</s:submit>	
			<s:if test="#session.rol == 'Alumno'">
				<s:submit value="%{getText('label.students.enroll.cancel')}" align="right" name="redirect-action:studentSubjects"/>
			</s:if>	
			<s:else>
				<s:submit value="%{getText('label.students.enroll.cancel')}" align="right" name="redirect-action:lecturerSubjects"/>
			</s:else>	
		</s:form>
				
	</body>


</html>