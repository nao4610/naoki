package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Races {

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

	public Map<Double, String> sortRaceResult(Map<Integer, Map<Integer, RacerInfo>> raceResult, int raceOrder) {
		Map<Double, String> sortMap = new TreeMap<>();
		for (Integer orderKey : raceResult.keySet()) {
			if (raceOrder == orderKey) {
				Map<Integer, RacerInfo> orderMap = raceResult.get(raceOrder);
				for (Integer rank : orderMap.keySet()) {
					sortMap.put(orderMap.get(rank).getTime(), orderMap.get(rank).getRunner());
				}
			}
		}
		return sortMap;
	}

	public List<String> bestRacerInfoOfRace(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		List<String> bestRacers = new ArrayList<>();
		Map<Integer, RacerInfo> firstMap = new HashMap<>();
		for (Integer order : raceResult.keySet()) {
			firstMap.put(order, raceResult.get(order).get(1));
		}
		for (Integer order : firstMap.keySet()) {
			bestRacers.add(firstMap.get(order).getRunner());
		}
		return bestRacers;
	}

	public RacerInfo bestRacerInfoOfAll(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		RacerInfo resultInfo = null;
		for (Integer order : raceResult.keySet()) {
			Map<Integer, RacerInfo> innerMap = raceResult.get(order);
			for (Integer rank : innerMap.keySet()) {
				RacerInfo racerInfo = innerMap.get(rank);
				if (resultInfo == null || resultInfo.getTime() > racerInfo.getTime()) {
					resultInfo = racerInfo;
				}
			}
		}
		return resultInfo;
	}

	public RacerInfo worstRacerInfoOfAll(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		RacerInfo resultInfo = null;
		for (Integer order : raceResult.keySet()) {
			Map<Integer, RacerInfo> innerMap = raceResult.get(order);
			for (Integer rank : innerMap.keySet()) {
				RacerInfo racerInfo = innerMap.get(rank);
				if (resultInfo == null || resultInfo.getTime() < racerInfo.getTime()) {
					resultInfo = racerInfo;
				}
			}
		}
		return resultInfo;
	}

	public List<String> winnerRacerInfo(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		List<String> winners = new ArrayList<>();
		for (Integer order : raceResult.keySet()) {
			for (int rank = 1; rank <= 2; rank++) {
				RacerInfo racerInfo = raceResult.get(order).get(rank);
				if (racerInfo != null) {
					winners.add(racerInfo.getRunner());
				}
			}
		}
		return winners;
	}

	public Map<Integer, RacerInfo> top10RacerInfo(Map<Integer, Map<Integer, RacerInfo>> racerInfoMap) {
		List<Double> racerTime = new ArrayList<Double>();
		Map<Integer, RacerInfo> fasterMap = new HashMap<Integer, RacerInfo>();
		for (Integer order : racerInfoMap.keySet()) {
			for (Integer rank : racerInfoMap.get(order).keySet()) {
				racerTime.add(racerInfoMap.get(order).get(rank).getTime());
			}
		}

		Collections.sort(racerTime);

		int index = 0;

		for (Iterator<Map.Entry<Integer, Map<Integer, RacerInfo>>> it = racerInfoMap.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<Integer, Map<Integer, RacerInfo>> entry = it.next();
			Map<Integer, RacerInfo> subMap = entry.getValue();

			for (Iterator<Map.Entry<Integer, RacerInfo>> subIt = subMap.entrySet().iterator(); subIt.hasNext();) {
				Map.Entry<Integer, RacerInfo> subEntry = subIt.next();
				RacerInfo info = subEntry.getValue();

				if (info.getTime() == racerTime.get(index)) {
					fasterMap.put(index + 1, info);
					subIt.remove(); // 安全に削除
					index++;
				}

				if (fasterMap.size() >= 10) {
					break;
				}
			}

			if (fasterMap.size() >= 10) {
				break;
			}
		}

		for (Integer key : fasterMap.keySet()) {
			System.out.println("名前：" + fasterMap.get(key).getRunner() + "\tタイム：" + fasterMap.get(key).getTime() + "\t走順："
					+ fasterMap.get(key).getOrder());
		}

		return fasterMap;
	}
}
