package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Jdbc_12 {
	public static void main(String[] args) {
		try {
			Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
			Map<String, Shop> shopMap = Jdbc_07.getShopData();

			Map<String, Integer> carCount = new HashMap<>();
			Map<String, Integer> naviCount = new HashMap<>();

			for (String carManagementNo : rentCarMap.keySet()) {
				RentCar rentCar = rentCarMap.get(carManagementNo);
				String shopId = rentCar.getShopId();
				carCount.merge(shopId, 1, Integer::sum);
				if (rentCar.getCarNavigation().equals("1")) {
					naviCount.merge(shopId, 1, Integer::sum);
				}
			}
			for (String shopId : carCount.keySet()) {
				int totalCars = carCount.get(shopId);
				int naviCars = naviCount.get(shopId);
				double ratio = (double) naviCars / totalCars * 100;
				System.out.println(shopMap.get(shopId).getShopName() + ":" + String.format("%.1f", ratio) + "%");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
