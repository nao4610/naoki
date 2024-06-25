package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_19 {
	public static void main(String[] args) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "insert nmrm_staff"
				+ "(staff_id, staff_name, shop_id, ins_date, ins_user_id, upd_counter, upd_date, upd_user_id) "
				+ "values (?, ?, ?, sysdatetime(), ?, ?, sysdatetime(), ?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "004033");
		pstmt.setString(2, "okamoto");
		pstmt.setString(3, "000003");
		pstmt.setString(4, "000003");
		pstmt.setString(5, "0");
		pstmt.setString(6, "000003");
		pstmt.executeUpdate();
		pstmt.close();
	}

}
