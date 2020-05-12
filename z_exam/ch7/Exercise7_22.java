package z_exam.ch7;

/*[7-22] 아래는 도형을 정의한 Shape클래스이다. 이 클래스를 조상으로 하는 Circle클래
 스와 Rectangle클래스를 작성하시오. 이 때, 생성자도 각 클래스에 맞게 적절히 추가해야
 한다.
 (1) 클래스명 : Circle
 조상클래스 : Shape
 멤버변수 : double r - 반지름
 (2) 클래스명 : Rectangle
 조상클래스 : Shape
 멤버변수 : double width - 폭
 double height - 높이
 메서드 :
 1. 메서드명 : isSquare
 기 능 : 정사각형인지 아닌지를 알려준다.
 반환타입 : boolean
 매개변수 : 없음*/

/*[7-23] 문제7-22에서 정의한 클래스들의 면적을 구하는 메서드를 작성하고 테스트 하시
오.
1. 메서드명 : sumArea
기 능 : 주어진 배열에 담긴 도형들의 넓이를 모두 더해서 반환한다.
반환타입 : double
매개변수 : Shape[] arr
*/

class Exercise7_22{

	static double sumArea(Shape[] arr){
		double sum = 0;
		
		for(int i = 0; i < arr.length; i++){
			sum += arr[i].calcArea();
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println("면적의 합:"+sumArea(arr));
	}
	
}

abstract class Shape {
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0, 0);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

class Circle extends Shape{
	double r; // 반지름
	
	Circle(double r){
		this(new Point(0, 0), r);
	}
	
	Circle(Point p, double r){
		super(p);
		this.r = r;
	}
	
	double calcArea(){
		return Math.PI * r * r;
	}
}

class Rectangle extends Shape{
	double width;
	double height;
	
	Rectangle(double width, double height){
		this(new Point(0, 0), width, height);
	}
	
	Rectangle(Point p, double width, double height){
		super(p);
		this.width = width;
		this.height = height;
	}
	
	boolean isSquare(){
		
		return width*height != 0 && width == height;
		
	}
	
	double calcArea(){
		return width * height;
	}
}