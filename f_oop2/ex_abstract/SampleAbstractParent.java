package f_oop2.ex_abstract;

public abstract class SampleAbstractParent { // 추상 메서드가 있는 클래스는 반드시 추상 클래스 여야 한다

	void method(){
		
	}
	
	// 추상 메서드 : 선언부만 있고 구현부는 없는 메서드
	abstract void abstractMenthod();
	
}

class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMenthod() {
		
		
	}
	
	
}