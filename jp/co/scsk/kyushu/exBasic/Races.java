package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.Collections;
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

	public void bestRacerInfoOfAll(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
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
		System.out.println(resultInfo.getRunner() + " : " + resultInfo.getTime());
	}

	public void worstRacerInfoOfAll(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
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
		System.out.println(resultInfo.getRunner() + " : " + resultInfo.getTime());
	}

	public void winnerRacerInfo(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		Map<Integer, RacerInfo> winMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (Integer order : raceResult.keySet()) {
			for (int rank = 1; rank <= 2; rank++) {
				winMap.put(order, raceResult.get(order).get(rank));
				list.add(winMap.get(order).getRunner());
			}
		}
		System.out.println(list);
	}

	public void top10RacerInfo(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		List<RacerInfo> time = new ArrayList<>();
		for (Integer order : raceResult.keySet()) {
			Map<Integer, RacerInfo> innerMap = raceResult.get(order);
			for (Integer rank : innerMap.keySet()) {
				time.add(innerMap.get(rank));
			}
		}
		Collections.sort(
				time,
				new Comparator<RacerInfo>() {
					public int compare(RacerInfo obj1, RacerInfo obj2) {
						return (int) (obj1.getTime() - obj2.getTime());
					}
				});
		for (int i = 0; i < time.size(); i++) {
			RacerInfo Info = time.get(i);
			String name = Info.getRunner();
			Double runTime = Info.getTime();
			Integer order = Info.getOrder();
			System.out.println(name + ":" + runTime + ":" + order);
			if (i == 9) {
				break;
			}

		}
	}

}
