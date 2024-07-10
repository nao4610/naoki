package spring.mvc.sample.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.mvc.sample.form.UserForm;

public class InsertEmergencyDao {
	private static String conUrl = "jdbc:sqlserver://localhost:1433;"
			+ "database=java_learning;"
			+ "user=java_learning;"
			+ "password=java_learning;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";

	public static void insertEmergency(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		InDataDao inDataDao = new InDataDao();
		UserForm userForm = inDataDao.doPost(request, response);
		Connection con = DriverManager.getConnection(conUrl);
		String Sql = "select emergency_id from m_emergency;";
		Statement stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(Sql);
		int count = 1;
		while (rs2.next()) {
			count++;
		}
		rs2.close();
		stmt.close();

		String sql = "INSERT INTO m_emergency (emergency_id, emergency_name, emergency_tel, emergency_relationship, "
				+ "emergency_address, invalid_flg, ins_date, ins_user_id, upd_counter, upd_date, upd_user_id)"
				+ "VALUES (?, ?, ?, ?, ?, 0, getDate(), '000000', 0, getDate(), '000000')";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, String.format("%06d", count));
		pstmt.setString(2, userForm.getEmergencyContactName());
		pstmt.setString(3, userForm.getEmergencyPhoneNumber());
		pstmt.setString(4, userForm.getRelationship());
		pstmt.setString(5, userForm.getEmergencyAddress());

		pstmt.executeUpdate();

		pstmt.close();
	}

}
