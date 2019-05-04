package com.acme.utils;

public class MyDate {
	
	public int day,year,month;
	
	{
		day = 1;
		year = 2000;
		month = 1;
	}
	
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
