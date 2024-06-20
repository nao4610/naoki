package jp.co.scsk.kyushu.exBasic;

public class MyString {
	public void beep(int num1) {
		for (int i = 0; i < num1; i++) {
			System.out.println("ビーーー");
		}
	}

	public String branch(int num2) {
		String message;
		switch (num2) {
		case 1:
			message = "おはようございます";
			break;
		case 2:
			message = "こんにちは";
			break;
		case 3:
			message = "こんばんは";
			break;
		case 4:
			message = "おやすみなさい";
			break;
		case 5:
			message = "また明日";
			break;
		default:
			message = "さようなら";
			break;
		}
		return message;
	}

	public String concat(String[] str) {
		String text = new String();
		for (String comb : str) {
			text = text.concat(comb);
		}
		return text;
	}

	public String replace(String str) {
		String tsv = str.replace(',', '\t');
		return tsv;
	}
}
