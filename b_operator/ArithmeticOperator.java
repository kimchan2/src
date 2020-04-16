package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술 연산자
		 * - + : 더하기
		 * - - : 빼기
		 * - * : 곱하기
		 * - / : 나누기
		 * - % : 나머지
		 * - 이항 연산자는 양쪽의 펴연산자의 타입이 일치해야 연산이 가능하다.
		 */
		
		int a = 10 + 20 - 10 * 5 / 10 % 2;
		// *, /, % 연산자가 +, - 보다 연산자의 우선순위가 높다.
		// 우선순위가 동일한 경우 왼쪽부터 연산이 수행된다.
		System.out.println(a);

		double d = 10 + 20.3; // int + double -> double + double = double
		System.out.println(d);
		
		byte b = 10;
		short c = 20;
		
		a = c - b; 
		/* 연산은 기본적으로 4byte로 작은경우 바꿔서함
		 * c와 b 둘다 int로 형변환이되어 결과도 int형임
		 * 따라서 결과를 c에 저장 불가
		 */
		
		long e1 = 1000000 * 1000000;
		System.out.println(e1); // 오버 플로우 발생
		long e2 = 1000000 * 1000000L;
		System.out.println(e2);

		double f1 = 10 / 4;
		System.out.println(f1);
		double f2 = 10 / 4.0;
		System.out.println(f2);
		
		int f3 = 10 % 4; // 10을 4로 나눈 나머지
		System.out.println(f3);
		
//		int g1 = 10 / 0; // 런타임 에러 발생

		float g2 = 10.0f / 0; // Infinity
		System.out.println(g2);
		
		float g3 = 0 / 0f; // NaN : Not a Number
		System.out.println(g3);
		
		int h1 = 'A' + 1; // A = 65
		System.out.println(h1);
		
		int h2 = 'D' - 'A'; // 68 - 65
		System.out.println(h2);
		
		int h3 = '5' - '0'; // 1은 49, 0은 48, 5는 53
		System.out.println(h3);
		
		//산술 연산자와 대입 연산자를 합해 연산식을 줄여서 표현할 수 있다.(복합 연산자)
		int i = 0;
		i = i + 1;
		i += 1;
		i = i + 2;
		i += 2;
		
		i = i - 3;
		i -= 3;
		i *= 4;
		i /= 5;
		i %= 6;
		
		// 증감연산자
		++i; // 전위형 : 변수가 참조되기 전 수행
		i++; // 후위형 : 변수가 참조된 후 수행
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i);
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		double round = 50.65;
		System.out.println(Math.round(round)); // 소수점 첫째 자리에서만 반올림을 해준다
		System.out.println((int)(round * 10 + 0.5) / 10.0); // 소수점 둘째 자리에서 반올림
		System.out.println(Math.round(round * 10) / 10.0); // 소수점 둘째 자리에서 반올림
		
		//문제. 다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		long x = 123456+654321;
		System.out.println(x);
		//2. 1번의 결과값 * 123456
		x *= 123456; // 여기서 int 값의 범위를 넘어서기 때문에 long으로 선언
		System.out.println(x);
		//3. 2번의 결과값 / 123456
		x /= 123456;
		System.out.println(x);
		//4. 3번의 결과값 - 654321
		x -= 654321;
		System.out.println(x);
		//5. 4번의 결과값 % 123456
		x %= 123456;
		System.out.println(x);
		
		
		
		
		
		
		
	}

}
