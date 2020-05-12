package z_exam.ch7;

//[7-19] 다음은 물건을 구입하는 사람을 정의한 Buyer클래스이다. 이 클래스는 멤버변수
//로 돈(money)과 장바구니(cart)를 가지고 있다. 제품을 구입하는 기능의 buy메서드와 장
//바구니에 구입한 물건을 추가하는 add메서드, 구입한 물건의 목록과 사용금액, 그리고 남
//은 금액을 출력하는 summary메서드를 완성하시오.
//1. 메서드명 : buy
//기 능 : 지정된 물건을 구입한다. 가진 돈(money)에서 물건의 가격을 빼고,
//장바구니(cart)에 담는다.
//만일 가진 돈이 물건의 가격보다 적다면 바로 종료한다.
//반환타입 : 없음
//매개변수 : Product p - 구입할 물건
//2. 메서드명 : add
//기 능 : 지정된 물건을 장바구니에 담는다.
//만일 장바구니에 담을 공간이 없으면, 장바구니의 크기를 2배로 늘린 다음에 담는다.
//반환타입 : 없음
//매개변수 : Product p - 구입할 물건
//3. 메서드명 : summary
//기 능 : 구입한 물건의 목록과 사용금액, 남은 금액을 출력한다.
//반환타입 : 없음
//매개변수 : 없음
//[연습문제]/ch7/Exercise7_19.java
//class Exercise7_19 {
//	public static void main(String args[]) {
//		Buyer b = new Buyer();
//		b.buy(new Tv());
//		b.buy(new Computer());
//		b.buy(new Tv());
//		b.buy(new Audio());
//		b.buy(new Computer());
//		b.buy(new Computer());
//		b.buy(new Computer());
//		b.summary();
//	}
//}
//
//class Buyer {
//	int money = 1000;
//	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
//	int i = 0; // Product배열 cart에 사용될 index
//
//	void buy(Product p) {
//
//		if ( money < p.price ){
//			return;
//		}
//		else{
//			money -= p.price;
//			add(p);
//		}
//	}
//
//	void add(Product p) {
//		
//		if( i >= cart.length ){
//			Product[] newCart = new Product[cart.length*2];
//			for ( int j = 0; j < cart.length; j++){
//				newCart[j] = cart[j];
//			}
//			cart = newCart;
//		}
//		else{
//			cart[i] = p;
//			i++;
//		}
//		
//	} // add(Product p)
//
//	void summary() {
//	
//		int sum = 0;
//		System.out.print("구입한 물건:");
//		for(int i = 0; i < cart.length; i++){
//			System.out.print(cart[i].toString() + ",");
//			sum += cart[i].price;
//		}
//		System.out.println();
//		System.out.println("사용한 금액:" + sum);
//		System.out.println("남은 금액:" + money);
//	} // summary()
//}
//
//class Product {
//	int price; // 제품의 가격
//
//	Product(int price) {
//		this.price = price;
//	}
//}
//
//class Tv extends Product {
//	Tv() {
//		super(100);
//	}
//
//	public String toString() {
//		return "Tv";
//	}
//}
//
//class Computer extends Product {
//	Computer() {
//		super(200);
//	}
//
//	public String toString() {
//		return "Computer";
//	}
//}
//
//class Audio extends Product {
//	Audio() {
//		super(50);
//	}
//
//	public String toString() {
//		return "Audio";
//	}
//}