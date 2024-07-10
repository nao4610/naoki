<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td, th {
	padding: 20px;
}
</style>
<title>入力画面</title>
</head>
<body>
	<h1>サンプルアンケート</h1>
	<form:form action="/confirm" modelAttribute="userForm">
		<table cellpadding="3">
			<tr>
				<th valign="top" align="right">年齢：</th>
				<td><form:select path="age" items="${ageList}" /></td>
			</tr>
			<tr>
				<th valign="top" align="right">知ったきっかけ（複数選択可）：</th>
				<td><form:checkboxes path="trigger" items="${triggerMap}"
						delimiter="<br />" /></td>
			</tr>
			<tr >
				<td colspan="2" align="center"><input type="submit" value="確認画面へ" /></td>
			</tr>
		</table>
		<p></p>
	</form:form>
</body>
</html>
