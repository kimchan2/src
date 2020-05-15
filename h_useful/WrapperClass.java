package h_useful;

import java.util.Vector;

public class WrapperClass {

	public static void main(String[] args) {
		/*
		 * boolean	: Boolean
		 * char		: Character
		 * byte		: Byte
		 * short	: Short
		 * int		: Integer
		 * long		: Long
		 * float	: Float
		 * double	: Double
		 */
		
		int i = 10;
		Integer iw = new Integer(20);
		
		System.out.println(i + iw);
		
		System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		
		System.out.println(i + Integer.parseInt("20"));
		
		System.out.println(i + String.valueOf(20));
		
		System.out.println(i + Integer.valueOf("20"));
		
		Vector<Integer> v = new Vector<>();
		
		v.add(new Integer(10));
		v.add(10); // 오토박싱 : 기본형 타입이 wrapper 클래스로 자동 변환
		
		Integer integer = v.get(0);
		int i2 = v.get(0); // 언박싱 : wrapper 클래스가 기본형 타입으로 자동 변환
		
	}
	
}

















