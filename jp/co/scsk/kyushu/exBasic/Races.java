package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Races {
	public static void main(String args[]) {
		Races races = new Races();
		ArrayList<RacerInfo> raceResults = new ArrayList<>();
		RacerInfo racer1 = new RacerInfo();
		racer1.setRunner("Alice");
		racer1.setOrder(1);
		racer1.setRank(2);
		racer1.setTime(120.5);
		raceResults.add(racer1);
		RacerInfo racer2 = new RacerInfo();
		racer2.setRunner("Bob");
		racer2.setOrder(1);
		racer2.setRank(1);
		racer2.setTime(115.3);
		raceResults.add(racer2);
		RacerInfo racer3 = new RacerInfo();
		racer3.setRunner("Charlie");
		racer3.setOrder(1);
		racer3.setRank(3);
		racer3.setTime(130.2);
		raceResults.add(racer3);
		RacerInfo racer4 = new RacerInfo();
		racer4.setRunner("Dave");
		racer4.setOrder(2);
		racer4.setRank(2);
		racer4.setTime(110.0);
		raceResults.add(racer4);
		RacerInfo racer5 = new RacerInfo();
		racer5.setRunner("Eve");
		racer5.setOrder(2);
		racer5.setRank(3);
		racer5.setTime(112.5);
		raceResults.add(racer5);
		RacerInfo racer6 = new RacerInfo();
		racer6.setRunner("Frank");
		racer6.setOrder(2);
		racer6.setRank(1);
		racer6.setTime(108.7);
		raceResults.add(racer6);

		System.out.println(races.createReceResult(raceResults));
		Map<Integer, Map<Integer, RacerInfo>> hi = races.createReceResult(raceResults);
		races.winnerRacerInfo(hi);
		races.bestRacerInfoOfRace(hi);
		races.top10RacerInfo(hi);

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

	public void sortRaceResult(Map<Integer, Map<Integer, RacerInfo>> raceResult, int raceOrder) {
		Map<Double, String> sortMap = new TreeMap<>();
		for (Integer orderKey : raceResult.keySet()) {
			if (raceOrder == orderKey) {
				Map<Integer, RacerInfo> orderMap = raceResult.get(raceOrder);
				for (Integer rank : orderMap.keySet()) {
					sortMap.put(orderMap.get(rank).getTime(), orderMap.get(rank).getRunner());
				}
			}
		}
		System.out.println(sortMap);
	}

	public void bestRacerInfoOfRace(Map<Integer, Map<Integer, RacerInfo>> raceResult) {
		Map<Integer, RacerInfo> firstMap = new HashMap<>();
		for (Integer order : raceResult.keySet()) {
			firstMap.put(order, raceResult.get(order).get(1));
		}
		for (Integer order : firstMap.keySet()) {
			System.out.println(firstMap.get(order).getRunner());
		}
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
			if (i == 10) {
				break;
			}

		}
	}

}
