package com.acme.utils;

public class MyDate {

	private byte day;
	private byte month;
	private short year;

	private static MyDate[] holidays;

	static {
		holidays = new MyDate[6];
		holidays[0] = new MyDate(1, 01, 2019);
		holidays[1] = new MyDate(9, 05, 2019);
		holidays[2] = new MyDate(5, 30, 2019);
		holidays[3] = new MyDate(11, 24, 2019);
		holidays[4] = new MyDate(7, 4, 2019);
		holidays[5] = new MyDate(12, 25, 2019);
	}

	{
		day = 1;
		month = 1;
		year = 2000;
	}

	public MyDate() {
		this(1, 1, 1900);
	}

	public MyDate(int month, int day, int year) {
		setDate(month, day, year);
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}

	public void setDate(int month, int day, int year) {
		if (valid(day, month, year)) {
			this.day = (byte) day;
			this.month = (byte) month;
			this.year = (short) year;
		}
	}

	public static void leapYears() {
		for (int x = 1752; x <= 2020; x++) {
			if (((x % 4) == 0) && (((x % 100) != 0) || ((x % 400) == 0))) {
				System.out.println(x);
			}
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (valid(day, month, year)) {
			this.day = (byte) day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (valid(day, month, year)) {
			this.year = (short) year;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (valid(day, month, year)) {
			this.month = (byte) month;
		}
	}

	private boolean valid(int day, int month, int year) {
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return (day <= 30);
		case 2:
			return day <= 28 || (day == 29 && year % 4 == 0);
		}
		return true;
	}

	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if ((d.day == day) && (d.month == month) && (d.year == year)) {
				return true;
			}
		}
		return false;
	}

	public static MyDate[] getHolidays() {
		return holidays;
	}

	public static void setHolidays(MyDate[] holidays) {
		MyDate.holidays = holidays;
	}

	public static void listHolidays() {
		 System.out.println("the holidays are:");

		 for(MyDate date : holidays) {
			 System.out.println(date);
		 }
	}


}
