package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ex02 {
	public static void main(String[] args) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "select lend.return_plan_date, contract.total_price, member.member_name "
				+ "from nmrt_lending_status as lend "
				+ "inner join nmrt_contract as contract on lend.car_management_no = contract.car_management_no "
				+ "inner join nmrm_member as member on contract.member_id = member.member_id;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Timestamp> planDate = new ArrayList<>();
		List<Integer> formerPrice = new ArrayList<>();
		List<String> memberName = new ArrayList<>();

		while (rs.next()) {
			planDate.add(rs.getTimestamp("return_plan_date"));
			formerPrice.add(rs.getInt("total_price"));
			memberName.add(rs.getString("member_name"));
		}
		List<Integer> delayDate = new ArrayList<>();
		for (Timestamp timestamp : planDate) {
			LocalDateTime planDateTime = timestamp.toLocalDateTime();
			int gapDate = (int) ChronoUnit.DAYS.between(planDateTime, LocalDateTime.now());
			if (gapDate > 0) {
				delayDate.add(gapDate);
			} else {
				delayDate.add(0);
			}
		}

		List<Integer> delayTotalPrice = new ArrayList<>();
		for (int i = 0; i < delayDate.size(); i++) {
			int delayPrice = 0;
			int delayDateValue = delayDate.get(i);
			int formerPriceValue = formerPrice.get(i);
			if (delayDateValue >= 1) {
				delayPrice = formerPriceValue;
				delayDateValue--;
				delayPrice += (formerPriceValue * 2 * delayDateValue);
			}
			delayTotalPrice.add(delayPrice);
			System.out.println("会員名: " + memberName.get(i) + " 延滞料金: " + delayTotalPrice.get(i) + "円");
		}

		rs.close();
		stmt.close();
	}
}