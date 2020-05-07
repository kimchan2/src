package f_oop2.ex_abstract.ex_interface;

public class Starcraft {

	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
//		scv.repair(marine);
		
		
	}
	
}

class Unit{
	int hp;
	final int MAX_HP;

	Unit(int hp){
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class Marine extends Unit{ // 부모클래스의 생성자에 파라미터가 있기 때문에 생성자를 직접만들어주지 않으면 컴파일 에러
	
	Marine(){
		super(40);
	}
}

class Tank extends Unit implements Repairable{
	Tank(){
		super(150);
	}
}

class Dropship extends Unit implements Repairable{
	Dropship(){
		super(125);
	}
}

class SCV extends Unit implements Repairable{
	SCV(){
		super(60);
	}
	
	// 마린은 Repairable을 상속받지 않았음, 상속받은 클래스만 수리 가능하게됨
	void repair(Repairable r){
		if(r instanceof Unit){ // Unit 클래스로 형변환이 가능한지 확인 
			Unit u = (Unit)r; // 가능하다면 형변환을 한다, 형변환해야 hp에 접근가능, 자동으로는 형변환이 안됨
							  // Unit과 Repairable은 아무 관계도 아님, 자동형변환은 자식 -> 부모 일때
			
			while(u.hp < u.MAX_HP){
				u.hp++;
			}
		}
	}
}

interface Repairable{
	
}







