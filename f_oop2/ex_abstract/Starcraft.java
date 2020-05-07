package f_oop2.ex_abstract;

public class Starcraft {

	
	
}

class Marine{
	int x, y; // 현재 위치

	// 지정된 위치로 이동한다.
	void move(int x, int y){
		
	}
	
	// 현재 위치에서 정지한다.
	void stop(){
		
	}
	
	// 스팀팩을 사용한다.
	void stimPack(){
		
	}
}

class Dropship{
	int x, y; // 현재 위치

	// 지정된 위치로 이동한다.
	void move(int x, int y){
		
	}
	
	// 현재 위치에서 정지한다.
	void stop(){
		
	}
	
	// 선택된 대상을 태운다.
	void load(){
		
	}
	
	// 선택된 대상을 내린다.
	void unload(){
		
	}
}

// 공통된 변수와 메서드를 부모클래스로 만든다.
abstract class Unit{
	int x, y;
	
	//자식마다 내용이 다를 수 있는 메서드는 추상메서드로 만들면 자식클래스가 내용을 구현한다.
	abstract void move(int x, int y);
	
	void stop(){
		
	}
	
}

class Tank extends Unit{

	@Override
	void move(int x, int y) {
		
		
	}
	
	// 시즈 모드로 변환한다.
	void changeMode(){
		
	}
	
	
	
}
















