package hearthstone;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Rule rule = new Rule();
		int ans;

		Player p1 = new Player(); // player 1 생성
		Player p2 = new Player(); // player 2 생성

		Deck p1_deck = new Deck(); // player 1 deck 생성
		Deck p2_deck = new Deck(); // player 2 deck 생성

		Field f1 = new Field(); // player 1 field 생성
		Field f2 = new Field(); // player 2 field 생성

		p1_deck.deck_init(); // player 1 deck init
		p2_deck.deck_init(); // player 2 deck init

		p1.hand = p1_deck.hand_init(); // player 1 hand init
		p2.hand = p2_deck.hand_init(); // player 2 hand init

		System.out.println();
		System.out.print("----------플레이어 1 핸드----------");
		System.out.println("mana : " + p1.mana);
		p1_deck.hand_info(p1.hand);
		System.out.println();
		System.out.println();
		System.out.print("----------플레이어 2 핸드----------");
		System.out.println("mana : " + p2.mana);
		p2_deck.hand_info(p2.hand);

		game_loop: while (true) {
			System.out.println();
			System.out.println("게임을 시작합니다.");
			System.out.println();

			player1: while (true) {

				int cp_p1_mana = p1.mana;
				p1.hand.add(p1_deck.pop_card()); // player 1이 p1_deck에서 카드를 한장
													// 뽑아 핸드로 가져옴
				System.out.print("----------플레이어 1 핸드----------");
				System.out.println("mana : " + cp_p1_mana);
				p1_deck.hand_info(p1.hand); // player 1의 hand 정보제공
				f1.field_info(f1, f2); // player 1의 field 정보제공

				player1_act: while (true) {
					System.out.println();
					System.out
							.print("플레이어 1의 차례입니다 (1)하수인 필드에 놓기 (2)하수인으로 하수인 공격 (3)하수인으로 상대방 공격 (4)영웅능력사용 (5)턴종료 ");
					ans = Integer.parseInt(sc.nextLine());

					switch (ans) {
					case 1: // 하수인 필드에 놓기
						if (f1.check_field() == 0) { // 0일때 필드가 꽉찬 것
							System.out.println("다시 선택해 주십시오");
						}
						System.out.print("어떤 카드를 필드 놓으시겠습니까 : ");
						ans = Integer.parseInt(sc.nextLine());
						f1.put_field(p1.hand.get(ans - 1), cp_p1_mana);
						p1.hand.remove(ans - 1);
						f1.field_info(f1, f2);
					case 2: // 하수인으로 하수인을 공격
					case 3: // 하수인으로 상대방 공격
					case 4: // 영웅능력 사용
					case 5: // 턴종료
						break player1; // 턴종료를 골랐을 경우 턴을종료 while문을 빠져나감
					}
				}
			}
			System.out.println();
			
			player2: while (true) {

				int cp_p2_mana = p2.mana;
				p2.hand.add(p2_deck.pop_card()); // player 2가 p2_deck에서 카드를 한장
													// 뽑아 핸드로 가져옴
				System.out.print("----------플레이어 2 핸드----------");
				System.out.println("mana : " + cp_p2_mana);
				p1_deck.hand_info(p2.hand); // player 2의 hand 정보제공
				f1.field_info(f1, f2); // field 정보제공

				player2_act: while (true) {
					System.out.println();
					System.out
							.print("플레이어 2의 차례입니다 (1)하수인 필드에 놓기 (2)하수인으로 하수인 공격 (3)하수인으로 상대방 공격 (4)영웅능력사용 (5)턴종료 ");
					ans = Integer.parseInt(sc.nextLine());

					switch (ans) {
					case 1: // 하수인 필드에 놓기
						if (f2.check_field() == 0) { // 0일때 필드가 꽉찬 것
							System.out.println("다시 선택해 주십시오");
							break;
						}
						System.out.print("어떤 카드를 필드 놓으시겠습니까 : ");
						ans = Integer.parseInt(sc.nextLine());
						f2.put_field(p2.hand.get(ans - 1), cp_p2_mana);
						p2.hand.remove(ans - 1);
						f2.field_info(f1, f2);
					case 2: // 하수인으로 하수인을 공격
					case 3: // 하수인으로 상대방 공격
					case 4: // 영웅능력 사용
					case 5: // 턴종료
						break player2; // 턴종료를 골랐을 경우 턴을종료 while문을 빠져나감
					}
				}
			}
			p1.plus_mana(); // 턴종료시 p1, p2 마나 ++
			p2.plus_mana();
			
			if( rule.check_continue(p1, p2) == 0 ){
				break game_loop;
			}
			else {
				continue;
			}
		}

	}
}
