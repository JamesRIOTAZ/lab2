package lab_2;

public class MyDate {
	
	int day,year,month;
	
	public MyDate() {
		
	}
	
	public MyDate(int month, int day, int year) {
		setDate(month, day, year);
	}
	
	public String toString(){
		return day+"/"+month+"/"+year;
	}
	
	public void setDate(int month, int day, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}

}
