package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_05 {

	public static void main(String[] args) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "select * "
				+ "from nmrm_rent_car as t1 "
				+ "inner join nmrm_car_model as t2 on t1.car_model_id = t2.car_model_id "
				+ "inner join nmrm_shop as t3 on t1.shop_id = t3.shop_id "
				+ "where maker_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "0003");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("car_management_no") + "、" + rs.getString("car_model_name") + "、"
					+ rs.getString("shop_name"));
		}

		rs.close();
		pstmt.close();
	}
}
