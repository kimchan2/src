package e_oop;

public class MyMath {

	/*
	 * 과제. MyMath 클래스와 아래의 메서드들을 만들어주세요.
	 * - 가장 큰 값
	 * - 가장 작은 값
	 * - 원하는 자릿수에서 반올림
	 * - int배열 정렬(오름차순, 내림차순 둘다 가능하게)
	 * - SampleCalss의 변수 값을 출력(파라미터 1개만 사용)
	 */

	double maximum(double[] arr) {
		double max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;
	}

	double minimum(double[] arr) {
		double min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		return min;
	}

	double round(double a, int b) {

		return Math.round(a * Math.pow(10, b - 1)) / Math.pow(10, b - 1);
	}

	int[] sort(int[] arr, String ans) {
		int temp = 0;
		if (ans.equals("내림")) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i] < arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		
		if (ans.equals("올림")){
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		
		return arr;
	}

	void print(int num){
		System.out.println(num);
	}
	
}
