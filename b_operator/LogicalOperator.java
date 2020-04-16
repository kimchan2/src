package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리 연산자
		 * - &&(AND), ||(OR), !(NOT)
		 * - 피연산자로 boolean만 허용한다.
		 */
		
		boolean b;
		
		b = true && true; // true
		b = true && false; // false
		b = false && true; // false, 왼쪽 피연산자에서 결과가 정해지면 오른쪽은 수행하지 않는다.
		b = false && false; // false
		
		b = true || true; // true
		b = true || false; // true
		b = false || true; // true
		b = false || false; // false
		
		int i = 5;
		// 0 < i < 10
		b = 0 < i && i < 10;
		System.out.println(b);
		
		
		b = i > 10 || i % 2 == 0;
		System.out.println(b);
		
		int d = 10;
		b = d < 10 && 0 < d++;
		System.out.println(d); // 왼쪽에서 결과가 정해져서 뒤에가 실행이 안됨
		
		b = !b; // b가 true이면 false를 false이면 true를 저장한다.
		b = !(10 < 20);
		
		
		
		
		
		

	}

}
