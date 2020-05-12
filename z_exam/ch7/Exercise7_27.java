package z_exam.ch7;

/*[7-27] 다음과 같은 실행결과를 얻도록 의 코드를 완성하시오 (1)~(4) .
[ ] 연습문제 /ch7/Exercise7_27.java

[ ] 실행결과
30
20
10

*/
class Outer {
	int value = 10;

	class Inner {
		int value = 20;

		void method1() {
			int value = 30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer.this.value);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

class Exercise7_27 {
	public static void main(String args[]) {
		Outer o = new Outer();
		Outer.Inner inner = o.new Inner();
		inner.method1();
	}
}