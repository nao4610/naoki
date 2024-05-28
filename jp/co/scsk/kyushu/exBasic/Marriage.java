package jp.co.scsk.kyushu.exBasic;

public class Marriage {
	public boolean checkMarriage(Human human) {
		if (human.getSex().isMan()) {
			if (human.getAge() >= 18) {
				return true;
			}
			return false;
		} else {
			if (human.getAge() >= 16) {
				return true;
			}
			return false;
		}
	}
	
	public boolean checkMarriage(Human human1, Human human2) {
		if (human1.getSex().isMan() == human2.getSex().isWoman()) {
			if (checkMarriage(human1) && checkMarriage(human2)) {
				return true;
			}
		}
		return false;
	}
}
