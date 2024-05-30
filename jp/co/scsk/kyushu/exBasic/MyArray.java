package jp.co.scsk.kyushu.exBasic;

public class MyArray {
	public int[] getRamdomNumberArray(int num1) {
		int numArray[] = new int[num1];
		for (int i = 0; i < num1; i++) {
			numArray[i] = (int) (Math.random() * 101);
		}
		return numArray;
	}

	public int[][] getMultipleResultArray(int[] row, int[] col) {
		int numArray[][] = new int[row.length][col.length];
		for (int idx1 = 0; idx1 < row.length; idx1++) {
			for (int idx2 = 0; idx2 < col.length; idx2++) {
				numArray[idx1][idx2] = row[idx1] * col[idx2];
			}
		}
		return numArray;
	}
}
