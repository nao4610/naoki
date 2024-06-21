package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Jdbc_08 {
	public static void main(String[] args) throws SQLException {
		String conUrl = "jdbc:sqlserver://localhost:1433;"
				+ "database=java_learning;"
				+ "user=java_learning;"
				+ "password=java_learning;"
				+ "encrypt=true;"
				+ "trustServerCertificate=true;";
		Connection con = DriverManager.getConnection(conUrl);

		String sql = "select * from nmrm_member";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		Map<String, Member> memberMap = new HashMap<String, Member>();
		while (rs.next()) {
			Member member = new Member(rs.getString("member_id"),
					rs.getString("member_name"),
					rs.getDate("ins_date"),
					rs.getString("ins_user_id"),
					rs.getInt("upd_counter"),
					rs.getDate("upd_date"),
					rs.getString("upd_user_id"));
			memberMap.put(rs.getString("member_id"), member);
		}

		rs.close();
		stmt.close();

	}

}
