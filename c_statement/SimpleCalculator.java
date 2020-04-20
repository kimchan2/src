package c_statement;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// 두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요.

		int num1 = 0, num2 = 0;
		String op = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1을 입력해주세요 : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("연산자를 입력해주세요 : ");
		op = sc.nextLine();
		System.out.print("숫자2를 입력해주세요 : ");
		num2 = Integer.parseInt(sc.nextLine());

		// if 문
		if (op.equals("+"))
			System.out.println("결과는 : " + (num1 + num2) + "입니다.");
		else if (op.equals("-"))
			System.out.println("결과는 : " + (num1 - num2) + "입니다.");
		else if (op.equals("*"))
			System.out.println("결과는 : " + (num1 * num2) + "입니다.");
		else if (op.equals("/"))
			System.out.println("결과는 : " + (num1 / (double) num2) + "입니다.");
		else if (op.equals("%"))
			System.out.println("결과는 : " + (num1 % num2) + "입니다.");
		else
			System.out.println("허용되지 않은 연산자 입니다.");

		// switch 문
		switch (op) {
		case "+":
			System.out.println("결과는 : " + (num1 + num2) + "입니다.");
			break;
		case "-":
			System.out.println("결과는 : " + (num1 - num2) + "입니다.");
			break;
		case "*":
			System.out.println("결과는 : " + (num1 * num2) + "입니다.");
			break;
		case "/":
			System.out.println("결과는 : " + (num1 / (double) num2) + "입니다.");
			break;
		case "%":
			System.out.println("결과는 : " + (num1 % num2) + "입니다.");
			break;

		default:
			System.out.println("허용되지 않는 연산자 입니다.");
		}

	}

}
