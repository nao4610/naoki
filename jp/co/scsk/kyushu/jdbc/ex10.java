package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ex10 {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("統合する１つ目の店舗名を入力してください:");
			String shopName1 = scan.nextLine().trim();
			System.out.println("統合する２つ目の店舗名を入力してください:");
			String shopName2 = scan.nextLine().trim();
			System.out.println("新しい店舗名を入力してください:");
			String newName = scan.nextLine().trim();
			scan.close();

			String conUrl = "jdbc:sqlserver://localhost:1433;"
					+ "database=java_learning;"
					+ "user=java_learning;"
					+ "password=java_learning;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(conUrl);
			String sql = "select shop_id, shop_name from nmrm_shop;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String oldShopId1 = null;
			String oldShopId2 = null;
			int count = 1;
			while (rs.next()) {
				count++;
				if (rs.getString("shop_name").equals(shopName1)) {
					oldShopId1 = rs.getString("shop_id");
				}
				if (rs.getString("shop_name").equals(shopName2)) {
					oldShopId2 = rs.getString("shop_id");
				}
			}
			String newShopId = String.format("%06d", count);

			String insertSql = "insert into nmrm_shop "
					+ "(shop_id, shop_name, ins_date, ins_user_id, upd_counter, upd_date, upd_user_id) "
					+ "VALUES (?, ?, SYSDATETIME(), ?, 0, SYSDATETIME(), ?);";
			PreparedStatement pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, newShopId);
			pstmt.setString(2, newName);
			pstmt.setString(3, "000001");
			pstmt.setString(4, "000001");
			pstmt.executeUpdate();
			pstmt.close();

			String deleteSql1 = "delete nmrm_shop where shop_id in (?, ?);";
			PreparedStatement pstmt1 = con.prepareStatement(deleteSql1);
			pstmt1.setString(1, oldShopId1);
			pstmt1.setString(2, oldShopId2);
			pstmt1.executeUpdate();
			pstmt1.close();

			String updateSql = "update nmrm_rent_car set shop_id = ? where shop_id in (?, ?);";
			PreparedStatement pstmt2 = con.prepareStatement(updateSql);
			pstmt2.setString(1, newShopId);
			pstmt2.setString(2, oldShopId1);
			pstmt2.setString(3, oldShopId2);
			pstmt2.executeUpdate();
			pstmt2.close();

			String updateSql2 = "update nmrm_staff set shop_id = ? where shop_id in (?, ?);";
			PreparedStatement pstmt3 = con.prepareStatement(updateSql2);
			pstmt3.setString(1, newShopId);
			pstmt3.setString(2, oldShopId1);
			pstmt3.setString(3, oldShopId2);
			pstmt3.executeUpdate();
			pstmt3.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
