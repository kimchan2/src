package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		int x = 2;
		int y = 5;
		char c = 'A'; // 'A' 65 의 문자코드는
		
		System.out.println(1 + x << 33);
		System.out.println(y >= 5 || x < 0 && x > 2);
		System.out.println(y += 10 - x++);
		System.out.println( !('A' <= c && c <='Z') );
		System.out.println('C'-c);
		System.out.println('5'-'0');
		System.out.println(c+1);
		System.out.println(++c);
		System.out.println(c++);
		System.out.println(c);
		
		/*
		 * 비트 연산자 - |, &, ^, ~, <<, >> - 비트 단위로 연산한다.
		 * 
		 * 기타 연산자 - .(참조 연산자) : 특정 범위 내에 속해 있는 멤버를 지칭할 때 사용한다. - (type) :
		 * 형변환(casting) - ?: (삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일 경우 수행할
		 * 문장
		 */
		// 1byte : 01010101 8bit

		/*int x = 10;
		int y = 20;
		int result = (x < y) ? x : y;
		System.out.println(result);

		// 주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		int regNo = 5;
		String gender = regNo == 1 ? "남자" : "여자";
		System.out.println(gender + " 입니다.");

		gender = regNo == 1 ? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println(gender + " 입니다.");

		// 2개의 숫자를 입력 받고, 둘 중 더 큰 숫자를 출력해주세요.
		int num1 = 0, num2 = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		num1 = Integer.parseInt(sc.nextLine());
		System.out.print("숫자를 입력해주세요 : ");
		num2 = Integer.parseInt(sc.nextLine());
		
		int num3 = (num1 > num2) ? num1 : num2;
		System.out.println("더큰 숫자는 " + num3 + "입니다.");

		// 숫자를 입력받고, 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.
		// 그외의 숫자를 입력하면 확인불가를 출력해주세요.
		
		Scanner sc = new Scanner(System.in);
		int num4 = 0;
		String gender1;
		System.out.print("숫자를 입력해 주세요 : ");
		num4 = Integer.parseInt(sc.nextLine());
		
		gender1 = (num4 == 1 || num4 == 3) ? "남자" : ((num4 == 2 || num4 == 4) ? "여자" : "확인불가");
		System.out.println("성별은 " + gender1 + "입니다.");*/
		
	}

}
