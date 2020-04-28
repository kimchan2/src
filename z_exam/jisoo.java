package z_exam;

import java.util.Scanner;

public class jisoo {

	public static void main(String[] args) {

		/*int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		for(int i=0; i < answer.length;i++) {
			counter[answer[i]-1]++;
		}
		for(int i=0; i < counter.length;i++) {
			System.out.print(counter[i]);
			
			for(int j=0; j < counter[i]; j++) {
				 System.out.print("*");
			}			
			System.out.println();
}*/
		
/*//		
//		다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다. 변
//		수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하
//		라. 단, 가능한 한 적은 수의 동전으로 거슬러 주어야한다. (1)에 알맞은 코드를 넣어서
//		프로그램을 완성하시오.
//		[Hint] 나눗셈 연산자와 나머지 연산자를 사용해야 한다.
		
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.println("money="+money);
		for(int i=0;i<coinUnit.length;i++) {
			
			System.out.println(coinUnit[i]+ " 원 :" + money/coinUnit[i]);//나눗셈
			
			 money = money%coinUnit[i];//나머지
			
			
		
		} // main
		
	
	}
}
*/
		
		
	
		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		int money = 50000;
		System.out.println("money="+money);
		int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
		int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수
		for(int i=0;i<coinUnit.length;i++){
		int coinNum = 0;
		
	
		coinNum = money/coinUnit[i]; //1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
		coin[i] = coin[i]- coinNum;
		if(coin[i]>=coinNum){
			coin[i] = coin[i]- coinNum; }
		else{
			coinNum = coin[i];
			coin[i] = 0;
		}
		money -= coinNum * coinUnit[i];
		
		System.out.println(coinUnit[i]+"원: "+coinNum);
		}
		if(money > 0) {
		System.out.println("거스름돈이 부족합니다.");
		System.exit(0); // 프로그램을 종료한다.
		}
		System.out.println("=남은 동전의 개수 =");
		for(int i=0;i<coinUnit.length;i++) {
		System.out.println(coinUnit[i]+"원:"+coin[i]);
		}
	}
}

		