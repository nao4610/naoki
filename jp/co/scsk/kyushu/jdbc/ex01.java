package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex01 {
	public static void main(String[] args) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql1 = "select shop_id from nmrm_shop;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql1);

		String shopId = "000001";

		while (rs.next()) {
			if (rs.getString("shop_id").equals(shopId)) {
				String sql2 = "insert into nmrm_staff"
						+ "(staff_id, staff_name, shop_id, ins_date, ins_user_id, upd_counter, upd_date, upd_user_id) "
						+ "values (?, ?, ?, sysdatetime(), ?, ?, sysdatetime(), ?);";
				PreparedStatement pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, "294533");
				pstmt.setString(2, "okamoto");
				pstmt.setString(3, shopId);
				pstmt.setString(4, "000003");
				pstmt.setInt(5, 0);
				pstmt.setString(6, "000003");
				pstmt.executeUpdate();
				pstmt.close();
				break;
			}
		}
		rs.close();
		stmt.close();
	}
}