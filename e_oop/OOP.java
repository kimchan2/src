package e_oop;

import java.util.Arrays;

public class OOP {
	public static void main(String[] args) {
		
		/*
		 * OOP(Object Oriented Programming) : 객체지향 프로그래밍
		 * - 프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것.
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 * 
		 * 객체 생성(인스턴스화)
		 * - 클래스를 사용하기 위해 메모리(Heap영역)에 올려놓은 것.
		 * - new 클래스명(); -> 객체가 저장된 메모리 주소 반환
		 * - 객체 뒤에 참조연산자(.)를 붙여 객체의 변수와 매서드에 접근할 수 있다.
		 * - 객체는 생성될 때 마다 새로운 객체가 생성되고, 여러개의 객체가 동시에 존재할 수 있다.
		 */		
		SampleClass sc = new SampleClass();
		
		sc.method1(); // 메서드 호출 ( 일 하라고 명령하는 것 )
		
		String returnValue = sc.method2(15);
		System.out.println(returnValue);

		sc.flowTest1();
		
		// 문제. 다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		// 1. 123456 + 654321
		// 2. 1번의 결과값 * 123456
		// 3. 2번의 결과값 / 123456
		// 4. 3번의 결과값 - 654321
		// 5. 4번의 결과값 % 123456
		
		Calculator cal = new Calculator();
		double sum = cal.sum(123456, 654321);
		double mul = cal.mul(sum, 123456);
		double div = cal.div(mul, 123456);
		double sub = cal.sub(div, 654321);
		double rem = cal.rem(sub, 123456);
		
		System.out.println(sum);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(sub);
		System.out.println(rem);
		
		/*
		 * 과제. MyMath 클래스와 아래의 메서드들을 만들어주세요.
		 * - 가장 큰 값
		 * - 가장 작은 값
		 * - 원하는 자릿수에서 반올림
		 * - int배열 정렬(오름차순, 내림차순 둘다 가능하게)
		 * - SampleCalss의 변수 값을 출력(파라미터 1개만 사용)
		 */
		
		double[] arr = { 1.2, 1.1, 5.5, 55, 59, 99, 2.5, 3.4};
		
		MyMath my = new MyMath();
		
		System.out.println(my.maximum(arr));

		System.out.println(my.minimum(arr));
		
		System.out.println(my.round(3.141592, 4));
		
		int[] arr1 = { 2, 1, 5, 55, 59, 99, 4, 3};
		System.out.println(Arrays.toString(my.sort(arr1, "내림")));
		
		my.print(sc.field);
		
	}

}
