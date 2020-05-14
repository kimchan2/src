package h_useful;

public class ObjectClass {  //모든클래스에서 사용가능한 메서드를 포함
	public static void main(String[] args) {
		//toString() : 객체에 대한 정보를 문자열로 제공한다.
		ObjectClass oc = new ObjectClass();
		System.out.println(oc);
	}

	@Override
	public String toString() {
		return "toString() 호출";
	}
}
