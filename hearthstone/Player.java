package hearthstone;

import java.util.ArrayList;

public class Player extends Rule{
	
	int hp;
	int init_card;
	int mana;
	ArrayList<Card> hand = new ArrayList<>();
	
	Player(){
		super();
		this.hp = MAX_HP;
		this.init_card = INIT_CARDS;
		this.mana = INIT_MANA;
	}
	
	int attack_minion(Card mine, Card enemy){
		
		mine.hp = mine.hp - enemy.attack;
		enemy.hp = enemy.hp - mine.attack;
		if( mine.hp <= 0 && enemy.hp <= 0) // 둘다 죽었으면 3 반환
			return 3;
		if( mine.hp <= 0 ) // 내 카드가 죽었으면 1 반환
			return 1;
		if( enemy.hp <= 0) // 적 카드가 죽었으면 2 반환
			return 2;
		
		return 0; // 아무도 안죽었으면 0 반환
	}
	
	void attack_hero(Card mine, Player enemy){
		enemy.hp = enemy.hp - mine.attack;
	}
	
	int use_hero_power(Player enemy, int player_mana){
		if(player_mana < 2){ // 남은 마나가 2보다 작다면 마나를 그대로 리턴
			System.out.println("마나가 부족합니다. 영웅능력을 사용하지 못합니다.");
			return player_mana;
		}
		enemy.hp = enemy.hp - 2; // 영웅능력은 마나2를 소비해 상대에게 피해 2를줌
		return player_mana - 2;
	}
	
	void plus_mana(){
		if(mana >= 10)
			return;
		mana++; // 턴이 종료될때 마다 plus_mana 메서드를 호출해서 마나를 1씩 증가함 최대 10까지
		
	}
}
