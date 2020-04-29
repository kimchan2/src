package e_oop;

public class TV {
	
	int sound = 10;
	int channel;
	String power;
	
	
	
	int sound(char push){
		if(push == '+'){
			sound += 1;
		}else if(push == '-'){
			sound -= 1;
		}
		return sound;
	}
	
	String power(int button){
		if(button == 1){
			power = "On";
		}else if(button == 0){
			power = "Off";
		}
		return power;
	}
	
//	int channel(int change, char push){
//		this.channel = change;
//		if(push == '+')
//		return channel;
//	}
}
