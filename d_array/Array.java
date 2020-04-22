package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열 - int[] number = new int[5]; >> 크기가 5 - int[] number = nuw
		 * int[]{10, 20, 30, 40, 50}; >> 5개의 값을 넣었기 때문에 크기가 5가 됨 - int[] number
		 * = {10, 20, 30, 40, 50}; >> 크기가 5가 됨
		 */

		// 배열은 참조형 타입이다.

		int[] array; // 배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; // 배열이 생성되고 그 주소가 변수에 저장된다.
		// new : 새로운 저장공간 생성 및 주소 반환
		// int[5] : int를 저장할 수 있는 5개의 공간
		// 배열 초기화시 기본값이 저장된다. int 기본값 0

		System.out.println(array); // 주소가 저장되어 있다.

		System.out.println(array[0]); // 실제값에 접근하기 위해서는 index를 지정해줘야 한다.
		// index에는 int만 사용할 수 있다.
		// 배열의 최대 크기는 int의 최대값(약 20억)이다.

		String arrayStr = Arrays.toString(array); // 배열의 모든 인덱스에 저장된 값을 문자열로
													// 반환한다.
		System.out.println(Arrays.toString(array));

		int[] iArray1 = new int[] { 1, 2, 3 }; // 값의 개수로 배열의 길이(크기)가 정해진다.
		int[] iArray2 = { 1, 2, 3 }; // 선언과 초기화를 동시에 해야한다.
		// int[] iArray3;
		// iArray3 = {1, 2, 3}; // 컴파일 에러 발생

		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;

		// 정수를 저장할 수 있는 길이가 10인 배열을 생성 및 초기화 해주세요.
		int[] array2 = new int[10];

		// 모든 인덱스에 있는 값을 변경해주세요.
		array2[0] = 0;
		array2[1] = 10;
		array2[2] = 20;
		array2[3] = 30;
		array2[4] = 40;
		array2[5] = 50;
		array2[6] = 60;
		array2[7] = 70;
		array2[8] = 80;
		array2[9] = 90;

		// 모든 값을 더해주세요.
		int sum = 0;
		sum += array2[0];
		sum += array2[1];
		sum += array2[2];
		sum += array2[3];
		sum += array2[4];
		sum += array2[5];
		sum += array2[6];
		sum += array2[7];
		sum += array2[8];
		sum += array2[9];
		System.out.println(sum);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		System.out.println(Arrays.toString(array));

		// 배열의 합계와 평균을 구해보자.
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(numbers));

		/*
		 * sum = 0; double avg = 0;
		 * 
		 * for(int i = 0; i < numbers.length; i++){ sum += numbers[i]; } avg =
		 * (double)sum/numbers.length;
		 * 
		 * System.out.println("합계 : " + sum + ", 평균 : " + avg);
		 * 
		 * // 향상된 for문 for(int number : numbers){ // 배열에 있는 값을 차례대로 변수에 저장 후
		 * 실행한다. 데이터 타입은 동일해야 한다. System.out.println(number); // 안에서는 인덱스를 알 수
		 * 없음, 배열의 값을 읽기만 가능 저장 불가 }
		 */

		int min = numbers[0];
		int max = numbers[0];
		// 배열에 저장된 숫자들 중에 최소값과 최대값을 출력해주세요.

		for (int i = 0; i < numbers.length; i++) {

			/*
			 * if (i + 1 >= numbers.length) break;
			 */
			if (max < numbers[i])
				max = numbers[i];

			if (min > numbers[i])
				min = numbers[i];
		}
		System.out.println("최대값은 : " + max + ", 최소값은 : " + min);

		int[] shuffle = new int[20];

		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;

		}
		System.out.println(Arrays.toString(shuffle)); // Arrays.toString(배열이름)

		// 배열의 값을 섞어주세요.

		int randomIndex = 0;
		int origin = 0;
		for (int i = 0; i < shuffle.length; i++) {
// 인덱스 0~19 , 	0 < 랜덤값 < 1 * 길이 20		==>		0 < 랜덤값 < 20
			randomIndex = (int) (Math.random() * shuffle.length) ;

			origin = shuffle[i];
			shuffle[i] = shuffle[randomIndex];
			shuffle[randomIndex] = origin;
			
		}
		System.out.println();
		System.out.println(Arrays.toString(shuffle));
		
	// 1 ~ 10 사이의 난수를 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		int[] number = new int[10];
		int randomNumber = 0;
		for ( int i = 0; i < 500; i++){
			randomNumber = (int) (Math.random() * 10) + 1 ;
			number[randomNumber-1] += 1; // 생성된 숫자를 -1 해서 배열에 횟수만 카운트 
		}
		System.out.println(Arrays.toString(number));
		
		for(int i = 0; i < number.length; i++){
			System.out.println("숫자 " + (i+1) +"이(가) 생성된 횟수는 : " +number[i]);
		}
		
		int numbSum = 0;
		for(int i = 0; i < number.length; i++){
			numbSum += number[i];
		}
		System.out.println("총 횟수 : " + numbSum);
	}
}


