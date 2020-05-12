package z_exam.ch7;

public class Exam07 {

	
	
}
	/*
	 * [7-1] 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다. 섯 다카드 20장을 담는
	 * SutdaCard배열을 초기화하시오. 단, 섯다카드는 1부터 10까지의 숫자 가 적힌 카드가 한 쌍씩 있고, 숫자가 1, 3, 8인
	 * 경우에는 둘 중의 한 장은 광(Kwang)이 어야 한다. 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야
	 * 한다. class SutdaDeck { final int CARD_NUM = 20; SutdaCard[] cards = new
	 * SutdaCard[CARD_NUM];
	 * 
	 * SutdaDeck() {
	 * 
	 * for(int i = 0; i < cards.length; i++){ if( i > 9 ){ cards[i] = new
	 * SutdaCard(i-9, false); } else cards[i] = new SutdaCard(i+1, (i==0 || i==2
	 * || i==7 ? true : false)); // cards[i] = new SutdaCard(i+1, false); }
	 * 
	 * // (1) 배열 SutdaCard를 적절히 초기화 하시오.
	 * 
	 * } }
	 * 
	 * class SutdaCard { int num; boolean isKwang;
	 * 
	 * SutdaCard() { this(1, true); }
	 * 
	 * SutdaCard(int num, boolean isKwang) { this.num = num; this.isKwang =
	 * isKwang; }
	 * 
	 * // info()대신 Object클래스의 toString()을 오버라이딩했다. public String toString() {
	 * return num + (isKwang ? "K" : ""); } }
	 * 
	 * class Exercise7_1 { public static void main(String args[]) { SutdaDeck
	 * deck = new SutdaDeck(); for (int i = 0; i < deck.cards.length; i++)
	 * System.out.print(deck.cards[i] + ","); } }
	 */

	/*
	 * [7-2] 문제7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하 시오. [주의]
	 * Math.random()을 사용하는 경우 실행결과와 다를 수 있음. 1. 메서드명 : shuffle 기 능 : 배열 cards에
	 * 담긴 카드의 위치를 뒤섞는다.(Math.random()사용) 반환타입 : 없음 매개변수 : 없음 2. 메서드명 : pick 기 능
	 * : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다. 반환타입 : SutdaCard 매개변수 : int index -
	 * 위치 3. 메서드명 : pick 기 능 : 배열 cards에서 임의의 위치의 SutdaCard를
	 * 반환한다.(Math.random()사용) 반환타입 : SutdaCard 매개변수 : 없음
	 * [연습문제]/ch7/Exercise7_2.java class SutdaDeck { final int CARD_NUM = 20;
	 * SutdaCard[] cards = new SutdaCard[CARD_NUM];
	 * 
	 * SutdaDeck() { for (int i = 0; i < cards.length; i++) { if (i > 9) {
	 * cards[i] = new SutdaCard(i - 9, false); } else cards[i] = new SutdaCard(i
	 * + 1, (i == 0 || i == 2 || i == 7 ? true : false)); } }
	 * 
	 * void shuffle() {
	 * 
	 * SutdaCard temp; for (int i = 0; i < cards.length; i++) { int randomIndex
	 * = (int) (Math.random() * cards.length); temp = cards[i]; cards[i] =
	 * cards[randomIndex]; cards[randomIndex] = temp; } }
	 * 
	 * SutdaCard pick(int index){ return cards[index]; }
	 * 
	 * SutdaCard pick(){ return cards[(int) (Math.random() * cards.length)]; } }
	 * // SutdaDeck
	 * 
	 * class SutdaCard { int num; boolean isKwang;
	 * 
	 * SutdaCard() { this(1, true); }
	 * 
	 * SutdaCard(int num, boolean isKwang) { this.num = num; this.isKwang =
	 * isKwang; }
	 * 
	 * public String toString() { return num + (isKwang ? "K" : ""); } }
	 * 
	 * class Exercise7_2 { public static void main(String args[]) { SutdaDeck
	 * deck = new SutdaDeck(); System.out.println(deck.pick(0));
	 * System.out.println(deck.pick()); deck.shuffle(); for (int i = 0; i <
	 * deck.cards.length; i++) System.out.print(deck.cards[i] + ",");
	 * System.out.println(); System.out.println(deck.pick(0)); } }
	 */
	/*
	 * [7-3] 오버라이딩의 정의와 필요성에 대해서 설명하시오.
	 * 
	 * 오버라이딩이란 부모클래스에서 정의된 메서드를 자식클래스에서 재정의 하는 것으로, 자식 클래스에서 상황에 맞게 변경해야하는 경우
	 * 오버라이딩이 필요하다
	 */

	/*
	 * [7-4] 다음 중 오버라이딩의 조건으로 옳지 않은 것은? (모두 고르시오) a. 조상의 메서드와 이름이 같아야 한다. b.
	 * 매개변수의 수와 타입이 모두 같아야 한다. c. 접근 제어자는 조상의 메서드보다 좁은 범위로만 변경할 수 있다. d. 조상의
	 * 메서드보다 더 많은 수의 예외를 선언할 수 있다. c, d
	 */

	/*
	 * //[7-5] 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 //위해서는 코드를 어떻게 바꾸어야
	 * 하는가? //[연습문제]/ch7/Exercise7_5.java class Product { int price; // 제품의 가격
	 * int bonusPoint; // 제품구매 시 제공하는 보너스점수
	 * 
	 * Product(int price) { this.price = price; bonusPoint = (int) (price /
	 * 10.0); } }
	 * 
	 * class Tv extends Product { Tv() { super(1000); }
	 * 
	 * public String toString() { return "Tv"; } }
	 * 
	 * class Exercise7_5 { public static void main(String[] args) { Tv t = new
	 * Tv(); } } // 프로덕트라는 클래스는 매개변수가 필요한 생성자를 사용하기 때문에 이를 상속받은 자식클래스에서 //
	 * 매개변수까지 포함한 생성자는 자동생성할 수 없기 때문에 매개변수를 따로 넣어줘야함
	 */

	/*
	 * [7-6] 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유는 무엇인 가? 상속받은 조상의 인스턴스 변수들을 자손의
	 * 생성자에서 직접 초기화 하기보다는 조상의 생성자를 호출함으로써 초기화 되도록 하는 것이 바람직하다 각 클래스의 생성자는 해당
	 * 클래스에 선언된 인스턴스 변수의 초기화만을 담당하고, 조상 클래스로부터 상속받은 인스턴스 변수의 초기화는 조상 클래스의 생성자가
	 * 처리하도록 해야하는 것이다
	 */

	/*
	 * [7-7] 다음 코드의 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오. [연습문제]/ch7/Exercise7_7.java
	 * class Parent { int x = 100;
	 * 
	 * Parent() { this(200); }
	 * 
	 * Parent(int x) { this.x = x; }
	 * 
	 * int getX() { return x; } }
	 * 
	 * class Child extends Parent { int x = 3000;
	 * 
	 * Child() { this(1000); }
	 * 
	 * Child(int x) { this.x = x; } }
	 * 
	 * class Exercise7_7 { public static void main(String[] args) { Child c =
	 * new Child(); System.out.println("x=" + c.getX()); } } Child() ->
	 * Child(int x) -> Parent() -> Parent(int x) -> Object() 실행결과 x = 200
	 */

	/*
	 * [7-8] 다음 중 접근제어자를 접근범위가 넓은 것에서 좁은 것의 순으로 바르게 나열한 것은? a.
	 * public-protected-(default)-private b. public-(default)-protected-private
	 * c. (default)-public-protected-private d.
	 * private-protected-(default)-public 정답 : a
	 */

	/*
	 * [7-9] 다음 중 제어자 final을 붙일 수 있는 대상과 붙였을 때 그 의미를 적은 것이다. 옳지 않은 것은? (모두 고르시오)
	 * a. 지역변수 - 값을 변경할 수 없다. b. 클래스 - 상속을 통해 클래스에 새로운 멤버를 추가할 수 없다. c. 메서드 -
	 * 오버로딩을 할 수 없다. d. 멤버변수 - 값을 변경할 수 없다. 정답 : c, 오버라이딩을 할 수 없다
	 */

	/*
	 * //[7-10] MyTv2클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할 //수 없도록
	 * 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 //getter와 setter메서드를 추가하라.
	 * //[연습문제]/ch7/Exercise7_10.java class MyTv2 { private boolean isPowerOn;
	 * private int channel; private int volume; final int MAX_VOLUME = 100;
	 * final int MIN_VOLUME = 0; final int MAX_CHANNEL = 100; final int
	 * MIN_CHANNEL = 1;
	 * 
	 * public boolean isPowerOn() { return isPowerOn; }
	 * 
	 * public void setPowerOn(boolean isPowerOn) { this.isPowerOn = isPowerOn; }
	 * 
	 * public int getChannel() { return channel; }
	 * 
	 * public void setChannel(int channel) { this.channel = channel; }
	 * 
	 * public int getVolume() { return volume; }
	 * 
	 * public void setVolume(int volume) { this.volume = volume; } }
	 * 
	 * public static void main(String args[]) { MyTv2 t = new MyTv2();
	 * t.setChannel(10); System.out.println("CH:"+t.getChannel());
	 * t.setVolume(20); System.out.println("VOL:"+t.getVolume()); } }
	 */

	// [7-11] 문제7-10에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는
	// 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.
	// [Hint] 이전 채널의 값을 저장할 멤버변수를 정의하라.
	// 메서드명 : gotoPrevChannel
	// 기 능 : 현재 채널을 이전 채널로 변경한다.
	// 반환타입 : 없음
	// 매개변수 : 없음
	// [연습문제]/ch7/Exercise7_11.java
	// class MyTv2 {
	//
	// private int prevChannel;
	// private boolean isPowerOn;
	// private int channel;
	// private int volume;
	// final int MAX_VOLUME = 100;
	// final int MIN_VOLUME = 0;
	// final int MAX_CHANNEL = 100;
	// final int MIN_CHANNEL = 1;
	//
	// public boolean isPowerOn() {
	// return isPowerOn;
	// }
	//
	// public void setPowerOn(boolean isPowerOn) {
	// this.isPowerOn = isPowerOn;
	// }
	//
	// public int getChannel() {
	// return channel;
	// }
	//
	// public void setChannel(int channel) {
	// prevChannel = this.channel;
	// this.channel = channel;
	// }
	//
	// public int getVolume() {
	// return volume;
	// }
	//
	// public void setVolume(int volume) {
	// this.volume = volume;
	// }
	//
	// void gotoPrevChannel(){
	// setChannel(prevChannel);
	// }
	// }
	// class Exercise7_11 {
	// public static void main(String args[]) {
	// MyTv2 t = new MyTv2();
	// t.setChannel(10);
	// System.out.println("CH:"+t.getChannel());
	// t.setChannel(20);
	// System.out.println("CH:"+t.getChannel());
	// t.gotoPrevChannel();
	// System.out.println("CH:"+t.getChannel());
	// t.gotoPrevChannel();
	// System.out.println("CH:"+t.getChannel());
	// }
	// }

	/*
	 * [7-12] 다음 중 접근 제어자에 대한 설명으로 옳지 않은 것은? (모두 고르시오) a. public은 접근제한이 전혀 없는 접근
	 * 제어자이다. b. (default)가 붙으면, 같은 패키지 내에서만 접근이 가능하다. c. 지역변수에도 접근 제어자를 사용할 수
	 * 있다. d. protected가 붙으면, 같은 패키지 내에서도 접근이 가능하다. e. protected가 붙으면, 다른 패키지의
	 * 자손 클래스에서 접근이 가능하다. 정답 : c
	 */

	/*
	 * [7-13] Math클래스의 생성자는 접근 제어자가 private이다. 그 이유는 무엇인가? Math 클래스는 몇개의 상수와
	 * static 메서드만으로 구성돼 있기 때문에 객체를 생성할 필요가 없다 그렇기 때문에 외부로부터의 불필요한 접근을 막기 위해
	 * 생성자의 접근제어자를 private로 지정하였다. 객체 생성을 못하게 하기 위해
	 */

	// [7-14] 문제7-1에 나오는 섯다카드의 숫자와 종류(isKwang)는 사실 한번 값이 지정되면
	// 변경되어서는 안 되는 값이다. 카드의 숫자가 한번 잘못 바뀌면 똑같은 카드가 두 장이
	// 될 수 도 있기 때문이다. 이러한 문제점이 발생하지 않도록 아래의 SutdaCard를 수정하시
	// 오.
	// [연습문제]/ch7/Exercise7_14.java
	// class SutdaCard {
	// final int num;
	// final boolean isKwang;
	//
	// SutdaCard() {
	// this(1, true);
	// }
	//
	// SutdaCard(int num, boolean isKwang) {
	// this.num = num;
	// this.isKwang = isKwang;
	// }
	//
	// public String toString() {
	// return num + (isKwang ? "K" : "");
	// }
	// }

	/*
	 * [7-15] 클래스가 다음과 같이 정의되어 있을 때, 형변환을 올바르게 하지 않은 것은? (모두 고르시오.) class Unit
	 * {} class AirUnit extends Unit {} class GroundUnit extends Unit {} class
	 * Tank extends GroundUnit {} class AirCraft extends AirUnit {}
	 * 
	 * Unit u = new GroundUnit(); Tank t = new Tank(); AirCraft ac = new
	 * AirCraft();
	 * 
	 * a. u = (Unit)ac; b. u = ac; c. GroundUnit gu = (GroundUnit)u; d. AirUnit
	 * au = ac; e. t = (Tank)u; f. GroundUnit gu = t;
	 * 
	 * 정답 : e
	 */

	/*
	 * [7-16] 다음 중 연산결과가 true가 아닌 것은? (모두 고르시오) class Car {} class FireEngine
	 * extends Car implements Movable {} class Ambulance extends Car {}
	 * FireEngine fe = new FireEngine();
	 * 
	 * a. fe instanceof FireEngine b. fe instanceof Movable c. fe instanceof
	 * Object d. fe instanceof Car e. fe instanceof Ambulance
	 * 
	 * 정답 : e
	 */

	// [7-17] 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만들고, 이
	// 클래스를 상속받도록 코드를 변경하시오.
	// class Unit{
	// int x, y;
	//
	// void move(int x, int y){
	//
	// }
	//
	// void stop(){
	//
	// }
	// }
	//
	// class Marine extends Unit{ // 보병
	//
	// void stimPack() { /* 스팀팩을 사용한다. */
	// }
	// }
	//
	// class Tank extends Unit{ // 탱크
	//
	// void changeMode() { /* 공격모드를 변환한다. */
	// }
	// }
	//
	// class Dropship extends Unit{ // 수송선
	//
	// void load() { /* 선택된 대상을 태운다. */
	// }
	//
	// void unload() { /* 선택된 대상을 내린다. */
	// }
	// }

	// [7-18] 다음과 같은 실행결과를 얻도록 코드를 완성하시오.
	// [Hint] instanceof연산자를 사용해서 형변환한다.
	// 메서드명 : action
	// 기 능 : 주어진 객체의 메서드를 호출한다.
	// DanceRobot인 경우, dance()를 호출하고,
	// SingRobot인 경우, sing()을 호출하고,
	// DrawRobot인 경우, draw()를 호출한다.
	// 반환타입 : 없음
	// 매개변수 : Robot r - Robot인스턴스 또는 Robot의 자손 인스턴스
	// [연습문제]/ch7/Exercise7_18.java
	// class Exercise7_18 {
	//
	// void action(Robot r){
	//
	// if( r instanceof DanceRobot ){
	// ((DanceRobot) r).dance();
	// }
	//
	// if( r instanceof SingRobot ){
	// ((SingRobot) r).sing();
	// }
	//
	// if( r instanceof DrawRobot ){
	// ((DrawRobot) r).draw();
	// }
	// }

	// public static void main(String[] args) {
	// Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
	// for (int i = 0; i < arr.length; i++)
	// action(arr[i]);
	// } // main

//class Robot {
//}
//
//class DanceRobot extends Robot {
//	void dance() {
//		System.out.println("춤을 춥니다.");
//	}
//}
//
//class SingRobot extends Robot {
//	void sing() {
//		System.out.println("노래를 합니다.");
//	}
//}
//
//class DrawRobot extends Robot {
//	void draw() {
//		System.out.println("그림을 그립니다.");
//	}
//}

/*[7-24] 다음 중 인터페이스의 장점이 아닌 것은?
a. 표준화를 가능하게 해준다.
b. 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
c. 독립적인 프로그래밍이 가능하다.
d. 다중상속을 가능하게 해준다.
e. 패키지간의 연결을 도와준다.
정답 : e

개발시간 단축, 표준화가 가능, 서로 관계없는 클래스들에게 관계를 맺어줄 수 있음, 독립적인 프로그래밍이 가능
*/
