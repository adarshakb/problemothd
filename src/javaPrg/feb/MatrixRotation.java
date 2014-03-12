package javaPrg.feb;

import java.util.Calendar;
import java.util.TimeZone;

public class MatrixRotation {

	public static void main(String args[]) {
		int[][] inp = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int dayOfWeek = Calendar.getInstance(TimeZone.getDefault()).get(
				Calendar.DAY_OF_WEEK);

		rotateMatrix(
				inp,
				(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) ? -1
						: 1);
		printMatrix(inp);
	}

	/**
	 * @param num
	 *            - the NxN matrix to rotate
	 * @param rotateBy
	 *            - the number of 90 to rotate i.e 90*X rotation
	 * @throws Exception
	 */
	public static void rotateMatrix(int[][] num, int rotateBy) {
		rotateBy = -rotateBy;
		rotateBy %= 4;
		rotateBy = rotateBy < 0 ? rotateBy + 4 : rotateBy;
		while (rotateBy-- > 0)
			rotateBy90(num);
	}

	public static void rotateBy90(int[][] num) {

		int c = (int) Math.ceil(num.length / 2.0);
		int f = (int) Math.floor(num.length / 2.0);
		int N = num.length;

		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				int tmp = num[j][i];
				num[j][i] = num[i][N - 1 - j];
				num[i][N - 1 - j] = num[N - 1 - j][N - 1 - i];
				num[N - 1 - j][N - 1 - i] = num[N - 1 - i][j];
				num[N - 1 - i][j] = tmp;
			}
		}
	}

	public static void printMatrix(final int[][] inp) {
		for (int i = 0; i < inp.length; i++) {
			for (int j = 0; j < inp[i].length; j++) {
				System.out.print(inp[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
