package jp.co.scsk.kyushu.exBasic;

public class Price {
	public int price1(int age) {
		int entryFee = 1000;
		if (age < 7) {
			entryFee = 0;
		} else if (age < 18) {
			entryFee /= 2;
		} else if (age >= 60) {
			entryFee -= 300;
		}
		if (age < 60) {
			if (age % 4 == 0) {
				entryFee *= 0.96;
			}
			if (age % 5 == 0) {
				entryFee *= 0.95;
			}
		}
		return entryFee;
	}

	public int price2(int num, int fee) {
		int sumFee = num * fee - (num / 5) * fee;
		return sumFee;
	}
}
