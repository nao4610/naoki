package jp.co.scsk.kyushu.exBasic;

public class Sex {
	private int sex;
	public static final int Man = 0;
	public static final int Woman = 1;

	public Sex(int sex) {
		this.sex = sex;
	}

	public boolean isMan() {
		return this.sex == Man;
	}

	public boolean isWoman() {
		return this.sex == Woman;
	}
}
