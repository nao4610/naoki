package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc_20 {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			String str = scan.next();
			String[] splitStr = str.split(",");
			String memberId = splitStr[0];
			String newMemberName = splitStr[1];
			String conUrl = "jdbc:sqlserver://localhost:1433;"
					+ "database=java_learning;"
					+ "user=java_learning;"
					+ "password=java_learning;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(conUrl);
			String sql = "update nmrm_member set member_name = ? where member_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMemberName);
			pstmt.setString(2, memberId);
			pstmt.executeUpdate();
			pstmt.close();
			scan.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
