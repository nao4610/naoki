package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachines {
	public static void main(String[] args) {

	}

	Moneys machineMoneys;//自動販売機が持っている貨幣
	Map<Drink, Integer> machine;//自動販売機が持っている飲み物の種類と保持数
	Moneys inputMoneys;//投入された貨幣

	public List<Drink> insertMoneys(Moneys getMoneys) {
		machineMoneys.addOneYen(getMoneys.getOneYen());
		machineMoneys.addFiveYen(getMoneys.getFiveYen());
		machineMoneys.addTenYen(getMoneys.getTenYen());
		machineMoneys.addFiftyYen(getMoneys.getFiftyYen());
		machineMoneys.addHundredYen(getMoneys.getHundredYen());
		machineMoneys.addFiveHundredYen(getMoneys.getFiveHundredYen());
		machineMoneys.addThousandYen(getMoneys.getThousandYen());
		machineMoneys.addTwoThousandYen(getMoneys.getTwoThousandYen());
		machineMoneys.addFiveThousandYen(getMoneys.getFiveThousandYen());
		machineMoneys.addTenThousandYen(getMoneys.getTenThousandYen());
		List<Drink> availableDrinks = new ArrayList<>();
		for (Map.Entry<Drink, Integer> entry : machine.entrySet()) {
			Drink drink = entry.getKey();
			int price = drink.getPrice();
			if (price <= machineMoneys.getTotalMoney()) {
				availableDrinks.add(drink);
			}
		}

		return availableDrinks;
	}

	public int calcChange(Drink drink) {
		int holdNum = machine.get(drink);
		if (holdNum == 0) {
			System.out.println("売り切れです");
			return -1;
		}
		int change = inputMoneys.getTotalMoney() - drink.getPrice();
		machine.put(drink, holdNum - 1);
		return change;
	}

	public Moneys getChange(int change) {
		Moneys changeMoneys = new Moneys();
		Moneys tempMoneys = new Moneys();
		tempMoneys.setOneYen(machineMoneys.getOneYen());
		tempMoneys.setFiveYen(machineMoneys.getFiveYen());
		tempMoneys.setTenYen(machineMoneys.getTenYen());
		tempMoneys.setFiftyYen(machineMoneys.getFiftyYen());
		tempMoneys.setHundredYen(machineMoneys.getHundredYen());
		tempMoneys.setFiveHundredYen(machineMoneys.getFiveHundredYen());
		tempMoneys.setThousandYen(machineMoneys.getThousandYen());
		tempMoneys.setTwoThousandYen(machineMoneys.getTwoThousandYen());
		tempMoneys.setFiveThousandYen(machineMoneys.getFiveThousandYen());
		tempMoneys.setTenThousandYen(machineMoneys.getTenThousandYen());

		int[] coinValues = { 10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] currentCoins = {
				tempMoneys.getTenThousandYen(),
				tempMoneys.getFiveThousandYen(),
				tempMoneys.getTwoThousandYen(),
				tempMoneys.getThousandYen(),
				tempMoneys.getFiveHundredYen(),
				tempMoneys.getHundredYen(),
				tempMoneys.getFiftyYen(),
				tempMoneys.getTenYen(),
				tempMoneys.getFiveYen(),
				tempMoneys.getOneYen()
		};
		int[] changeCoins = new int[10];

		for (int i = 0; i < coinValues.length; i++) {
			while (change >= coinValues[i] && currentCoins[i] > 0) {
				change -= coinValues[i];
				currentCoins[i]--;
				changeCoins[i]++;
			}
		}

		if (change > 0) {
			return null;
		}

		changeMoneys.setTenThousandYen(changeCoins[0]);
		changeMoneys.setFiveThousandYen(changeCoins[1]);
		changeMoneys.setTwoThousandYen(changeCoins[2]);
		changeMoneys.setThousandYen(changeCoins[3]);
		changeMoneys.setFiveHundredYen(changeCoins[4]);
		changeMoneys.setHundredYen(changeCoins[5]);
		changeMoneys.setFiftyYen(changeCoins[6]);
		changeMoneys.setTenYen(changeCoins[7]);
		changeMoneys.setFiveYen(changeCoins[8]);
		changeMoneys.setOneYen(changeCoins[9]);

		machineMoneys.setTenThousandYen(currentCoins[0]);
		machineMoneys.setFiveThousandYen(currentCoins[1]);
		machineMoneys.setTwoThousandYen(currentCoins[2]);
		machineMoneys.setThousandYen(currentCoins[3]);
		machineMoneys.setFiveHundredYen(currentCoins[4]);
		machineMoneys.setHundredYen(currentCoins[5]);
		machineMoneys.setFiftyYen(currentCoins[6]);
		machineMoneys.setTenYen(currentCoins[7]);
		machineMoneys.setFiveYen(currentCoins[8]);
		machineMoneys.setOneYen(currentCoins[9]);

		inputMoneys.clear();

		return changeMoneys;
	}

	public Moneys purchaseDrink(Moneys getMoneys, Drink selectedDrink) {
		inputMoneys = getMoneys;
		List<Drink> availableDrinks = insertMoneys(getMoneys);

		if (availableDrinks.contains(selectedDrink)) {
			int changeAmount = calcChange(selectedDrink);
			if (changeAmount >= 0) {
				System.out.println("購入した飲み物: " + selectedDrink.product);
				return getChange(changeAmount);
			} else {
				System.out.println("おつり計算に問題が発生しました。");
				return null;
			}
		} else {
			System.out.println("購入できない飲み物です。");
			return getMoneys; 
		}
	}

}
