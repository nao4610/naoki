package jp.co.scsk.kyushu.exBasic;

public class Sex {
	private int sex;
	public static final int man = 0;
	public static final int woman = 1;

	public Sex(int sex) {
		this.sex = sex;
	}

	public boolean isMan() {
		return this.sex == man;
	}

	public boolean isWoman() {
		return this.sex == woman;
	}
}
