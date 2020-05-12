package z_exam.ch7;

/*[7-25] Outer Inner iv . 클래스의 내부 클래스 의 멤버변수 의 값을 출력하시오

class Outer {
	class Inner {
		int iv = 100;
	}
}

class Exercise7_25 {
	public static void main(String[] args) {

		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		System.out.println(i.iv);
	}
}*/