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
	
	public static void leapYears() {
		for(int x=1752; x <= 2020; x++) {
			if(((x % 4)==0) && (((x % 100)!=0) || ((x % 400)==0))){
				System.out.println(x);
			}
		}
	}

}
