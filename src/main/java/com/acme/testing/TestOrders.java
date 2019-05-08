package com.acme.testing;

import com.acme.domain.Service;

import java.time.LocalDate;

import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Order;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(1, 20, 2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);
		MyDate date2 = new MyDate(4, 10, 2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.taxRate);

		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		MyDate date3 = new MyDate(12, 25, 2019);
		Order anotherAnvil = new Order(date3, 200, "Road Runner");
		System.out.println(anotherAnvil);

		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

		balloons.setQuantity(-200);
		System.out.println("The volume of the anvil is: " + ((Solid)anvil.getProduct()).volume());
		System.out.println("The length of the anvil is: " + ((Solid) anvil.getProduct()).getLength());
		
		MyDate date4 = new MyDate(4,10,2008);
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date3, 20000, "Daffy Duck",s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is "+birdEradication.computeTotal());
		
		// Change this date to one that is within the last 15 days of today.
		LocalDate hammerDate2 = LocalDate.now().plusDays(5);
		MyDate hammerDate = new MyDate( hammerDate2.getMonthValue(), hammerDate2.getDayOfMonth(), hammerDate2.getYear() );
		Solid hammerType = new Solid( "Acme Hammer", 281, 0.3, UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3 );
		Order hammer = new Order( hammerDate, 10.00, "Wile E Coyote", hammerType, 10 );
		
	//	anvil.setRushable((date4, amount) -> {amount > 1500;});
		Order.setRushable((orderDate, amount) -> {
			 // Create a LocalDate object for now.
			 LocalDate now = LocalDate.now();
			 // Create a LocalDate object for the order date.
			 LocalDate orderDatePlus30 = LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDay());
			 // Add one month to the order date.
			 orderDatePlus30 = orderDatePlus30.plusMonths(1);
			 // If the current date is after the order date + one month,
			 // it's rushable.
			 return now.isAfter(orderDatePlus30); 

			 } );

		
		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder()); // true
		System.out.println("Balloons isPriorityOrder: " +balloons.isPriorityOrder()); // false
		
		System.out.println("Anvil isPriorityOrder: " +  anvil.isPriorityOrder());
		System.out.println("Hammer isPriorityOrder: " +  hammer.isPriorityOrder());


		

	}

}
