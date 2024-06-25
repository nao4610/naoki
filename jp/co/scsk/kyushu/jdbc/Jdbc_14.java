package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc_14 {
	public static List<String> getManagementNo() throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "select rent.car_management_no, model.car_model_name, shop.shop_name, lend.leading_date, lend.return_plan_date "
				+ "from nmrm_rent_car as rent "
				+ "inner join nmrm_car_model as model on rent.car_model_id = model.car_model_id "
				+ "inner join nmrm_shop as shop on rent.shop_id = shop.shop_id "
				+ "inner join nmrt_lending_status as lend on rent.car_management_no = lend.car_management_no;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<String> managementNo = new ArrayList<String>();

		while (rs.next()) {
			Date returnPlanDate = rs.getDate("return_plan_date");
			Date returnDate = Date.valueOf("2018-06-10");

			if (returnPlanDate.before(returnDate)) {
				System.out.println(
						rs.getString("car_management_no") + " : "
								+ rs.getString("car_model_name") + "、"
								+ rs.getString("shop_name") + "、"
								+ rs.getString("leading_date") + "、"
								+ rs.getString("return_plan_date"));
				managementNo.add(rs.getString("car_management_no"));
			}
		}
		rs.close();
		stmt.close();
		return managementNo;
	}

}
