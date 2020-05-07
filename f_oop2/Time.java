package f_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;
	
	@Override
	public String toString(){
		return hour + ":" + minute + ":" + second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if(hour >= 0 && hour < 24)
			this.hour = hour;
		else
			System.out.println("시 입력 범위 초과");
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
		if(minute >= 0 && minute < 60)
			this.minute = minute;
		else
			System.out.println("분 입력 범위 초과");
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second >= 0 && second < 60)
			this.second = second;
		else
			System.out.println("초 입력 범위 초과");
	}
}
