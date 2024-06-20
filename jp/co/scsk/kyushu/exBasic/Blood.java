package jp.co.scsk.kyushu.exBasic;

public class Blood {
	private String blood;
	final  String A = "1";
	final String B = "2";
	final String AB = "3";
	final String O = "4";
	
	public Blood(String blood) {
		this.blood = blood;
	}

	public boolean isA() {
		if (blood == "1") {
			return true;
		}
		return false;
	}

	public boolean isB() {
		if (blood == "2") {
			return true;
		}
		return false;
	}

	public boolean isAB() {
		if (blood == "3") {
			return true;
		}
		return false;
	}

	public boolean isO() {
		if (blood == "4") {
			return true;
		}
		return false;
	}
}
