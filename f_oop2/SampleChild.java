package f_oop2;

public class SampleChild extends SampleParent { // 부모가 오브젝트 클래스를 물려받기때문에 자식클래스도 오브젝트를 물려받음
												// 오브젝트 클래스는 모든 클래스들이 물려받는 클래스
	void childMethod(){
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var); // 상속받은 변수
		int result = method(7, 13); // 상속받은 메서드
		System.out.println(result);
	}

	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		
		System.out.println(sc.var);
		int result = sc.method(7, 13);
		System.out.println(result);
		
		sc.test(10);
		
		SampleParent sp = new SampleChild();
		// 부모타입이 가지고 있는 멤버만 사용할 수 있다.
//		sp.childMethod(); // 자식 메서드 사용불가
		System.out.println("sp.var : " + sp.var);
		System.out.println("sc.var : " + sc.var);
		System.out.println("sp.method() : " + sp.method(5, 10));
		System.out.println("sc.method() : " + sc.method(5, 10));
		// 오버라이딩 하게 되면 부모 클래스의 메서드는 무시된다.
	}
	
	// 오버라이딩 : 상속받은 메서드의 내용을 재정의 하는 것.
	@Override // 어노테이션 Annotation
	int method(int a, int b){ // 리턴타입, 메서드명, 파라미터 모두 같아야 한다.
		return a * b;
	}
	
	int var;
	
	void test(double var){
		System.out.println(var); // 지역변수
		System.out.println(this.var); // 인스턴스 변수 
		System.out.println(super.var); // 부모 클래스의 인스턴스 변수
		// super : 부모 클래스의 멤버와 자식 클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다.
		System.out.println(this.method(10, 20));
		System.out.println(super.method(10, 20));
	}
	
	SampleChild(){
		super();
		// super()를 사용해 부모 클래스의 객체도 생성한다.
		// super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
	}
	
}
