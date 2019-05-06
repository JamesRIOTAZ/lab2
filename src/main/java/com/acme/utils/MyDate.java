package com.acme.utils;

public class MyDate {

	private int day;
	private int month;
	private int year;

	{
		day = 1;
		month = 1;
		year = 2000;
	}

	public MyDate() {
		this(1,1,1900);
	}

	public MyDate(int month, int day, int year) {
		setDate(month, day, year);
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}

	public void setDate(int month, int day, int year) {
		if (valid(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
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
			this.day = day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (valid(day, month, year)) {
			this.year = year;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (valid(day, month, year)) {
			this.month = month;
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

}
