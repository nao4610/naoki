package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.List;

public class Jdbc_16 {
	public static void main(String[] args) throws SQLException {
		List<String> managementNos = Jdbc_14.getManagementNo();
		for (String managementNo : managementNos) {
			Jdbc_15.deleteLendingStatus(managementNo);
		}
	}

}
