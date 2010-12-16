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
					<a href="<s:url action="enroll" escapeAmp="false"/>"/>
						<s:text name="label.students.enroll"/>
					</a>	
				</th>
				<th>
					<a href="<s:url action="allSubjectsGrades" escapeAmp="false"/>"/>
						<s:text name="label.students.grades"/>
					</a>	
				</th>
				<th>					
					<a href="<s:url action="logout" escapeAmp="false"/>"/>
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
		    <s:iterator value="listaAsignaturas" status="status">
		        <tr class="<s:if test="#status.odd">odd</s:if><s:else>even</s:else>">
		            <td class="nowrap"><s:property value="%{ code }"/></td>
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ creditos }"/></td>
		            <td class="nowrap"><s:property value="%{ Profesor.nombre }"/></td>		            
		            <td class="nowrap"><s:property value="%{ alumnos.size }"/></td>
		            <td class="nowrap">
		            <a href="
		            	<s:url action="enroll!unenroll" escapeAmp="false">
		            		<s:param name="subjectId" value="%{ code }"/>
		            	</s:url>
					"/>
						<s:text name="label.students.unenroll"/>
					</a></td>
		            <td class="nowrap">
					<a href="
						<s:url action="subjectGrade" escapeAmp="false">
							<s:param name="name" value="%{ nombre }"/>
							<s:param name="code" value="%{ code }"/>
						</s:url>
					"/>
						<s:text name="label.students.subjectgrade"/>
					</a>
					</td>
		        </tr>
		    </s:iterator>
		</table>
		
	</body>

</html>