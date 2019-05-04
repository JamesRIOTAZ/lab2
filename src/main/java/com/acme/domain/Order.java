package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	
	public static double taxRate;
	
	static
	{
		taxRate = 0.05;
	}
	
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
	
	public static void setTaxRate(double newRate){
		taxRate = newRate;
	}
	
	public Order(MyDate d, double amt, String c){
		this(d, amt, c,"Anvil",1);
	}
	
	public Order(MyDate d, double amt, String c, String p, int q){
		orderDate=d;
		orderAmount=amt;
		customer=c;
		product=p;
		quantity=q;
	}
	
	public static void computeTaxOn(double anAmount){
		System.out.println("The Tax for "+anAmount+" is "+anAmount * Order.taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: "+orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
}