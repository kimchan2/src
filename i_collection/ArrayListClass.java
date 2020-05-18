package i_collection;

import java.util.ArrayList;

public class ArrayListClass {

	public static void main(String[] args) {
		
		/*
		 * add()	: 마지막 위치에 객체를추가
		 * get()	: 지정된 위치의 개게를 반환
		 * set()	: 지정된 위치에 주어진 객체를 저장(수정)
		 * remove()	: 지정된 위치의 객체를 제거
		 * size()	: 저장된 객체의 수 반환
		 */
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.add(10);
		list.add("abc");
		list.add(true);
		list.add(new ArrayListClass());
		
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("abc");
		list2.add("123");
		list2.add("가나다");
		list2.set(1, "456");
		
		for(int i = 0; i < list2.size(); i++){
			System.out.println(list2.get(i));
		}
		
		list2.remove(0);
		// 리스트에 저장된 값을 삭제하면 그 뒤의 모든 값의 인덱스가 당겨진다.
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		
		ArrayList<ArrayList<Integer>> list3 = new ArrayList<>(); // 2차원 배열
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(10);
		list4.add(20);
		list4.add(30);
		
		list3.add(list4);
		
		list4 = new ArrayList<>();
		list4.add(40);
		list4.add(50);
		list4.add(60);
		
		list3.add(list4);
		
		ArrayList<Integer> list5 = list3.get(0);
		System.out.println(list5.get(0));
		
		for(int i = 0; i < list3.size(); i++){
			ArrayList<Integer> list6 = list3.get(i);
			for(int j = 0; j < list6.size(); j++){
				System.out.println(list6.get(j)); // .get().get()은 속도가 더 느릴 수 있음, 보기는 좋음
			}
		}
		
		
		// 정수를 저장할 수 있는 ArrayList를 생성해 1~100 사이의 랜덤한 값을 5번 저장해주세요.
		ArrayList<Integer> arrList = new ArrayList<>();
		
		for(int i = 0; i < 5; i++){
			arrList.add( (int)(Math.random()*100) + 1 );
		}
		System.out.println(arrList);
		
		// 위에서 만든 ArrayList에 담긴 값들의 합계와 평균을 출력해주세요.
		int sum = 0;
		double avg = 0;
//		for(Integer i : arrList){
//			sum += i;
//		}
		
		for(int i = 0; i < arrList.size(); i++){
			sum += arrList.get(i);
		}
		avg = (double)sum / arrList.size();
		
		System.out.println("합계 : "+ sum + ", 평균 : " + avg);
		
		// 위에서 만든 ArrayList에 담긴 값들 중 최소값과 최대값을 출력해주세요.
		int max = arrList.get(0), min = arrList.get(0);
		for(Integer i : arrList){
			if( i > max )
				max = i;
			if( i < min )
				min = i;
		}
		System.out.println("최대 값 : " + max + " 최소 값 : " + min);
	}

}
