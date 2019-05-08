package com.acme.testing;

import com.acme.utils.MyDate;

public class TestMyDate {
	public static void main(String[] args) {
		MyDate date1 = new MyDate(11, 11, 1918);
		MyDate date2 = new MyDate();
		MyDate date4 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear(1918);
		MyDate date3 = new MyDate();
		date3.setDate(4, 21, 1968);
		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(date4.toString());
//	MyDate.leapYears();
		date3.setDate(13, 40, -1);

		MyDate newYear = new MyDate(1, 1, 2009);
		MyDate fiscalStart = new MyDate(1, 1, 2009);

		if (newYear.equals(fiscalStart))
			System.out.println("These two dates are equal");
		else
			System.out.println("These two dates are not equal");
		
		int a = 10;
		int z = 2;
		int answer = a / z;
		
		MyDate.listHolidays();

	}
}
