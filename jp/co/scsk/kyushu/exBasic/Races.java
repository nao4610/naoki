package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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

	public void top10RacerInfo(Map<Integer, Map<Integer, RacerInfo>> top10) {
		List<RacerInfo> racerInfo = new ArrayList<>();
		List<Double> timeList = new ArrayList<>();
		for (Integer order : top10.keySet()) {
			for (Integer rank : top10.get(order).keySet()) {
				top10.put(order, top10.get(order));
				timeList.add(top10.get(order).get(rank).getTime());
			}
		}
		timeList.sort(Comparator.naturalOrder());
		for (int i = 0; i < 10 && i < timeList.size(); i++) {
			label: for (Integer order : top10.keySet()) {
				for (Integer rank : top10.get(order).keySet()) {
					if (Double.compare(timeList.get(i), top10.get(order).get(rank).getTime()) == 0) {
						racerInfo.add(top10.get(order).get(rank));
						break label;
					}
				}
			}
		}
		for (int i = 0; i < racerInfo.size(); i++) {
			System.out.println(racerInfo.get(i).getRunner() + ":" + racerInfo.get(i).getTime() + ":"
					+ racerInfo.get(i).getOrder());
		}
	}
}
