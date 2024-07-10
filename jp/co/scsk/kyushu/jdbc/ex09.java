package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class ex09 {
	public static void main(String[] args) {
		try {
			String conUrl = "jdbc:sqlserver://localhost:1433;"
					+ "database=java_learning;"
					+ "user=java_learning;"
					+ "password=java_learning;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(conUrl);
			Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
			int etcStock = 0;
			int naviStock = 0;
			for (String carManagementNo : rentCarMap.keySet()) {
				RentCar rentCar = rentCarMap.get(carManagementNo);

				if (rentCar.getYesSmoking()) {
					if (rentCar.getExistEtc()) {
						etcStock++;
					}
					if (rentCar.getExistCarNavigation()) {
						naviStock++;
					}
					String deleteSql = "delete nmrm_rent_car where car_management_no = ?;";
					PreparedStatement pstmt = con.prepareStatement(deleteSql);
					pstmt.setString(1, carManagementNo);
					pstmt.executeUpdate();
					pstmt.close();
				}
			}

			String insertSql = "insert into nmrt_stock "
					+ "(navi_stock, etc_stock, ins_date, ins_user_id, upd_counter, upd_date, upd_user_id) "
					+ "VALUES (?, ?, SYSDATETIME(), ?, 0, SYSDATETIME(), ?);";
			PreparedStatement pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1, naviStock);
			pstmt.setInt(2, etcStock);
			pstmt.setString(3, "000001");
			pstmt.setString(4, "000001");
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
