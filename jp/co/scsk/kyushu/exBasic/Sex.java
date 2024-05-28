package jp.co.scsk.kyushu.exBasic;

public class Sex {
	private int sex;
	final int man = 0;
	final int woman = 1;

	Sex(int sex) {
		this.sex = sex;
	}
	
	public boolean isMan() {
		if (sex == 0) {
			return true;
		}
		return false;
	}

	public boolean isWoman() {
		if (sex == 1) {
			return true;
		}
		return false;
	}
}
