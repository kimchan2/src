package hearthstone;

import java.util.ArrayList;

public class Field extends Rule{

	int max_field = MAX_FIELD;
	ArrayList<Card> field = new ArrayList<>();
	
	Field(){
		super();
	}
	
	int check_field(){
		if(field.size() > 7){
			System.out.println("필드에 더 이상 하수인을 놓을 수 없습니다.");
			return 0;
		}
		return 1; // 0일때 필드가 꽉참, 1일때 꽉차지 않음
	}
	
	void put_field(Card mine, int mana){
		if(mana >= mine.mana)
			field.add(mine);
		else System.out.println("마나가 모자랍니다.");
	}
	
	void field_info(Field f){
		System.out.println("----------필드----------");
		for( int i = 0; i < field.size(); i++ ){
			System.out.print(f.field.get(i).card_name + "(" + f.field.get(i).hp + "/" + f.field.get(i).attack + " 마나 : " +f.field.get(i).mana + ") / " );
		}
		System.out.println();
	}
}
