package spring.mvc.sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class SelectRecruitDao {
	private String conUrl = "jdbc:sqlserver://localhost:1433;"
			+ "database=java_learning;"
			+ "user=java_learning;"
			+ "password=java_learning;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";

	public List<String> getRecruitmentOptions() throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "SELECT DISTINCT recruit_name FROM m_recruit";

		try (Connection con = DriverManager.getConnection(conUrl);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				list.add(rs.getString("recruit_name"));
			}
			rs.close();
			stmt.close();
		}

		return list;
	}

}
