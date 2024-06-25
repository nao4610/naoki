package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Jdbc_06 {

	public static Map<String, CarModel> getCarModelData() throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "select * "
				+ "from nmrm_car_model;";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		Map<String, CarModel> carModelMap = new HashMap<>();
		while (rs.next()) {
			CarModel carModel = new CarModel(
					rs.getString("car_model_id"),
					rs.getString("car_model_name"),
					rs.getString("car_type_kbn"),
					rs.getString("car_class_id"),
					rs.getString("maker_id"),
					rs.getInt("capacity"),
					rs.getDouble("fuel_economy"),
					rs.getInt("displacement"),
					rs.getTimestamp("ins_date"),
					rs.getString("ins_user_id"),
					rs.getInt("upd_counter"),
					rs.getTimestamp("upd_date"),
					rs.getString("upd_user_id"));
			carModelMap.put(rs.getString("car_model_id"), carModel);
		}

		rs.close();
		stmt.close();

		return carModelMap;
	}
	
	
}