package hearthstone;

import java.util.ArrayList;

public class Rule {

	// 덱에 카드는 30장
	// 턴시작 시마다 카드가 한장씩 랜덤으로 뽑힘
	// 선공, 후공 가리기
	// 턴마다 마나 수정이 하나씩 올라서 최대 10개까지
	// 처음 카드를 3장 들고 시작함, 후공은 동전한닢(사용턴만 마나+1)이 주어짐
	// 일반 카드와 도발 카드만 있음
	// 카드는 공격력과 체력이 있는데 체력 <= 0 이 되면 카드가 파괴됨
	
	public static final int MAX_HP = 30; // 유저 최대 HP
	public static final int CARD_DECK_LIMIT = 30; // 덱 최대 카드 수
	public static final int INIT_CARDS = 3; // 처음 가지고 시작하는 카드수
	public static final int INIT_MANA = 1; // 처음 가지고 시작하는 마나
	public static final int MAX_PLAYER = 2; // 플레이하는 유저
	public static final int MAX_FIELD = 7; // 필드에 놓을수 있는 최대 카드수
	
	int check_hp(Player p1, Player p2){
		if(p1.hp <= 0){
			System.out.println("플레이어 2의 승리입니다!!");
			return 0;
		}
		
		if(p2.hp <= 0){
			System.out.println("플레이어 1의 승리입니다!!");
			return 0;
		}
		
		return 1;
	}
	
	int check_prvk(ArrayList<Card> card){
		for(int i = 0; i < card.size(); i++){
			if(card.get(i).prvk == 1)
				return 1; // 카드중에 도발이 하나라도 있으면 1반환
		}
		return 0; // 없으면 0반환
	}
	
	void offen_permis(ArrayList<Card> card){ // 카드를 공격 가능하게 만듦
		for(int i = 0; i < card.size(); i++){
			card.get(i).offen = 1;
		}
	}
	
}
















