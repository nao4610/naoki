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
<title>確認画面</title>
</head>
<body>
	<h1>サンプルアンケート</h1>
	<form:form action="/send" modelAttribute="userForm">
		<table cellpadding="3">
			<tr>
				<th valign="top" align="right">年齢：</th>
				<td><c:out value="${userForm.age}" /></td>
			</tr>
			<tr>
				<th valign="top" align="right">知ったきっかけ（複数選択可）：</th>
				<td>
				<c:forEach items="${userForm.trigger}" var="t">
					<c:out value="${t}" /><br />
				</c:forEach>
			</tr>
			<tr >
				<td colspan="2" align="center"><input type="submit" value="完了画面へ" /></td>
			</tr>
		</table>
		<p></p>
	</form:form>
</body>
</html>
