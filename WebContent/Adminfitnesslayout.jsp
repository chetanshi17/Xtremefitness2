<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<body background="white">
<table width="90%" height="90">
<tr height="10%">
<td colspan="3" bgcolor="pink" align="center">
<tiles:insertAttribute name="ADMINHEADER"/>
</td>
</tr>
<tr height="10%">
<td width="20%" bgcolor="pink" align="left">
<tiles:insertAttribute name="ADMINLMENU"/>
</td>

<td width="100%" bgcolor="pink" align="center">
<tiles:insertAttribute name="ADMINBODY"/>
</td>
</tr>

<tr height="10%">
<td colspan="3" bgcolor="pink" align="center">
<tiles:insertAttribute name="ADMINFOOTER"/>
</td>
</tr>
</table>
</body>
</html>