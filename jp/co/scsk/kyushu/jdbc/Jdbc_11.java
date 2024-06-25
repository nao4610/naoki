package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.Map;

public class Jdbc_11 {
	public static void main(String[] args) {
		try {
			Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
			int count = 0;

			for (String carManagementNo : rentCarMap.keySet()) {
				RentCar rentCar = rentCarMap.get(carManagementNo);
				if (rentCar.getExistEtc()) {
					count++;
				}
			}
			System.out.println(count + "台");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
