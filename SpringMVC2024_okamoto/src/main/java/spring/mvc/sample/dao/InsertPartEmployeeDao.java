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

public class InsertPartEmployeeDao {
	private static String conUrl = "jdbc:sqlserver://localhost:1433;"
			+ "database=java_learning;"
			+ "user=java_learning;"
			+ "password=java_learning;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";

	public static void insertPartEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		InDataDao inDataDao = new InDataDao();
		UserForm userForm = inDataDao.doPost(request, response);
		Connection con = DriverManager.getConnection(conUrl);
		String Sql = "select employee_no from m_part_employee;";
		Statement stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(Sql);
		int count = 1;
		while (rs2.next()) {
			count++;
		}
		rs2.close();
		stmt.close();
		String position = userForm.getStore();
		if (position == null) {
			position = userForm.getDepartment();
		}

		String sql = "select part_id "
				+ "from m_part where part_name = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, position);
		ResultSet rs = pstmt.executeQuery();
		String partId = null;

		if (rs.next()) {
			partId = rs.getString("part_id");
		}

		rs.close();
		pstmt.close();

		String sql2 = "INSERT INTO m_part_employee (employee_no, part_id, invalid_flg, ins_date, ins_user_id, "
				+ "upd_counter, upd_date, upd_user_id) "
				+ "VALUES (?, ?, 0, getDate(), '000000', 0, getDate(), '000000');";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1, String.format("%06d", count));
		pstmt2.setString(2, partId);
		pstmt2.executeUpdate();

		pstmt2.close();
	}

}
