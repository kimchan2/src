package hearthstone;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
	// 이름, 마나, 공격, 체력 변수, prvk == 1이면 도발카드
	ArrayList<Card> list = new ArrayList<>();

	void deck_init() {
		list.add(new Card("돌주먹 오우거", 6, 6, 7, 0));
		list.add(new Card("멀록 약탈꾼", 1, 2, 1, 0));
		list.add(new Card("무법항 경호원", 5, 5, 4, 1));
		list.add(new Card("무쇠가죽 불곰", 3, 3, 3, 1));
		list.add(new Card("무쇠껍질 수호정령", 8, 8, 8, 1));
		list.add(new Card("민물악어", 2, 2, 3, 0));
		list.add(new Card("붉은늪지랩터", 2, 3, 2, 0));
		list.add(new Card("서리늑대 그런트", 2, 2, 2, 1));
		list.add(new Card("서리바람 설인", 4, 4, 5, 0));
		list.add(new Card("센진 방패대가", 4, 3, 5, 1));
		list.add(new Card("심장부 사냥개", 7, 9, 5, 0));
		list.add(new Card("오아시스 무쇠턱거북", 4, 2, 7, 0));
		list.add(new Card("용암 광전사", 3, 5, 1, 0));
		list.add(new Card("위습", 0, 1, 1, 0));
		list.add(new Card("은빛털고릴라 우두머리", 3, 1, 4, 1));
		list.add(new Card("전쟁 골렘", 7, 7, 7, 0));
		list.add(new Card("투기장의 제왕", 6, 6, 5, 1));
		list.add(new Card("황금골 보병", 1, 1, 2, 1));
		list.add(new Card("거대한 마스토돈", 9, 6, 10, 1));
		list.add(new Card("거만한 연기자", 2, 3, 2, 1));
		list.add(new Card("거미 전차", 3, 3, 4, 0));
		list.add(new Card("고약한 야유꾼", 4, 5, 4, 1));
		list.add(new Card("고용된 싸움꾼", 3, 4, 3, 1));
		list.add(new Card("공포의 해적", 4, 3, 3, 1));
		list.add(new Card("관선 변호인", 2, 0, 7, 1));
		list.add(new Card("구덩이 투사", 5, 5, 6, 0));
		list.add(new Card("기괴한 공포", 8, 6, 10, 0));
		list.add(new Card("길 잃은 타조", 4, 5, 4, 0));
		list.add(new Card("꽃의 고대정령", 6, 3, 8, 1));
		list.add(new Card("노련한 뱃사람", 5, 7, 4, 0));
		
	}
	ArrayList<Card> hand_init(){
		ArrayList<Card> hand = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			int random_index = (int)(Math.random() * list.size());
			hand.add(list.get(random_index));
			list.remove(list.get(random_index));
			System.out.println("핸드에 주어진 초기 카드는 : " + hand.get(i).card_name);
		}
		
		return hand; // 처음 덱초기화를 하고 핸드초기화를 해줌, 랜덤으로 카드를 3장뽑아 핸드로 가져옴, 뽑은 카드는 리스트에서 삭제
	}
	
	void hand_info(ArrayList<Card> hand){
		for (int i = 0; i < hand.size(); i++) {
			if(hand.get(i).prvk == 1){
				System.out.print(" *도발* " + hand.get(i).card_name + "(" + hand.get(i).hp + "/" + hand.get(i).attack + " 마나 : " + hand.get(i).mana+ ") / " );
			}
			else
				System.out.print(hand.get(i).card_name + "(" + hand.get(i).hp + "/" + hand.get(i).attack + " 마나 : " + hand.get(i).mana+ ") / " );
		}
		System.out.println();
	}
	
	Card pop_card(){ // 카드를 뽑고 뽑은 카드는 덱에서 삭제
		int random_index = (int)(Math.random() * list.size());
		Card origin = list.get(random_index);
		list.remove(random_index);
		
		return origin;
	}

	void deck_info(){
		
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i).card_name + " / ");
			if(i != 0 && (i+1) % 5 == 0)
				System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		d.deck_init();
		d.deck_info();
		d.hand_init();
	}
	
}
