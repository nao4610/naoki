package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ex05 {
	public static void main(String[] args) {
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("所有する店舗に返却したレンタカーの車両管理番号を入力してください:");
		String carManagementNo = scan.nextLine().trim();
		scan.close();
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "delete nmrt_return_shop where car_management_no = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, carManagementNo);
		pstmt.executeUpdate();
		pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}
