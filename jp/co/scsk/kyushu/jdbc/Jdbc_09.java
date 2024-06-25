package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Jdbc_09 {
	public static Map<String, RentCar> getRentCarData() throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "select * from nmrm_rent_car;";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		Map<String, RentCar> rentCarMap = new HashMap<>();
		while (rs.next()) {
			RentCar rentCar = new RentCar(
					rs.getString("car_management_no"),
					rs.getString("car_model_id"),
					rs.getString("shop_id"),
					rs.getString("etc"),
					rs.getString("car_navigation"),
					rs.getString("smoking_kbn"),
					rs.getTimestamp("ins_date"),
					rs.getString("ins_user_id"),
					rs.getInt("upd_counter"),
					rs.getTimestamp("upd_date"),
					rs.getString("upd_user_id"));
			rentCarMap.put(rs.getString("car_management_no"), rentCar);
		}

		rs.close();
		stmt.close();

		return rentCarMap;
	}

}
