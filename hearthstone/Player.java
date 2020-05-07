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
		enemy.hp = enemy.hp - mine.hp;
		
		if( mine.hp <= 0 ) // 내 카드가 죽었으면 1 반환
			return 1;
		if( enemy.hp <= 0) // 적 카드가 죽었으면 2 반환
			return 2;
		
		return 0; // 아무도 안죽었으면 0 반환
	}
	
	void attack_hero(Card mine, Player enemy){
		enemy.hp = enemy.hp - mine.attack;
	}
	
	void use_hero_power(Card enemy){
		mana = mana - 2;
		enemy.hp = enemy.hp - 2; // 영웅능력은 마나2를 소비해 하수인에게 피해 2를줌
	}
	
	void use_hero_power(Player enemy){
		mana = mana - 2;
		enemy.hp = enemy.hp - 2; // 영웅능력은 마나2를 소비해 상대에게 피해 2를줌
	}
	
	void plus_mana(){
		if(mana >= 10)
			return;
		mana++; // 턴이 종료될때 마다 plus_mana 메서드를 호출해서 마나를 1씩 증가함 최대 10까지
		
	}
}
