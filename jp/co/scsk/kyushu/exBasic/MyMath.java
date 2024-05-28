package jp.co.scsk.kyushu.exBasic;

public class MyMath {
	public static void main(String[] args) {
		int num1 = 4;
		int num2 = 7;
		int num3 = 5;
		
		
		MyMath calc = new MyMath();
		System.out.println(calc.calcPlus(num1, num2));
		System.out.println(calc.calcMinus(num1, num2));
		System.out.println(calc.calcTime(num1, num2));
		System.out.println(calc.calcDiv(num1, num2));
		System.out.println(calc.calcMod(num1, num2));
		System.out.println(calc.calcSum(num1, num2, 3));
		System.out.println(calc.calcAvg(num1, num2, 3));
		System.out.println(calc.countUpSum1(num1, num2));
		System.out.println(calc.countUpSum2(num1, num2));
		System.out.println(calc.calc(num1, num2, num3));
		System.out.println(calc.max(num1, num2, num3));
		System.out.println(calc.min(num1, num2, num3));
		System.out.println(calc.calc2(num1, num2, num3));	
	}
	
	public int calcPlus(int num1, int num2) {
		return num1 + num2;
	}
	
	public int calcMinus(int num1, int num2) {
		return num1 - num2;
	}
	
	public int calcTime(int num1, int num2) {
		int result = 0;
		for(int i = 1; i <= num2; i++) {
			result = calcPlus(result,num1);
		}
		return result;
	}
	
	public int calcDiv(int num1, int num2) {
		return num1 / num2;
	}
	
	public int calcMod(int num1, int num2) {
		return num1 - (calcDiv(num1,num2) * num2);
	}
	
	public int calcSum(int...n) {
		int result = 0;
		for(int num: n) {
			result += num;
		}
		return result;
	}
	
	public double calcAvg(int...n) {
		double result = 0;
		for(int num: n) {
			result += num;
		}
		return result / n.length;
	}
	
	public int countUpSum1(int num1, int num2) {
		int i = 0;
		for(; num1 <= num2; num1++) {
			i += num1;
		}
		return i;
	}
	
	public int countUpSum2(int num1, int num2) {
		int i = 0;
		while(num1 <= num2) {
			i += num1;
			num1++;
		}
		return i;
	}
	
	public int countUpSum3(int num1, int num2) {
		int i = 0;
		do{
			i += num1;
			num1++;
		}while(num1 <= num2);
		return i;
	}
	
	public int calc(int num1, int num2, int num3) {
		int i = 0;
		if (num1 == 1) {
			i = num2 + num3;
		} else if (num1 == 2) {
			i = num2 - num3;
		} else if (num1 == 3) {
			i = num2 * num3;
		} else if (num1 == 4) {
			i = num2 / num3;
		} else if (num1 == 5) {
			i = num2 % num3;
		}
		return i;
	}
	
	public int max(int...n) {
		int i = 0;
		for(int num: n) {
			if (i < num) {
				i = num;
			}
		}
		return i;
	}
	
	public int min(int...n) {
		int i = n[0];
		for(int num: n) {
			
			if (i > num) {
				i = num;
			}
		}
		return i;
	}
	
	public int calc2(int...n) {
		int i = 0;
		if (n[0] == 1) {
			for (int k = 1; k < n.length; k++) {
				i += n[k];
			}
		} else if (n[0] == 2) {
			for (int k = 1; k < n.length; k++) {
				i += n[k];
			}
			i = i / (n.length - 1);
		} else if (n[0] == 3) {
			for(int num: n) {
				if (i < num) {
					i = num;
				}
			}
		} else if (n[0] == 4) {
			i = n[1];
			for(int k = 1; k < n.length; k++) {
				if (i > n[k]) {
					i = n[k];
				}
			}
		} else if (n.length <= 1) {
			i = 0;
		}
		return i;
	}
}
