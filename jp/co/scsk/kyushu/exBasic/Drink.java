package jp.co.scsk.kyushu.exBasic;

public class Drink {
	String product;
	int volume;
	int price;

	public Drink(String product, int volume, int price) {
		super();
		this.product = product;
		this.volume = volume;
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public int getPrice() {
		return price;
	}
}
