package jp.co.scsk.kyushu.exBasic;

public class Moneys {
	private int oneYen;
	private int fiveYen;
	private int tenYen;
	private int fiftyYen;
	private int hundredYen;
	private int fiveHundredYen;
	private int thousandYen;
	private int twoThousandYen;
	private int fiveThousandYen;
	private int tenThousandYen;

	public int getOneYen() {
		return oneYen;
	}

	public void setOneYen(int oneYen) {
		this.oneYen = oneYen;
	}

	public int getFiveYen() {
		return fiveYen;
	}

	public void setFiveYen(int fiveYen) {
		this.fiveYen = fiveYen;
	}

	public int getTenYen() {
		return tenYen;
	}

	public void setTenYen(int tenYen) {
		this.tenYen = tenYen;
	}

	public int getFiftyYen() {
		return fiftyYen;
	}

	public void setFiftyYen(int fiftyYen) {
		this.fiftyYen = fiftyYen;
	}

	public int getHundredYen() {
		return hundredYen;
	}

	public void setHundredYen(int hundredYen) {
		this.hundredYen = hundredYen;
	}

	public int getFiveHundredYen() {
		return fiveHundredYen;
	}

	public void setFiveHundredYen(int fiveHundredYen) {
		this.fiveHundredYen = fiveHundredYen;
	}

	public int getThousandYen() {
		return thousandYen;
	}

	public void setThousandYen(int thousandYen) {
		this.thousandYen = thousandYen;
	}

	public int getTwoThousandYen() {
		return twoThousandYen;
	}

	public void setTwoThousandYen(int twoThousandYen) {
		this.twoThousandYen = twoThousandYen;
	}

	public int getFiveThousandYen() {
		return fiveThousandYen;
	}

	public void setFiveThousandYen(int fiveThousandYen) {
		this.fiveThousandYen = fiveThousandYen;
	}

	public int getTenThousandYen() {
		return tenThousandYen;
	}

	public void setTenThousandYen(int tenThousandYen) {
		this.tenThousandYen = tenThousandYen;
	}

	public boolean addOneYen(int price) {
		this.oneYen += price;
		if (this.oneYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addFiveYen(int price) {
		this.fiveYen += price;
		if (this.fiveYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addTenYen(int price) {
		this.tenYen += price;
		if (this.tenYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addFiftyYen(int price) {
		this.fiftyYen += price;
		if (this.fiftyYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addHundredYen(int price) {
		this.hundredYen += price;
		if (this.hundredYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addFiveHundredYen(int price) {
		this.fiveHundredYen += price;
		if (this.fiveHundredYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addThousandYen(int price) {
		this.thousandYen += price;
		if (this.thousandYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addTwoThousandYen(int price) {
		this.twoThousandYen += price;
		if (this.twoThousandYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addFiveThousandYen(int price) {
		this.fiveThousandYen += price;
		if (this.fiveThousandYen < 0) {
			return false;
		}
		return true;
	}

	public boolean addTenThousandYen(int price) {
		this.tenThousandYen += price;
		if (this.tenThousandYen < 0) {
			return false;
		}
		return true;
	}

	public int getTotalMoney() {
		int total = 0;
		total += this.oneYen * 1;
		total += this.fiveYen * 5;
		total += this.tenYen * 10;
		total += this.fiftyYen * 50;
		total += this.hundredYen * 100;
		total += this.fiveHundredYen * 500;
		total += this.thousandYen * 1000;
		total += this.twoThousandYen * 2000;
		total += this.fiveThousandYen * 5000;
		total += this.tenThousandYen * 10000;
		return total;
	}

	public void clear() {
		this.oneYen = 0;
		this.fiveYen = 0;
		this.tenYen = 0;
		this.fiftyYen = 0;
		this.hundredYen = 0;
		this.fiveHundredYen = 0;
		this.thousandYen = 0;
		this.twoThousandYen = 0;
		this.fiveThousandYen = 0;
		this.tenThousandYen = 0;
	}

}
