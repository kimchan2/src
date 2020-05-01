package e_oop;

public class AirConditioner {

	boolean power;
	int temp = 18;
	String[] windPower = {"약풍", "중간", "강풍"};
	int index;
	
	AirConditioner(){
		
	}
	
	AirConditioner(int temp, int index){
		System.out.println("매개변수 있음");
		
		this.power = !power;
		System.out.println("전원이 켜졌습니다.");
		
		this.temp = temp;
		if(this.temp < 18) {
			this.temp = 18;
			System.out.println("온도는 18도보다 낮을 수 없습니다, 최저온도로 설정합니다. 현재온도 : " + this.temp + "도");
		} else if(this.temp > 30) {
			this.temp = 30;
			System.out.println("온도는 30도보다 높을 수 없습니다, 최고온도로 설정합니다. 현재온도 : " + this.temp + "도");
		}
		
		this.index = index;
		if(this.index > 2) {
			this.index = 2;
			System.out.println("강풍이 최대입니다, 강풍으로 설정합니다. ( 0~2 )");
		}
		System.out.println("바람의 세기를 " + windPower[index]+ "로 설정합니다.");
	}
	
	void powerOnOff() {
		
		power = !power;
		if(power == true) {
			System.out.println("전원이 켜졌습니다.");
		} else if(power == false){
			System.out.println("전원이 꺼졌습니다.");
		}
	}
	
	void upTemp() {
		temp++;
		if (temp > 30) {
			temp = 30;
			System.out.println("온도는 30도보다 높을 수 없습니다, 최고온도로 설정합니다. 현재온도 : " + temp + "도");
		}else 
			System.out.println("온도를 1도 올렸습니다. 현재 온도는 : " + temp + "도 입니다.");
	}
	
	void upTemp(int temp) {
		temp += temp;
		if(temp > 30) {
			temp = 30;
			System.out.println("온도는 30도보다 높을 수 없습니다, 최고온도로 설정합니다. 현재온도 : " + temp + "도");
		}else
			System.out.println("온도를 " + temp + "도 올렸습니다. 현재 온도는 : " + temp + "도 입니다.");
	}
	
	void downTemp() {
		temp--;
		if (temp < 18) {
			temp = 18;
			System.out.println("온도는 18도보다 낮을 수 없습니다, 최저온도로 설정합니다. 현재온도 : " + temp + "도");
		}else
			System.out.println("온도를 1도 내렸습니다. 현재 온도는 : " + temp + "도 입니다.");
	}
	
	void downTemp(int temp) {
		temp -= temp;
		if (temp < 18) {
			temp = 18;
			System.out.println("온도는 18도보다 낮을 수 없습니다, 최저온도로 설정합니다. 현재온도 : " + temp + "도");
		}else
			System.out.println("온도를 " + temp + "도 내렸습니다. 현재 온도는 : " + temp + "도 입니다.");
	}
	
	void setPower() {
		index++;
		if(index == 3) {
			index = 0;
		}
		System.out.println("현재 바람의 세기는 " + windPower[index] + "입니다.");
		
	}
	
}
