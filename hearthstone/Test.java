package hearthstone;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Rule rule = new Rule();
		int ans;
		int use_hero_power_cnt = 0;

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

//		System.out.println();
//		System.out.print("----------플레이어 1 핸드----------");
//		System.out.println("mana : " + p1.mana);
//		p1_deck.hand_info(p1.hand);
//		System.out.println();
//		System.out.println();
//		System.out.print("----------플레이어 2 핸드----------");
//		System.out.println("mana : " + p2.mana);
//		p2_deck.hand_info(p2.hand);

		System.out.println();
		System.out.println("게임을 시작합니다.");
		System.out.println();
		
		game_loop: while (true) {

			int cp_p1_mana = p1.mana;
			player1: while (true) {
				
				use_hero_power_cnt = 0; // 영웅능력 사용 여부 변수 초기화
				p1.hand.add(p1_deck.pop_card()); // player 1이 p1_deck에서 카드를 한장
													// 뽑아 핸드로 가져옴
				System.out.print("----------플레이어 1 핸드----------");
				System.out.print("hp : " + p1.hp);
				System.out.println(", mana : " + cp_p1_mana);
				p1_deck.hand_info(p1.hand); // player 1의 hand 정보제공
				f1.field_info(f1, f2); // field 정보제공

				player1_act: while (true) {
					
					System.out.println();
					System.out.println("플레이어 1의 현재 마나 : " + cp_p1_mana);
					System.out
							.print("플레이어 1의 차례입니다 (1)하수인 필드에 놓기 (2)하수인으로 하수인 공격 (3)하수인으로 상대방 공격 (4)영웅능력사용 (5)턴종료 ");
					ans = Integer.parseInt(sc.nextLine());
					
					System.out.println();
					
					switch (ans) {
					case 1: // 하수인 필드에 놓기
						if (f1.check_field() == 0) { // 0일때 필드가 꽉찬 것
							System.out.println("다시 선택해 주십시오");
							continue;
						}
						System.out.print("어떤 카드를 필드 놓으시겠습니까 : ");
						ans = Integer.parseInt(sc.nextLine()); // 카드 번호를 입력받음 앞에서부터 0번, 사용자입력은 1부터
						if(p1.hand.get(ans - 1).mana <= cp_p1_mana){ // 내가 선택한 카드가 내 현재 마나보다 작거나 같으면
							cp_p1_mana = f1.put_field(p1.hand.get(ans - 1), cp_p1_mana); // 입력받은 카드를 필드 리스트에 넣고 사용후 남은 마나를 반환받음
							p1.hand.remove(ans - 1); // 사용한 카드를 핸드에서 제거함
						} else
							System.out.println("마나가 부족합니다.");
						f1.field_info(f1, f2); // 필드정보 제공
						continue;
						
					case 2: // 하수인으로 하수인을 공격
						int card1, card2;
						int result = 0; // 공격 결과, 내카드가 죽었으면 1, 상대카드가 죽었으면 2, 아무일도 없었으면 0
						System.out.print("어떤 카드로 공격하시겠습니까? : ");
						card1 = Integer.parseInt(sc.nextLine()); // 내가 공격할 카드 결정
						if ( f1.field.get(card1-1).offen != 1 ){
							System.out.println("이번 턴에 낸 카드는 공격할 수 없습니다.");
							continue;
						}
						System.out.print( card1 +"번 카드로 상대의 몇 번 카드를 공격하시겠습니까? : ");
						card2 = Integer.parseInt(sc.nextLine()); // 공격받을 상대 카드 결정
						
						if(rule.check_prvk(f2.field) == 1 && f2.field.get(card2-1).prvk != 1){ // 필드에 도발 카드가 있고 == 1
							System.out.println("상대 필드에 도발 카드가 있습니다. 도발카드 우선 공격해야합니다"); // 내가 선택한 카드가 도발카드가 아니라면 실행됨
							continue;
						}
						
						result = p1.attack_minion(f1.field.get(card1-1), f2.field.get(card2-1)); // 내카드로 상대 카드를 공격
						if(result == 1){ // 1반환이면 내카드가 죽음, 필드에서 삭제
							f1.field.remove(card1-1);
							continue;
						}
						else if(result == 2){ // 2반환이면 상대카드가 죽음, 필드에서 삭제
							f2.field.remove(card2-1);
							continue;
						}
						else if(result == 3){ // 3반환이면 둘다 죽음, 둘다 삭제
							f1.field.remove(card1-1);
							f2.field.remove(card2-1);
							
						}else // 위경우가 모두 아니면 계속진행
							continue;
						
					case 3: // 하수인으로 상대방 공격
						if(rule.check_prvk(f2.field) == 1){ // 필드에 도발 카드가 있으면 == 1, 상대방을 공격하지 못함, 도발카드 우선
							System.out.println("상대 필드에 도발 카드가 있습니다. 도발카드 우선 공격해야합니다");
							continue;
						}
						int card3;
						System.out.print("어떤 카드로 공격하시겠습니까? : ");
						card3 = Integer.parseInt(sc.nextLine()); // 내가 공격할 카드 결정
						if ( f1.field.get(card3-1).offen != 1 ){
							System.out.println("이번 턴에 낸 카드는 공격할 수 없습니다.");
							continue;
						}
						p1.attack_hero(f1.field.get(card3-1), p2);
						System.out.println("player 2의 hp가 " + p2.hp + "남았습니다.");
						continue;
						
					case 4: // 영웅능력 사용
						if(use_hero_power_cnt > 0){
							System.out.println("이미 영웅능력을 사용 했습니다.");
							continue;
						}
						cp_p1_mana = p1.use_hero_power(p2, cp_p1_mana);  // 현재 남아있는 마나 cp_p1_mana에서 2만큼사용하고 남은 마나 리턴
						System.out.println("영웅능력으로 2의 데미지를 주었습니다. player 2의 hp가 " + p2.hp + "남았습니다.");
						use_hero_power_cnt++;
						continue;
						
					case 5: // 턴종료
						System.out.println();
						System.out.println("====================player 1 턴 종료====================");
						System.out.println();
						break player1; // 턴종료를 골랐을 경우 턴을종료 player1: while문을 빠져나감
					}
				}
			}
			rule.offen_permis(f1.field);
			
			if( rule.check_hp(p1, p2) == 0 ){
				break game_loop;
			}
			
			System.out.println();

			int cp_p2_mana = p2.mana;
			player2: while (true) {

				use_hero_power_cnt = 0; // 영웅능력 사용 여부 변수 초기화
				p2.hand.add(p2_deck.pop_card()); // player 2가 p2_deck에서 카드를 한장
													// 뽑아 핸드로 가져옴
				System.out.print("----------플레이어 2 핸드----------");
				System.out.print("hp : " + p1.hp);
				System.out.println(", mana : " + cp_p2_mana);
				p1_deck.hand_info(p2.hand); // player 2의 hand 정보제공
				f1.field_info(f1, f2); // field 정보제공

				player2_act: while (true) {
					
					System.out.println();
					System.out.println("플레이어 2의 현재 마나 : " + cp_p2_mana);
					System.out
							.print("플레이어 2의 차례입니다 (1)하수인 필드에 놓기 (2)하수인으로 하수인 공격 (3)하수인으로 상대방 공격 (4)영웅능력사용 (5)턴종료 ");
					ans = Integer.parseInt(sc.nextLine());
					
					System.out.println();
					
					switch (ans) {
					case 1: // 하수인 필드에 놓기
						if (f2.check_field() == 0) { // 0일때 필드가 꽉찬 것
							System.out.println("다시 선택해 주십시오");
							continue;
						}
						System.out.print("어떤 카드를 필드 놓으시겠습니까 : ");
						ans = Integer.parseInt(sc.nextLine()); // 카드 번호를 입력받음 앞에서부터 0
						if(p2.hand.get(ans - 1).mana <= cp_p2_mana){ // 내가 선택한 카드가 내 현재 마나보다 작거나 같으면
							cp_p2_mana = f2.put_field(p2.hand.get(ans - 1), cp_p2_mana); // 입력받은 카드를 필드 리스트에 넣고 사용후 남은 마나를 반환받음
							p2.hand.remove(ans - 1); // 사용한 카드를 핸드에서 제거함
						} else
							System.out.println("마나가 부족합니다.");
						f2.field_info(f1, f2); // 필드정보 제공
						continue;
						
					case 2: // 하수인으로 하수인을 공격
						int card1, card2;
						int result = 0; // 공격 결과, 내카드가 죽었으면 1, 상대카드가 죽었으면 2, 아무일도 없었으면 0
						System.out.print("어떤 카드로 공격하시겠습니까? : ");
						card1 = Integer.parseInt(sc.nextLine()); // 내가 공격할 카드 결정
						if ( f2.field.get(card1-1).offen != 1 ){
							System.out.println("이번 턴에 낸 카드는 공격할 수 없습니다.");
							continue;
						}
						System.out.print( card1 +"번 카드로 상대의 몇 번 카드를 공격하시겠습니까? : ");
						card2 = Integer.parseInt(sc.nextLine()); // 공격받을 상대 카드 결정
						
						if(rule.check_prvk(f1.field) == 1 && f1.field.get(card1-1).prvk != 1){ // 필드에 도발 카드가 있고 == 1
							System.out.println("상대 필드에 도발 카드가 있습니다. 도발카드 우선 공격해야합니다"); // 내가 선택한 카드가 도발카드가 아니라면 실행됨
							continue;
						}
						
						result = p2.attack_minion(f2.field.get(card1-1), f1.field.get(card2-1)); // 내카드로 상대 카드를 공격
						if(result == 1){
							f2.field.remove(card1-1);
							continue;
						}
						else if(result == 2){
							f1.field.remove(card2-1);
							continue;
						}
						else if(result == 3){
							f2.field.remove(card1-1);
							f1.field.remove(card2-1);
							
						}else
							continue;
						
					case 3: // 하수인으로 상대방 공격
						if(rule.check_prvk(f1.field) == 1){ // 필드에 도발 카드가 있으면 == 1, 상대방을 공격하지 못함, 도발카드 우선
							System.out.println("상대 필드에 도발 카드가 있습니다. 도발카드 우선 공격해야합니다");
							continue;
						}
						int card3;
						System.out.print("어떤 카드로 공격하시겠습니까? : ");
						card3 = Integer.parseInt(sc.nextLine()); // 내가 공격할 카드 결정
						if ( f2.field.get(card3-1).offen != 1 ){
							System.out.println("이번 턴에 낸 카드는 공격할 수 없습니다.");
							continue;
						}
						p2.attack_hero(f2.field.get(card3-1), p1);
						System.out.println("player 1의 hp가 " + p2.hp + "남았습니다.");
						continue;
						
					case 4: // 영웅능력 사용
						if(use_hero_power_cnt > 0){
							System.out.println("이미 영웅능력을 사용 했습니다.");
							continue;
						}
						cp_p2_mana = p2.use_hero_power(p1, cp_p2_mana);  // 현재 남아있는 마나 cp_p2_mana에서 2만큼사용하고 남은 마나 리턴
						System.out.println("영웅능력으로 2의 데미지를 주었습니다. player 1의 hp가 " + p1.hp + "남았습니다.");
						use_hero_power_cnt++;
						continue;
					case 5: // 턴종료
						System.out.println();
						System.out.println("====================player 2 턴 종료====================");
						System.out.println();
						break player2; // 턴종료를 골랐을 경우 턴을종료 player2: while문을 빠져나감
					}
				}
			}
			rule.offen_permis(f2.field);
			
			p1.plus_mana(); // 턴종료시 p1 마나 ++
			p2.plus_mana(); // 턴종료시 p2 마나 ++
			
			if( rule.check_hp(p1, p2) == 0 ){
				break game_loop;
			}
			else {
				continue;
			}
		}

	}
}
