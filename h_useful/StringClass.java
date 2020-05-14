package h_useful;

public class StringClass {

	public static void main(String[] args) {
		String s = new String("ABCD"); // 참조형 타입을 초기화 하는 방법
		String str = "ABCD";
		
		/*
		 * - equals()	 : 문자열의 내용이 같은지 확인한다
		 * - length()	 : 문자열의 길이를 반환한다.
		 * - charAt()	 : 문자열에서 해당 위치에 있는 문자를 반환한다.
		 * - substring() : 문자열에서 해당 범위에 있는 문자열을 반환한다.
		 * - indexOf()	 : 문자열 내의 특정 문자열의 인덱스를 반환한다.
		 * - replace()	 : 문자열 내의 특정 문자열을 원하는 문자열로 변경해 반환한다.
		 */
		
		for(int i = 0; i < str.length(); i++){
			System.out.println(str.charAt(i));
		}
		
		String revStr = ""; // str을 거꾸로 담을 변수
		for(int i = str.length() - 1; i >= 0; i--){
			revStr += str.charAt(i);
		}
		System.out.println(revStr);
		
		str = "0123456789";
		String sub1 = str.substring(3); // 3번 인덱스부터 끝까지 잘라서 반환한다.
		System.out.println(sub1);
		String sub2 = str.substring(5, 8);
		System.out.println(sub2);
		
		str = "치킨 피자 돈까스 떡볶이";
		int idx = str.indexOf("피자"); // 피자의 시작 인덱스를 반환한다.
		System.out.println(idx);
		
		String[] menus = {
				"치킨 18000원",
				"피자 9900원",
				"돈까스 8000원",
				"떡볶이 500원"
		};
		
		for(String menu : menus){
			
			String name = menu.substring(0, menu.indexOf(" "));
			System.out.println(name);
			
			// 가격만 분리시켜 int형 변수에 담아주세요.
			int price = Integer.parseInt( menu.substring( menu.indexOf(" ") + 1, menu.length() - 1 ) );
			System.out.println(price);
			
		}
		
		str = "123456789";
		str = str.replace("3", "짝");
		System.out.println(str);
		str = str.replace("6", "짝");
		str = str.replace("9", "짝");
		System.out.println(str);
		
		String pn = "010-2363-3647";
		pn = pn.replace("-", "");
		System.out.println(pn);
		
		// String은 문자열에 변경이 가해졌을 때
		// 새로운 객체를 생성해서 대체하는 특징이 있어
		// 많이 반복하다보면 속도가 느려지는 단점이 있음 ==> StringBuffer 이용
		
	}
}





















