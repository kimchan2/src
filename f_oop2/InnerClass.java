package f_oop2;

public class InnerClass {
	
	/*
	 * 내부 클래스
	 * - 클래스 내부에서 선언된 클래스이다.
	 * - 선언된 위치와 형태에 따라 여러가지로 나누어진다.
	 * - 인스턴스 클래스 : 멤버변수 선언위치에 선언하며, 인스턴스 멤버들과 관련된 작업에 사용된다.
	 * - 스태틱 클래스 : static이 붙고 멤버변수 선언위치에 선언하며, static 멤버들과 관련된 작업에 사용된다.
	 * - 지역 클래스 : 메서드나 초기화블럭 안에 선언하며, 선언된 영역 내부에서만 사용될 수 있다.
	 * - 익명 클래스 : 이름이 없고, 선언과 객체 생성을 동시에 한다.(일회용)
	 */

	
	
}

class Outer{
	
	//인스턴스 변수
	int instanceVar = 1;
	int var = 10;
	
	//클래스 변수
	static int classVar = 2;
	
	// 인스턴스 클래스
	class InstanceInner{
		// 인스턴스 클래스에서는 인스턴스 멤버와 클래스 멤버 모두 사용 가능
		int inner1 = instanceVar;
		int inner2 = classVar;
		int var = 20;
		
		void method(){
			int var = 30;
			
			System.out.println(var);
			System.out.println(this.var); // 인스턴스 변수 호출
			System.out.println(Outer.this.var); // 바깥에 있는 인스턴스 변수 호출, 클래스명으로 접근
			
		}
		
	}
	
	// 스태틱 클래스
	static class StaticInner{
		// 스태틱 클래스에서는 클래스 멤버만 사용 가능
//		int inner1 = instanceVar;
		int inner2 = classVar;
		static int inner3 = classVar;
	}
	
	void method(){
		// 지역 변수
		int localVar1 = 3;
		final int localVar2 = 4;
		
		// 지역 클래스
		class LocalInner{
			// 지역 클래스에서는 인스턴스 멤버와 클래스 멤버 모두 사용 가능하고
			// final이 붙은 지역 변수도 사용 가능
			int inner1 = instanceVar;
			int inner2 = classVar;
//			int inner3 = localVar1; final이 붙은것만 사용가능
			int inner4 = localVar2;
		}
		
		// 지역 클래스는 메서드 내부에서 인스턴스화를 통해 사용 가능
		LocalInner li = new LocalInner();
		System.out.println(li.inner1);
		System.out.println(li.inner2);
		System.out.println(li.inner4);
		
	}

	void test1(){
		// 인스턴스 클래스의 인스턴스 멤버에 접근하기 위해서는 인스턴스화를 해야한다.
		InstanceInner li = new InstanceInner();
		System.out.println(li.inner1);
		System.out.println(li.inner2);
		
		System.out.println(StaticInner.inner3); // static이 붙은 클래스 변수만 클래스명.변수명 으로 접근가능
//		System.out.println(StaticInner.inner2); // 에러
		// 스태틱 클래스의 인스턴스 멤버에 접근하기 위해서는 인스턴스화를 해야한다
		StaticInner si = new StaticInner();
		System.out.println(si.inner2);
		
	}
	
	static void test2(){
		Outer o = new Outer();
		InstanceInner li = o.new InstanceInner();
		System.out.println(li.inner1);
		System.out.println(li.inner2);
		
//		new Outer().new InstanceInner();
		
		System.out.println(StaticInner.inner3);
		
		StaticInner si = new StaticInner();
		System.out.println(si.inner2);
		
		
	}
	
}



















