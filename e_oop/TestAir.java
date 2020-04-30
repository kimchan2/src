package e_oop;

public class TestAir {

	public static void main(String[] args) {
		
		AirConditioner aircon = new AirConditioner(); // 매개변수 없음
		
		aircon.powerOnOff(); // 전원 켜기
		aircon.setPower(); // 초기값은 약풍, 중간으로 설정
		aircon.upTemp(); // 초기온도 18도 1도 올려서 19도
		aircon.downTemp(); // 1도 내려서 18도

		aircon.setPower(); // 강풍
		aircon.setPower(); // 약풍
		aircon.setPower(); // 중간
		aircon.setPower(); // 강풍
		
		aircon.powerOnOff(); // 전원 끄기
		aircon.powerOnOff(); // 전원 켜기
		aircon.upTemp(100); // 온도를 100도 올리고 싶지만 30도 제한
		aircon.downTemp(100); // 온도를 100도 내리고 싶지만 18도 제한 
		
		System.out.println();
		System.out.println();
		
		AirConditioner aircon2 = new AirConditioner(31, 1); // 31도, 중간으로 켰지만 온도가 31도를 넘을 수 없으므로 30도로 설정됨, 전원도 같이 켜짐
		System.out.println();
		
		aircon2.setPower(); // 강풍
		aircon2.upTemp(); // 1도 올리고 싶지만 30도보다 높을 수 없으므로 30도 그대로
		aircon2.downTemp(); // 1도 내려서 29도

		aircon2.setPower(); // 약풍
		aircon2.setPower(); // 중간
		aircon2.setPower(); // 강풍
		aircon2.setPower(); // 약풍
		
	}

}
