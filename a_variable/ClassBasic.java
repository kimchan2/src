// 패키지 : 클래스의 위치 
package a_variable;

// 주석 : 프로그램 코드로 인식하지 않는 문장(주로 코드를 설명하는데 사용한다.)

//한줄 주석 : ctrl + shift + c

/*
 범위 주석 : ctrl + shift + / (해제 : ctrl + shift + \) 
*/

public class ClassBasic { //{}: 블럭(범위) 

	//	블럭이 시작되면 탭1칸으로 계층을 표현한다.
	
	//	변수 : 데이터를 담는 그릇
	int var = 10;
	
	//메서드 : 클래스의 기능
	public static void main(String[] args){ // main 메서드 : 프로그램을 시작하는 메서드
		// ^_^ ^_^ ^_- ^_ @ ㅎ _ ㅎ
		// 하고싶은 일을 메서드 안에 적는다.
		System.out.println("Hello"); // 괄호안에 있는 내용을 출력하는 메서드 // ln : line 줄바꿈
		System.out.print("Hello");
		System.out.print("Hello"); 
		System.out.printf("%s", "Hello"); // 출력 포맷을 지정한다.
		//;(세미콜론) : 문장의 마침표
		//코드가 기본적으로 위에서 아래 방향으로 왼쪽에서 오른쪽방향으로 실행된다.
		//main 메서드의 마지막 문장까지 실행되면 프로그램이 종료된다.
		//괄호가 있는건 메소드다! 메소드가 실행될 때 필요한 데이터를 주고 받는 역할

	}

}
