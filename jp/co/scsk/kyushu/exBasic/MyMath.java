package jp.co.scsk.kyushu.exBasic;

public class MyMath {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = -2;
		int num3 = -3;

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
		for (int i = 1; i <= num2; i++) {
			result = calcPlus(result, num1);
		}
		return result;
	}

	public int calcDiv(int num1, int num2) {
		return num1 / num2;
	}

	public int calcMod(int num1, int num2) {
		return num1 - (calcDiv(num1, num2) * num2);
	}

	public int calcSum(int... num) {
		int result = 0;
		for (int num1 : num) {
			result += num1;
		}
		return result;
	}

	public double calcAvg(int... num) {
		double result = 0;
		for (int num1 : num) {
			result += num1;
		}
		return result / num.length;
	}

	public int countUpSum1(int num1, int num2) {
		int upsum1 = 0;
		for (int num = num1; num2 >= num; num++) {
			upsum1 += num;
		}
		return upsum1;
	}

	public int countUpSum2(int num1, int num2) {
		int upsum2 = 0;
		int num = num1;
		while (num <= num2) {
			upsum2 += num;
			num++;
		}
		return upsum2;
	}

	public int countUpSum3(int num1, int num2) {
		int upsum3 = 0;
		int num = num1;
		do {
			upsum3 += num;
			num++;
		} while (num <= num2);
		return upsum3;
	}

	public int calc(int num1, int num2, int num3) {
		int result = 0;
		if (num1 == 1) {
			result = calcPlus(num2, num3);
		} else if (num1 == 2) {
			result = calcMinus(num2, num3);
		} else if (num1 == 3) {
			result = calcTime(num2, num3);
		} else if (num1 == 4) {
			result = calcDiv(num2, num3);
		} else if (num1 == 5) {
			result = calcMod(num2, num3);
		}
		return result;
	}
	

	public int max(int... nums) {
		int result = nums[0];
		for (int num : nums) {
			if (result < num) {
				result = num;
			}
		}
		return result;
	}

	public int min(int... nums) {
		int result = nums[0];
		for (int num : nums) {

			if (result > num) {
				result = num;
			}
		}
		return result;
	}

	public int calc2(int... nums) {
		int result = 0;
		if (nums[0] == 1) {
			for (int idx = 1; idx < nums.length; idx++) {
				result += nums[idx];
			}
		} else if (nums[0] == 2) {
			for (int idx = 1; idx < nums.length; idx++) {
				result += nums[idx];
			}
			result = result / (nums.length - 1);
		} else if (nums[0] == 3) {
			result = nums[1];
			for (int idx = 1; idx < nums.length; idx++) {
				if (result < nums[idx]) {
					result = nums[idx];
				}
			}
		} else if (nums[0] == 4) {
			result = nums[1];
			for (int idx = 1; idx < nums.length; idx++) {
				if (result > nums[idx]) {
					result = nums[idx];
				}
			}
		}
		return result;
	}

	public int round4(double num) {
		int result;
		double absNum = Math.abs(num);
		double firstNum = (absNum * 10) - ((int)absNum * 10);
		
		if (firstNum < 4) {
			result = (int)num;
		} else {
			if(num < 0) {
				result = (int)num - 1;
			} else {
				result = (int)num + 1;
			}
		}
		return result;
	}

	public int round6(double num) {
		int result;
		double absNum = Math.abs(num);
		double firstNum = (absNum * 10) - ((int)absNum * 10);
		
		if (firstNum < 6) {
			result = (int)num;
		} else {
			if(num < 0) {
				result = (int)num - 1;
			} else {
				result = (int)num + 1;
			}
		}
		return result;
	}
}
