package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.Map;

public class Jdbc_10 {
	public static void main(String[] args) {
		try {
			Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
			Map<String, CarModel> carModelMap = Jdbc_06.getCarModelData();

			for (String carManagementNo : rentCarMap.keySet()) {
				RentCar rentCar = rentCarMap.get(carManagementNo);
				if (rentCar.getShopId().equals("000001")) {
					System.out.println(rentCar.getCarManagementNo() + "："
							+ carModelMap.get(rentCar.getCarModelId()).getCarModelName() + "（"
							+ rentCar.getSmokingKbn1() + "）");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}