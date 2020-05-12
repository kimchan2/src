
public class Search {

	public static void main(String[] args) {
		
/*		// 주어진 조건
		// array 배열에 정수가 담겨 있고, 값이 오름차순으로 이미 정렬 되어있다
		// array 배열에는 중복된 값이 없다
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
		
		// 1. array 배열에서 13이라는 값이 있는 지확인하는 로직
		// 13이 발견되면 sysout으로 find라는 문자열을 출력
		boolean check = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 13) {
				check = true;
				break;
			}
		}

		System.out.println(check ? "find" : "not found");*/

		
		
		// 두번째 문제
		// array 배열에는 정수가 담겨있고 오름차순으로 정렬 되어있으며
		// 값이 중복될 수 있다
		// 배열내에 13값이 몇번 등장하는지 출력하는 로직을 작성
		int[] array = {1, 3, 5, 7, 9, 11, 13, 13, 13, 15, 17, 19, 21};
		int cnt = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 13) {
				cnt++;
				if ( array[i] > 13)
					break;
			}
		}
		
		System.out.println(cnt > 0 ? cnt+"번 등장" : "없음");
		
		
		// 이진 탐색(binary search)
		// 전제조건 : 데이터가 정렬되어 있음을 가정
		
		// 전체 데이터에서 중간 부분을 확인
		// 다음 배열에서 19를 찾을 때
		
		// 배열에 64개의 값이 있을 경우 ==> 32 ==> 16 ==> 8 ==> 4 ==> 2 ==> 1
		// for ==> 64번의 if
		// binary ==> 6번
		int[] arrayy = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
		
	}
	
}
