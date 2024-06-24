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
				if ("000001".equals(rentCar.getShop_id())) {
					String smokingStatus = "1".equals(rentCar.getSmoking_kbn()) ? "喫煙" : "禁煙";
					System.out.println(rentCar.getCar_management_no() + "："
							+ carModelMap.get(rentCar.getCar_model_id()).getCar_model_name() + "（"
							+ smokingStatus + "）");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}