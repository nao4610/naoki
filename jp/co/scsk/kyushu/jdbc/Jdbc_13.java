package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.Map;

public class Jdbc_13 {
	public static void main(String[] args) {
		try {
			Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
			int etcCount = 0;
			int naviCount = 0;

			for (String carManagementNo : rentCarMap.keySet()) {
				RentCar rentCar = rentCarMap.get(carManagementNo);

				if ("1".equals(rentCar.getSmoking_kbn())) {
					if ("1".equals(rentCar.getEtc())) {
						etcCount += 1;
					}
					if ("1".equals(rentCar.getCar_navigation())) {
						naviCount += 1;
					}
				}
			}
			System.out.println("ETC : " + etcCount + "個  カーナビ : " + naviCount + "個");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
