package spring.mvc.sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SelectPartDao {

	private String conUrl = "jdbc:sqlserver://localhost:1433;"
			+ "database=java_learning;"
			+ "user=java_learning;"
			+ "password=java_learning;"
			+ "encrypt=true;"
			+ "trustServerCertificate=true;";

	public List<String> getDepartmentOptions() throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "SELECT part_name FROM m_part WHERE part_kind='3'";

		try (Connection con = DriverManager.getConnection(conUrl);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				list.add(rs.getString("part_name"));
			}
			rs.close();
			stmt.close();
		}

		return list;
	}

	public List<String> getRegionOptions() throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "SELECT part_name FROM m_part WHERE part_kind='4'";

		try (Connection con = DriverManager.getConnection(conUrl);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				list.add(rs.getString("part_name"));
			}
			rs.close();
			stmt.close();
		}

		return list;
	}

	public List<String> getStoreOptions() throws SQLException {
		List<String> list = new ArrayList<>();
		String sql = "SELECT part_name FROM m_part WHERE part_kind='5'";

		try (Connection con = DriverManager.getConnection(conUrl);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				list.add(rs.getString("part_name"));
			}
			rs.close();
			stmt.close();
		}

		return list;
	}
}