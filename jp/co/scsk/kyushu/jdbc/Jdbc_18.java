package jp.co.scsk.kyushu.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Jdbc_18 {
	public static void main(String[] args) {
		try {
			Map<String, RentCar> rentCarMap = Jdbc_09.getRentCarData();
			List<Integer> smokeCount = Jdbc_13.getCount();
			int smokeEtc = smokeCount.get(0);
			int smokeNavi = smokeCount.get(1);
			int etcCount = 0;
			int naviCount = 0;

			for (String carManagementNo : rentCarMap.keySet()) {
				RentCar rentCar = rentCarMap.get(carManagementNo);

				if ("2".equals(rentCar.getSmokingKbn())) {
					if ("0".equals(rentCar.getEtc())) {
						etcCount += 1;
					}
					if ("0".equals(rentCar.getCarNavigation())) {
						naviCount += 1;
					}
				}
			}
			int remainEtc = etcCount - smokeEtc;
			int remainNavi = naviCount - smokeNavi;
			String etc = "不足";
			String navi = "不足";
			if (remainEtc < 0) {
				etc = "余り";
			}
			if (remainNavi < 0) {
				navi = "余り";
			}
			System.out.println("ETC : " + Math.abs(remainEtc) + "個" + etc
					+ "  カーナビ : " + Math.abs(remainNavi) + "個" + navi);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
