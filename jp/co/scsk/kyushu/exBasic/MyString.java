package jp.co.scsk.kyushu.exBasic;

public class MyString {
	public void beep(int num1) {
		for (int i = 0; i < num1; i++) {
			System.out.println("ビーーー");
		}
	}

	public void branch(int num2) {
		switch (num2) {
		case 1:
			System.out.println("おはようございます");
			break;
		case 2:
			System.out.println("こんにちは");
			break;
		case 3:
			System.out.println("こんばんは");
			break;
		case 4:
			System.out.println("おやすみなさい");
			break;
		case 5:
			System.out.println("また明日");
			break;
		default:
			System.out.println("さようなら");
		}
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
