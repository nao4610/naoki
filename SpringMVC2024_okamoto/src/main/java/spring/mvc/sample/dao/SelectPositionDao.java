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
public class SelectPositionDao {
	private String conUrl = "jdbc:sqlserver://localhost:1433;"
			+ "database=java_learning;"
			+ "user=java_learning;"
			+ "password=java_learning;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";

	public List<String> getPositionOptions() throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "SELECT position_name FROM m_position";

		try (Connection con = DriverManager.getConnection(conUrl);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				list.add(rs.getString("position_name"));
			}
			rs.close();
			stmt.close();
		}

		return list;
	}

}
