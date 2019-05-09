package com.acme.testing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeExamples {
	
	public static void p(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		LocalDate now = LocalDate.now(); p(now);
		LocalDate hireDate = LocalDate.of(2008, Month.APRIL, 21); p(hireDate);
		LocalDate aWeekFromNow = now.plusWeeks(1); p(aWeekFromNow);
		LocalDate aWeekAgo = now.minusWeeks(1); p(aWeekAgo);
		System.out.println(hireDate.isBefore(now));
		
		LocalTime timeNow = LocalTime.now(); p(timeNow);
		LocalTime timeHired = LocalTime.of(13, 0, 0); p(timeHired);
		LocalTime anHourFromNow = timeNow.plusHours(1); p(anHourFromNow);
		LocalTime anHourEarlier = timeNow.minusHours(1); p(anHourEarlier);
		System.out.println(timeHired.isAfter(timeNow));
		
		LocalDateTime ldNow = LocalDateTime.now(); p(ldNow);
		
		
	}

}
 