package jp.co.scsk.kyushu.exBasic;

public class Human {
	int age;
	String name;
	Sex sex;
	Blood blood;
	double height;
	double weight;

	public Human(int age, String name, Sex sex, Blood blood, double height, double weight) {
		this.age = age;
		this.name = name;
		this.sex = sex;
		this.blood = blood;
		this.height = height;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Blood getBlood() {
		return blood;
	}

	public void setBlood(Blood blood) {
		this.blood = blood;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void speak() {
		System.out.println("・・・");
	}

	public void speak(String str) {
		System.out.println(str);
	}

	public void speak(String str, int num) {
		int num1 = num;
		while (num1 > 0) {
			num1--;
			System.out.println(str);
		}
	}
}
