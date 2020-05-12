package z_exam.ch7;
/*
[7-28] 아래의 EventHandler를 익명 클래스(anonymous class)로 변경하시오.
[연습문제]/ch7/Exercise7_28.java*/
import java.awt.*;
import java.awt.event.*;

class Exercise7_28 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}
}
/* ***** 나중에 다시 볼 것 *****
[7-29] 지역 클래스에서 외부 클래스의 인스턴스멤버와 static멤버에 모두 접근할 수 있
지만, 지역변수는 final이 붙은 상수만 접근할 수 있는 이유 무엇인가?

메서드가 수행을 마쳐서 지역변수가 소멸된 시점에도, 지역 클래스의 인스턴스가
소멸된 지역변수를 참조하려는 경우가 발생할 수 있기 때문이다.

[연습문제]/ch10/Exercise7_29.java
import java.awt.*;
import java.awt.event.*;
class Exercise7_29
{
public static void main(String[] args)
{
final int VALUE = 10; // 외부 클래스의 지역변수
Thread t = new Thread(new Runnable() { // 익명 클래스(내부 클래스)
public void run() {
for(int i=0; i < 10;i++) { // 10번 반복한다.
try {
Thread.sleep(1*1000); // 1초간 멈춘다.
} catch(InterruptedException e) {}
System.out.println(VALUE); // 외부 클래스의 지역변수를 사용
}
} // run()
});
t.start(); // 쓰레드를 시작한다.
System.out.println("main() - 종료.");
} // main
}
[실행결과]
main() - 종료.
10
10
10
10
10
10
10
10
10
10

[해설] 아직 쓰레드를 배우지 않았지만, 쓰레드를 사용해서 상황을 만들어 보았다.
실행결과를 보면 main메서드가 종료된 후에도 지역변수 VALUE의 값을 사용하고 있다는 것
을 알 수 있다. 지역변수는 메서드가 종료되면 함께 사라지지만, 상수의 경우 이미 컨스
턴트 풀(constant pool, 상수를 따로 모아서 저장해 놓는 곳)에 저장되어 있기 때문에 사
용할 수 있는 것이다.

*/