package f_oop2.ex_abstract.ex_interface;

public interface SampleInterface { // 상수, 추상 메서드만 정의 가능
	
	// 인터페이스의 모든 멤버변수는 public static final 제어자를 사용해야 한다.
	public static final int NUM1 = 1;
	
	// 모든 멤버변수의 제어자가 같기 때문에 생략이 가능하다.
	int NUM2 = 2;
	
	// 인터페이스의 모든 메서드는 public abstract 제어자를 사용해야 한다.
	public abstract void method1(); 
	
	// 모든 메서드의 제어자가 같기 때문에 생략이 가능하다.
	void method2();

}

//인터페이스를 상속 받을땐 implements 사용, 클래스는 extends, 인터페이스는 다중 상속이 가능하다
class SampleImplement implements SampleInterface, SampleInterface2{

	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	} 
	
	
	
}

interface SampleInterface2 {
	void method1(); // 다른 인터페이스에 있는 메서드와 이름이 같지만 내용이 없으므로 상관이 없다.
	void method3();
}













