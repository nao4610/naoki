package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ex04 {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("返却するレンタカーの車両管理番号を入力してください:");
			String carManagementNo = scan.nextLine().trim();
			System.out.println("返却する店舗のIDを入力してください:");
			String returnShopId = scan.nextLine().trim();
			scan.close();

			String conUrl = "jdbc:sqlserver://localhost:1433;"
					+ "database=java_learning;"
					+ "user=java_learning;"
					+ "password=java_learning;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(conUrl);

			String selectSql = "SELECT shop_id FROM nmrm_rent_car WHERE car_management_no = ?";
			PreparedStatement pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, carManagementNo);
			ResultSet rs = pstmt.executeQuery();
			String shopId = null;
			while (rs.next()) {
			 shopId = rs.getString("shop_id");
			}

			rs.close();
			pstmt.close();

			String insertSql = "INSERT INTO nmrt_return_shop "
					+ "(car_management_no, shop_id, return_shop_id, ins_date, ins_user_id, upd_counter, upd_date, upd_user_id) "
					+ "VALUES (?, ?, ?, SYSDATETIME(), ?, 0, SYSDATETIME(), ?)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, carManagementNo);
			pstmt.setString(2, shopId);
			pstmt.setString(3, returnShopId);
			pstmt.setString(4, "000001");
			pstmt.setString(5, "000001");
			pstmt.executeUpdate();
			pstmt.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}