package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_17 {
	public static void main(String[] args) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "insert into nmrt_lending_status (car_management_no, return_plan_date, leading_date, "
					+ "ins_date, ins_user_id, upd_counter, upd_date, upd_user_id) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "000001");
		pstmt.setString(2, "2018/06/29 12:00");
		pstmt.setString(3, "2018/06/27 12:00");
		pstmt.setString(4, "2018/06/27 12:00");
		pstmt.setString(5, "00329");
		pstmt.setInt(6, 0);
		pstmt.setString(7, "2018/06/27 12:00");
		pstmt.setString(8, "00329");
		pstmt.executeUpdate();
		pstmt.close();
	}

}
