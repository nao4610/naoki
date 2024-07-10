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

public class InsertEmployeeDao {
	private static String conUrl = "jdbc:sqlserver://localhost:1433;"
			+ "database=java_learning;"
			+ "user=java_learning;"
			+ "password=java_learning;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";

	public static void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		InDataDao inDataDao = new InDataDao();
		UserForm userForm = inDataDao.doPost(request, response);
		Connection con = DriverManager.getConnection(conUrl);
		String Sql = "select employee_no from m_employee;";
		Statement stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery(Sql);
		int count = 1;
		while (rs2.next()) {
			count++;
		}
		rs2.close();
		stmt.close();
		
		String sql = "select position_id "
				+ "from m_position where position_name = ?;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userForm.getPosition());
		ResultSet rs = pstmt.executeQuery();
		String positionId = null;
		if (rs.next()) {
			positionId = rs.getString("position_id");
		}
		
		String sql2 = "select recruit_id "
				+ "from m_recruit where recruit_name = ?;";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1, userForm.getRecruitment());
		ResultSet rs3 = pstmt2.executeQuery();
		String recruitId = null;
		if (rs3.next()) {
			recruitId = rs3.getString("recruit_id");
		}
		
		

		String sql3 = "INSERT INTO m_employee (employee_no, employee_name, employee_name_kana, birthday, "
				+ "sex, address, tel, email, spouse, dependent, "
				+ "position_id, recruit_id, company_enter, emergency_id, visa_id, invalid_flg) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
		PreparedStatement pstmt3 = con.prepareStatement(sql3);
		pstmt3.setString(1, String.format("%06d", count));
		pstmt3.setString(2, userForm.getName());
		pstmt3.setString(3, userForm.getNameKana());
		pstmt3.setString(4, userForm.getBirthDate());
		pstmt3.setString(5, userForm.getGender());
		pstmt3.setString(6, userForm.getAddress());
		pstmt3.setString(7, userForm.getPhoneNumber());
		pstmt3.setString(8, userForm.getEmail());
		pstmt3.setString(9, userForm.getSpouse());
		pstmt3.setString(10, userForm.getDependents());
		pstmt3.setString(11, positionId);
		pstmt3.setString(12, recruitId);
		pstmt3.setString(13, userForm.getJoinDate());
		pstmt3.setString(14, String.format("%06d", count));
		pstmt3.setString(15, String.format("%06d", count));
		pstmt3.executeUpdate();

		pstmt3.close();
	}

}
