package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Races {
	public static void main(String args[]) {

	}

	public Map<Integer, Map<Integer, RacerInfo>> createReceResult(ArrayList<RacerInfo> info) {
		Map<Integer, Map<Integer, RacerInfo>> result = new HashMap<>();
		for (RacerInfo info1 : info) {
			int order = info1.getOrder();
			int rank = info1.getRank();
			if (!result.containsKey(order)) {
				result.put(order, new HashMap<>());
			}
			result.get(order).put(rank, info1);
		}
		return result;
	}

	public void sortRaceResult(Map<Integer, Map<Integer, RacerInfo>> raceResult, int odr) {

		for (Integer odr1 : raceResult.keySet()) {
			if (odr1 == odr) {
				Map<Integer, RacerInfo> val = raceResult.get(odr1);

			}
		}
	}
}
