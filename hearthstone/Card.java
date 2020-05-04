package hearthstone;

public class Card {

	// 이름, 마나, 공격, 체력 변수, prvk == 1이면 도발카드
	String card_name;
	int mana;
	int attack;
	int hp;
	int prvk;
	
	Card(String card_name, int mana, int attack, int hp, int prvk){
		
		this.card_name = card_name;
		this.mana = mana;
		this.attack = attack;
		this.hp = hp;
		this.prvk = prvk;
	}
}
