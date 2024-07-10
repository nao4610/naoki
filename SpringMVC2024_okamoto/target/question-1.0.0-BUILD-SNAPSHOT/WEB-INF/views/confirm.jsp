<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>M001 社員所属登録</title>
<script>
	function toggleSelectBoxes() {
		var headOfficeRadio = document.getElementById("headOffice");
		var branchRadio = document.getElementById("branch");

		var departmentSelect = document.getElementById("departmentSelect");
		var regionSelect = document.getElementById("regionSelect");
		var storeSelect = document.getElementById("storeSelect");

		if (headOfficeRadio.checked) {
			departmentSelect.disabled = false;
			regionSelect.disabled = true;
			storeSelect.disabled = true;
		} else if (branchRadio.checked) {
			departmentSelect.disabled = true;
			regionSelect.disabled = false;
			storeSelect.disabled = false;
		}
	}
</script>
<style type="text/css">
td, th {
	padding: 20px;
	vertical-align: top;
}

body {
	font-family: Arial, sans-serif;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
}

th {
	background-color: #e1f0fa;
	text-align: left;
}

input[type="text"], input[type="email"], select, textarea {
	width: calc(100% - 10px);
	padding: 4px;
	margin: 2px 0;
	box-sizing: border-box;
}

input[type="radio"] {
	margin: 0 5px;
}

input[type="submit"] {
	width: 60px;
	padding: 5px;
	margin: 20px 0;
}

.no-border {
	border: none;
}
</style>
</head>
<body>
	<h1>M001 社員所属登録</h1>
	<form:form action="/confirm" modelAttribute="userForm">
		<table cellpadding="3">
			<tr>
				<th>社員名(氏名)</th>
				<td><form:input path="name" required="true" /></td>
				<td>(氏名カナ)</td>
				<td><form:input path="nameKana" required="true"/></td>
			</tr>
			<tr>
				<th>性別</th>
				<td colspan="3" class="no-border">
				<form:radiobutton path="gender" value="male" required="true"/> 男性 
				<form:radiobutton path="gender" value="female" required="true"/> 女性</td>
			</tr>
			<tr>
				<th>生年月日</th>
				<td><form:input path="birthDate" type = "date" required="true"/></td>
			</tr>
			<tr>
				<th>入社日</th>
				<td><form:input path="joinDate" type = "date" required="true"/></td>
			</tr>
			<tr>
				<th>住所</th>
				<td><form:input path="address" required="true"/></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><form:input path="phoneNumber" required="true"/></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><form:input path="email" required="true"/></td>
			</tr>
			<tr>
				<th>配偶者の有無</th>
				<td colspan="3" class="no-border">
				<form:radiobutton path="spouse" value="yes" required="true"/> 有 
				<form:radiobutton path="spouse" value="no" required="true"/> 無</td>
			</tr>
			<tr>
				<th>扶養の有無</th>
				<td colspan="3" class="no-border">
				<form:radiobutton path="dependents" value="yes" required="true"/> 有 
				<form:radiobutton path="dependents" value="no" required="true"/> 無</td>
			</tr>
			<tr>
				<th>VISAの有無</th>
				<td colspan="3" class="no-border">
				<form:radiobutton path="visa" value="yes" required="true"/> 有 
				<form:radiobutton path="visa" value="no" required="true"/> 無</td>
				<td>(期限)</td>
				<td><form:input path="visaExpiration" required="true"/></td>
			</tr>
			<tr>
				<th>採用区分</th>
				<td><form:select path="recruitment"
						items="${recruitmentOptions}" required="true"/></td>
				<th>役職</th>
				<td><form:select path="position" items="${positionOptions}" required="true"/></td>
			</tr>
			<tr>
				<th>所属</th>
				<td colspan="3" class="no-border">
					<table class="no-border" style="width: 100%;">
						<tr>
							<td class="no-border">
							<form:radiobutton path="affiliation" value="headOffice" id="headOffice" onclick="toggleSelectBoxes()" required="true"/> 本社 
							<form:radiobutton path="affiliation" value="branch" id="branch" onclick="toggleSelectBoxes()" required="true"/> 店舗 <br>
							(部)
						<form:select path="department" id="departmentSelect" items="${departmentOptions}" />
						</tr>
						<tr>
							<td class="no-border">
							エリア・店舗
							<form:select path="region" id="regionSelect" items="${regionOptions}" /> 
							<form:select path="store" id="storeSelect" items="${storeOptions}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th colspan="2">緊急連絡先 (本人以外)</th>
			</tr>
			<tr>
				<th>氏名</th>
				<td><form:input path="emergencyContactName" required="true"/></td>
			</tr>
			<tr>
				<th>続柄</th>
				<td><form:input path="relationship" required="true"/></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><form:input path="emergencyPhoneNumber" required="true"/></td>
			</tr>
			<tr>
				<th>住所</th>
				<td><form:input path="emergencyAddress" required="true"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="登録" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>