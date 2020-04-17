package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * if문 - if : 조건식의 결과가 true이면 블럭안의 문장을 수행한다. - else if: 다수의 조건이 필요할 때 if
		 * 뒤에 추가한다. - else : 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
		 * 
		 * if(조건식){} else if(조건식){} else(){}
		 */

		/*
		 * int a = 10;
		 * 
		 * if (a < 100) {
		 * 
		 * System.out.println("조건식의 연산결과가 true이면 수행된다.");
		 * 
		 * }
		 * 
		 * if (a < 10) { System.out.println("false면 수행 x"); }
		 * 
		 * int regNo = 2; String gender = null;
		 * 
		 * if (regNo == 1 || regNo == 3) { gender = "남성";
		 * System.out.println(gender); } else if (regNo == 2 || regNo == 4) {
		 * gender = "여성"; System.out.println(gender); } else { gender =
		 * "남성도 여성도 아닙니다"; System.out.println(gender); }
		 * 
		 * // 성적에 등급을 부여하는 프로그램 int score = 88; String grade = null;
		 * 
		 * if (score >= 90) { grade = "A"; } else if (score >= 80) { grade =
		 * "B"; } else if (score >= 70) { grade = "C"; } else if (score >= 60) {
		 * grade = "D"; } else { grade = "F"; }
		 * 
		 * System.out.println(score + "점에 해당하는 등급은 " + grade + "입니다.");
		 */

		// 등급 안에서 +, -를 나누어보자.
		int score = 88;
		String grade = null;

		score = 50;
		grade = null;

		if (score >= 90) {
			grade = "A";

			if (score >= 97) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (score >= 80) {
			grade = "B";

			if (score >= 87) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (score >= 70) {
			grade = "C";

			if (score >= 77) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (score >= 60) {
			grade = "D";

			if (score >= 67) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}
		} else {
			grade = "F";
		}

		System.out.println(score + "점에 해당하는 등급은 " + grade + "입니다.");

		/*
		 * switch 문 - 조건식과 일치하는 case문 이후의 문장을 수행한다. - 조건식의 결과는 정수와 문자열만(JDK1.7부터
		 * 문자열 허용) 허용한다.
		 * 
		 * switch(조건식){ case 값: break; case 값: break; case 값: break; case 값:
		 * break; }
		 */

		int regNo = 2;
		String gender = null;

		switch (regNo) {
		case 1:
		case 3:
			gender = "남자";
			break;
		case 2:
		case 4:
			gender = "여자";
			break;
		// case 3:
		// gender = "남자";
		// break;
		// case 4:
		// gender = "여자";
		// break;
		default: // if문의 else와 같은 역할을 한다.
			gender = "확인불가";
		}

		System.out.println("당신의 성별은 " + gender + "입니다.");

		score = 95;
		grade = null;
		int grade1 = score / 10;

		switch (grade1) {
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		case 5:
			grade = "E";
			break;
		default:
			grade = "F";
		}

		System.out.println(score + "점에 해당하는 등급은 " + grade + "입니다.");

		// 숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
//		int num = 0;
		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자를 입력해 주세요 : ");
//
//		num = Integer.parseInt(sc.nextLine());
//		if (num == 0)
//			System.out.println("입력 받은 숫자는 0 입니다.");
//		else
//			System.out.println("입력 받은 숫자는 0이 아닙니다.");
//
//		// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
//		System.out.print("숫자를 입력해 주세요 : ");
//
//		num = Integer.parseInt(sc.nextLine());
//		if (num % 2 == 0)
//			System.out.println("입력 받은 숫자는 짝수 입니다.");
//		else
//			System.out.println("입력 받은 숫자는 홀수 입니다.");

		// 점수 3개 입력받아 총점, 평균, 등급을 출력해주세요
		int score1 = 0, score2 = 0, score3 = 0;
		int sum = 0;
		float avg = 0f;
		String grd;
		
		System.out.print("점수1 입력 : ");
		score1 = Integer.parseInt(sc.nextLine());
		System.out.print("점수2 입력 : ");
		score2 = Integer.parseInt(sc.nextLine());
		System.out.print("점수3 입력 : ");
		score3 = Integer.parseInt(sc.nextLine());
		
		sum = score1 + score2 + score3;
		avg = sum/3f;
		if(avg >= 90)
			grd = "A";
		else if(avg >= 80)
			grd = "B";
		else if(avg >= 70)
			grd = "C";
		else if(avg >= 60)
			grd = "D";
		else if(avg >= 50)
			grd = "E";
		else
			grd = "F";
		
		System.out.println("총점은 " + sum + ", 평균은 " + avg + ", 등급은 " + grd + "입니다.");
		
	}

}
