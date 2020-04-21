package c_statement;

import java.util.Scanner;

public class SimLiTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = " ";

		int q = 0;

		q9: while (true) {
			if (q == 1) {
				System.out.println("아무것도 아닌 일에 쉽게 섭섭함이 쌓인다 : ");
				choice = sc.nextLine();
				if (choice.equals("Yes")) {
					choice = "D Type";
					break q9;
					// D type
				}
				if (choice.equals("No")) {
					choice = "C Type";
					break q9;
					// C type
				}
			}
			q8: while (true) {
				if (q == 1) {
					System.out.println("이성친구는 존재할 수 없다 : ");
					choice = sc.nextLine();
					if (choice.equals("Yes"))
						continue q9;
					if (choice.equals("No")) {
						choice = "B Type";
						break q9;
						// B Type
					}
				}
				q7: while (true) {
					if (q == 1) {
						System.out.println("연락이 없어도 믿고 기다리는 편이다 : ");
						choice = sc.nextLine();
						if (choice.equals("Yes")) {
							choice = "A Type";
							break q9;
						}
						// A Type
						if (choice.equals("No"))
							continue q8;
					}
					q6: while (true) {
						if (q == 1) {
							System.out.println("활동적인 데이트가 좋다 : ");
							choice = sc.nextLine();
							if (choice.equals("Yes"))
								continue q8;
							if (choice.equals("No"))
								continue q9;
						}
						q5: while (true) {
							if (q == 1) {
								System.out.println("감정 표현에 솔직한 편이다 : ");
								choice = sc.nextLine();
								if (choice.equals("Yes"))
									continue q8;
								if (choice.equals("No"))
									continue q6;
							}
							q4: while (true) {
								if (q == 1) {
									System.out.println("감정기복이 크지 않다 : ");
									choice = sc.nextLine();
									if (choice.equals("Yes"))
										continue q7;
									if (choice.equals("No"))
										continue q5;
								}
								q3: while (true) {
									if (q == 1) {
										System.out
												.println("데이트 코스는 미리 짜는게 편하다 : ");
										choice = sc.nextLine();
										if (choice.equals("Yes"))
											continue q6;
										if (choice.equals("No"))
											continue q5;
									}
									q2: while (true) {
										if (q == 1) {
											System.out
													.println("연애할 때 끌려다니는 타입이다 : ");
											choice = sc.nextLine();
											if (choice.equals("Yes"))
												continue q5;
											if (choice.equals("No"))
												continue q3;
										}
										q1: while (true) {
											System.out.println("연애심리테스트");
											System.out.println("나는 금사빠다 : ");
											choice = sc.nextLine();
											q = 1;
											if (choice.equals("Yes"))
												continue q2;
											if (choice.equals("No"))
												continue q4;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(choice);
		if (choice.equals("A Type"))
			System.out.println("서로에 대한 신뢰감이 깊고, 존중해주는 어른스러운 연애를 하는 타입!");
		if (choice.equals("B Type"))
			System.out.println("구속을 하는 것도, 받는 것도 싫은 자유로운 연애를 하는 타입!");
		if (choice.equals("C Type"))
			System.out.println("이것은 의리인가 사랑인가.. 친구같이 편안한 연애를 하는 타입!");
		if (choice.equals("D Type"))
			System.out.println("무조건 잘해주고, 무조건 맞춰주는 다 퍼주는 연애를 하는 타입!");
		
	}
}
