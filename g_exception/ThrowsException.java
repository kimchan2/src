package g_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {
		/*
		 * 메서드에 예외 선언하기
		 * - 메서드 호출시 발생할 수 있는 예외를 선언해줄 수 있다.
		 * - void method() throws IOException {}
		 * - 메서드의 구현부 끝에 throws 키워드와 예외 클래스명으로 예외를 선언할 수 있다.
		 * - 예외를 선언하면 예외처리를 하지 않고 자신을 호출한 메서드로 예외처리를 넘겨준다.
		 */

		try {
			method(null); // nullpoint 예외
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		int[] arr = new int[10];
		System.out.println(arr[10]); // IndexOutofBounds 예외
	}
	private static void method(String str) throws IOException {
		System.out.println(str.length()); //
//		throw new IOException();
	}

}
