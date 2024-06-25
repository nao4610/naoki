package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jdbc_13 {
	public static List<Integer> getCount() throws SQLException {

		Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
		int etcCount = 0;
		int naviCount = 0;
		List<Integer> count = new ArrayList<>();

		for (String carManagementNo : rentCarMap.keySet()) {
			RentCar rentCar = rentCarMap.get(carManagementNo);

			if ("1".equals(rentCar.getSmokingKbn())) {
				if ("1".equals(rentCar.getEtc())) {
					etcCount += 1;
				}
				if ("1".equals(rentCar.getCarNavigation())) {
					naviCount += 1;
				}
			}
		}
		count.add(etcCount);
		count.add(naviCount);
		System.out.println("ETC : " + etcCount + "個  カーナビ : " + naviCount + "個");

		return count;

	}

}
