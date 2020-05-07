package hearthstone;

import java.util.ArrayList;

public class Field extends Rule {

	int max_field = MAX_FIELD;
	ArrayList<Card> field = new ArrayList<>();

	Field() {
		super();
	}

	int check_field() {
		if (field.size() > 7) {
			System.out.println("필드에 더 이상 하수인을 놓을 수 없습니다.");
			return 0;
		}
		return 1; // 0일때 필드가 꽉참, 1일때 꽉차지 않음
	}

	void put_field(Card mine, int player_mana) {
		if (player_mana >= mine.mana) {
			field.add(mine);
			player_mana -= mine.mana;
		} else
			System.out.println("마나가 모자랍니다.");
	}

	void field_info(Field f1, Field f2) {
		System.out.println("----------player1 필드----------");
		for (int i = 0; i < f1.field.size(); i++) {
			if (f1.field == null){
				System.out.println("현재 필드가 비어있습니다.");
				break;}
			else {
				System.out.print(f1.field.get(i).card_name + "("
						+ f1.field.get(i).hp + "/" + f1.field.get(i).attack
						+ " 마나 : " + f1.field.get(i).mana + ") / ");
			}
		}
		System.out.println();
		System.out.println("----------player2 필드----------");
		for (int i = 0; i < f2.field.size(); i++) {
			if (f2.field == null){
				System.out.println("현재 필드가 비어있습니다.");
				break;}
			else {
				System.out.print(f2.field.get(i).card_name + "("
						+ f2.field.get(i).hp + "/" + f2.field.get(i).attack
						+ " 마나 : " + f2.field.get(i).mana + ") / ");
			}
		}
	}
}
