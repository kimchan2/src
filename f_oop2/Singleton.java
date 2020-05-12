package f_oop2;

public class Singleton {
	
	private static Singleton instance;

	private Singleton(){ // 다른 클래스에서 생성자에 접근하지 못하게, 호출하지 못하므로 객체 생성을 못함
		
	}
	
	public static Singleton getInstance(){ // 메서드를 통해 접근하게 만듦
		
		if(instance == null){ // 값을 공유하기 위해서 null 일때만 생성
			instance = new Singleton();
		}
		return instance; // null이 아니면 생성되어있던 instance를 반환해서 객체를 공유하게 만듦
	}
	
	/*
	 * 싱글톤 사용 이유
	 * - 메모리 절약
	 * - 속도 향상
	 * - 객체 공유
	 */
	
	
}

class sinton{

	private static sinton instance;
	
	private sinton(){
		
	}
	
	public static sinton getInstance(){
		if(instance == null){
			instance = new sinton();
		}
		return instance;
	}
}











