package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		// 1~9 까지 3개의 랜덤한 숫자를 발생시킨다.

		int num1 = 0;
		int num2 = 0;
		int num3 = 0;

		while (true) {
			num1 = (int) (Math.random() * 9) + 1;
			num2 = (int) (Math.random() * 9) + 1;
			if (num1 != num2) {
				num3 = (int) (Math.random() * 9) + 1;
				if (num2 != num3 && num1 != num3)
					break;
			}
		}
		
		System.out.println(num1 + " " + num2 + " " + num3);
		
		int st_cnt = 0;
		int ball_cnt = 0;
		int out_cnt = 0;
		
		int user_num1 = 0;
		int user_num2 = 0;
		int user_num3 = 0;
		
		while(st_cnt != 3){
		// 사용자에게 3개의 숫자를 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자1을 입력해주세요 : ");
		user_num1 = Integer.parseInt(sc.nextLine());
		System.out.print("숫자2을 입력해주세요 : ");
		user_num2 = Integer.parseInt(sc.nextLine());
		System.out.print("숫자3을 입력해주세요 : ");
		user_num3 = Integer.parseInt(sc.nextLine());

		st_cnt = 0;
		ball_cnt = 0;
		out_cnt = 0;

		// 입력받은 숫자를 정답과 비교해 SBO를 계산한다.
		if (num1 == user_num1)
			st_cnt++;
		if (num2 == user_num2)
			st_cnt++;
		if (num3 == user_num3)
			st_cnt++;

		if (num1 == user_num2) 
			ball_cnt++;
		if (num1 == user_num3)
			ball_cnt++;
		if (num2 == user_num3)
			ball_cnt++;
		if (num2 == user_num1)
			ball_cnt++;
		if (num3 == user_num1)
			ball_cnt++;
		if (num3 == user_num2)
			ball_cnt++;

		if ((num1 != user_num1) && (num1 != user_num2) && (num1 != user_num3)) {
			out_cnt++;
		}
		if ((num2 != user_num1) && (num2 != user_num2) && (num2 != user_num3)) {
			out_cnt++;
		}
		if ((num3 != user_num1) && (num3 != user_num2) && (num3 != user_num3)) {
			out_cnt++;
		}
		
		System.out.println("결과는 : " + st_cnt + "S " + ball_cnt + "B " + out_cnt + "O");
		
		}
		
		// 결과를 출력한다.
		System.out.println("정답입니다. 정답은 " + num1 + " " + num2 + " " + num3);

	}
}
