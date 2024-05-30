package jp.co.scsk.kyushu.exBasic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyList {
	public List<Integer> getRamdomNumberList(int num) {
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			myList.add((int) (Math.random() * 101));
		}
		return myList;
	}

	public List<Integer> getRamdomNumberDuplicationList(int num) {
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < num;) {
			int randomNum = (int) (Math.random() * 101);
			if (!myList.contains(randomNum)) {
				myList.add(randomNum);
				i++;
			}
		}
		return myList;
	}

	public List<Integer> getRamdomNumberDuplicationList2(int num) {
		List<Integer> myList = new ArrayList<Integer>();
		Set<Object> set = new HashSet<Object>();
		for (int i = 0; i < num;) {
			int randomNum = (int) (Math.random() * 101);
			if (set.add(randomNum)) {
				myList.add(randomNum);
				i++;
			}
		}
		return myList;
	}

	public List<Double> calcBMI(List<Human> human) {
		List<Double> myList = new ArrayList<Double>();
		for (Human human1 : human) {
			Double weight = human1.getWeight();
			Double height = human1.getHeight();
			Double bmi = (weight / (height * height));
			myList.add(bmi);
		}
		return myList;
	}

	public void plusAge(List<Human> human) {
		for (Human human1 : human) {
			human1.setAge(human1.getAge() + 1);
		}
	}
}
