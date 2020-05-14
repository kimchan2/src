package h_useful;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {

		// 숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력해주세요 : ");
		String num = sc.nextLine();

		String newNum = "";
		
		int cnt = 0;
		
		for(int i = num.length() - 1; i >= 0; i--){
			newNum = num.charAt(i) + newNum;
			cnt++;
			if(cnt % 3 == 0 && cnt != num.length()){
				newNum = "," + newNum;
			}
		}
		
		System.out.println(newNum);
		
//		String number = sc.nextLine();
//		String back = "";
//		String newBack = "";
//		String newNumber = "";
//		
//		
//
//		if (number.length() % 3 == 0 && number.length() > 3) { // 100 // 1,000 // 10,000 // 100,000
//			for (int i = 0; i < number.length(); i++) {
//				if (i % 3 == 0 && i != 0) {
//					back = number.substring(number.length()-i, number.length());
//					newNumber = "," + back;
//				}
//			}
//			
//			newNumber = number.substring(0, 3) + newNumber;
//		}
//
//		else if (number.length() % 3 == 1 && number.length() > 3) {
//			for (int i = 0; i < number.length(); i++) {
//				if (i % 3 == 0 && i != 0) {
//					back = number.substring(number.length()-i, number.length());
//					newNumber = "," + back;
//				}
//			}
//			
//			newNumber = number.substring(0, 1) + newNumber;
//		}
//		
//		else if (number.length() % 3 == 2 && number.length() > 3) {
//			for (int i = 0; i < number.length(); i++) {
//				if (i % 3 == 0 && i != 0) {
//					back = number.substring(number.length()-i, number.length());
//					newBack = newBack + "," + back;
//				}
//			}
//			
//			newNumber = number.substring(0, 2) + newBack;
//		}
//
//		System.out.println("입력받은 숫자는 : " + newNumber);
//
//	}
//}
	}}

