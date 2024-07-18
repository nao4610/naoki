package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ex03 {
	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			String staffId = scan.nextLine().trim();

			String conUrl = "jdbc:sqlserver://localhost:1433;"
					+ "database=java_learning;"
					+ "user=java_learning;"
					+ "password=java_learning;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true;";

			Connection con = DriverManager.getConnection(conUrl);

			String sql = "UPDATE nmrm_staff SET deleted_at = true, upd_date = SYSDATETIME(), upd_counter = upd_counter + 1 WHERE staff_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, staffId);
			pstmt.executeUpdate();
			pstmt.close();
			scan.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}