package h_useful;

public class StringSpeedTest {

	public static void main(String[] args) {
//		String str = "a";
//		
//		long start = System.currentTimeMillis(); // 현재 시간을 ms 단위로 알려줌
//		for ( int i = 0; i < 200000; i++){
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end - start + "ms");
	
		
		StringBuffer sb = new StringBuffer("a"); 
		long start = System.currentTimeMillis(); // 현재 시간을 ms 단위로 알려줌
		for ( int i = 0; i < 200000; i++){
			sb.append("a"); // 객체를 새로 생성하는 것이아니라 배열의 길이를 늘려서 문자를 추가함 ==> 배열을 새로 생성하지만 String 객체를
							// 생성하는 것보다 적게 생성함 ==> 속도가 빠름
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
	
	
	
	
	
	}
}
