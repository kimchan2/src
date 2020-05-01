package e_oop;

import java.util.Scanner;

public class SimLiTest {

	char type;
	ScanUtil sc = new ScanUtil();

	void q1() {

		String ans;
		System.out.print("나는 금사빠다 Yes or No : ");
		ans = sc.nextLine();
		
		if (ans.equals("Yes")) {
			q2();
		}

		if (ans.equals("No")) {
			q4();
		}

	}

	void q2() {

		String ans;
		System.out.print("연애할 때 끌려다니는 타입이다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			q5();
		}

		if (ans.equals("No")) {
			q3();
		}
	}

	void q3() {

		String ans;
		System.out.println("데이트 코스는 미리 짜는게 편하다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			q6();
		}

		if (ans.equals("No")) {
			q5();
		}
	}

	void q4() {

		String ans;
		System.out.println("감정기복이 크지 않다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			q7();
		}

		if (ans.equals("No")) {
			q5();
		}
	}

	void q5() {

		String ans;
		System.out.print("감정 표현이 솔직한 편이다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			q8();
		}

		if (ans.equals("No")) {
			q6();
		}
	}

	void q6() {

		String ans;
		System.out.print("활동적인 데이트가 좋다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			q8();
		}

		if (ans.equals("No")) {
			q9();
		}
	}

	void q7() {

		String ans;
		System.out.print("연락이 없어도 믿고 기다리는 편이다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			type = 'A';
			answer(type);
		}

		if (ans.equals("No")) {
			q8();
		}
	}

	void q8() {

		String ans;
		System.out.print("이성친구는 존재할 수 없다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			q9();
		}

		if (ans.equals("No")) {
			type = 'B';
			answer(type);
		}
	}

	void q9() {

		String ans;
		System.out.print("아무것도 아닌 일에 쉽게 섭섭함이 쌓인다 Yes or No : ");
		ans = sc.nextLine();

		if (ans.equals("Yes")) {
			type = 'D';
			answer(type);
		}

		if (ans.equals("No")) {
			type = 'C';
			answer(type);
		}
	}

	void answer(char type) {
		if (type == 'A') {
			System.out.println("A타입 : 서로에 대한 신뢰감이 높고, 존중해주는 어른스러운 연애를 하는 타입!");
		}

		if (type == 'B') {
			System.out.println("B타입 : 구속을 하는 것도, 받는 것도 싫은 자유로운 연애를 하는 타입!");
		}

		if (type == 'C') {
			System.out.println("C타입 : 이것은 의리인가 사랑인가... 친구같이 편안한 연애를 하는 타입!");
		}

		if (type == 'D') {
			System.out.println("D타입 : 무조건 잘해주고, 무조건 맞춰주는 다 퍼주는 연애를 하는 타입!");
		}
	}

	public static void main(String[] args) {

		System.out.println("나의 연애 유형은? 말해  Yes or No!");
		SimLiTest st = new SimLiTest();
		st.q1();
	}

}
