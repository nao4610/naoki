package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ex06 {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("車種名を入力してください:");
			String carName = scan.nextLine().trim();
			System.out.println("メーカ名を入力してください:");
			String makerName = scan.nextLine().trim();
			scan.close();

			String conUrl = "jdbc:sqlserver://localhost:1433;"
					+ "database=java_learning;"
					+ "user=java_learning;"
					+ "password=java_learning;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(conUrl);

			String selectSql = "select maker_id from nmrm_maker where maker_name = ?;";
			PreparedStatement pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, makerName);
			ResultSet rs = pstmt.executeQuery();
			String makerId = null;
			while (rs.next()) {
				makerId = rs.getString("maker_id");
			}
			rs.close();
			pstmt.close();

			String insertSql = "insert nmrm_car_model (car_model_id, car_model_name, car_type_kbn, "
					+ "car_class_id, maker_id, capacity, fuel_economy, displacement, ins_date, "
					+ "ins_user_id, upd_counter, upd_date, upd_user_id) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, SYSDATETIME(), ?, ?, SYSDATETIME(), ?);";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, "004");
			pstmt.setString(2, carName);
			pstmt.setString(3, "004");
			pstmt.setString(4, "004");
			pstmt.setString(5, makerId);
			pstmt.setInt(6, 5);
			pstmt.setString(7, "4");
			pstmt.setInt(8, 20);
			pstmt.setString(9, "004");
			pstmt.setInt(10, 0);
			pstmt.setString(11, "004");

			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
