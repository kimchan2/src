package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * 다차원 배열 - 배열안에 배열이 저장되어 있는 형태이다.
		 */

		int[][] numbers = new int[2][3];
		int numbers2[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] nubmers3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // 선언과
																		// 초기화를
																		// 동시에
																		// 해야함.
		int[][] numbers4 = new int[3][]; // 일부만 초기화해줘도 가능 -> 가변배열
		numbers4[0] = new int[3]; // 2차원 초기화
		numbers4[1] = new int[4];
		numbers4[2] = new int[10];

		// System.out.println(numbers4[2].length);

		// numbers[0] = 10; // 1차원에 값을 저장할 수 없다.
		numbers[0] = new int[5]; // 2차원 배열의 경우 1차원 배열을 저장할 수 있다.
		numbers[0][0] = 10; // 2차원에 값을 저장할 수 있다.
		numbers[0][1] = 20;
		numbers[1][0] = 100;

		/*
		 * for(int i = 0; i < numbers.length; i++){ for(int j = 0; j <
		 * numbers[i].length; j++){ System.out.println(numbers[i][j]); }
		 * 
		 * }
		 * 
		 * System.out.println(Arrays.toString(numbers));
		 * 
		 * for(int i = 0; i < numbers.length; i++){
		 * System.out.println(Arrays.toString(numbers[i])); }
		 */

		int[][] scores = new int[3][5]; // int[학생수][과목수]
		int[] sum = new int[scores.length]; // 합계
		double[] avg = new double[scores.length]; // 평균

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int) (Math.random() * 100) + 1;
			}
			System.out.println(Arrays.toString(scores[i]));
		}

		for (int l = 0; l < scores.length; l++) {
			for (int m = 0; m < scores[l].length; m++) {

				sum[l] += scores[l][m];
			}
			avg[l] = (double)sum[l] / scores[l].length;
		}

		System.out.println("합계 : " + Arrays.toString(sum));
		System.out.println("평균 : " + Arrays.toString(avg));
	}

}
