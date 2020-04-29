package e_oop;

public class ClassMaker2 {
	
	//초기화 순서 : 명시적 초기화 -> 초기화 블럭 -> 생성자
	
	//전역변수 하나를 선언하고 명시적으로 초기화 해주세요.
	
	//동시에 초기화까지 하는 것을 명시화 초기화라고 한다
	int a = 10;
	
	//위에서 선언한 전역변수를 초기화 블럭을 사용하여 초기화 해주세요.
	{
//		for(int i = 1;i <= 10; i++){
//			a += 1;
//		}
		a =20;
	}
	
	//위에서 선언한 전역변수를 생성자의 파라미터를 사용해 초기화 해주세요.
	ClassMaker2(int a){
//		for(int i = 1;i <= a; i++){
//			this.a += 1;
//		}
		this.a =a;
	}
	
	//위에서 선언한 전역변수를 생성자를 하나 더 만들어서 초기화 해주세요.
	ClassMaker2(int a, int b){
		for(int i = a;i <= b; i++){
			this.a += 1;
		}
	}
	
	ClassMaker2(){
		this(1000);
	}
}
