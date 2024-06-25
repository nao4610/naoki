package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_15 {
	public static void deleteLendingStatus(String managementNo) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "delete nmrt_lending_status where car_management_no = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, managementNo);
		pstmt.executeUpdate();
		pstmt.close();
	}

}
