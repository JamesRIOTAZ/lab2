package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	
	public static double taxRate;
	
	static
	{
		taxRate = 0.05;
	}
	
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private String product;
	private int quantity;
	
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
	
	public char jobSize() {
		if(quantity <= 25)
			return 'S';
		else if(quantity >= 26 && quantity <=75)
			return 'M';
		else if(quantity > 76 && quantity <=150)
			return 'L';
		else
			return 'X';
	}
	
	public double computeTotal() {
		return getDiscount() + getTax();
	}
	
	public double getDiscount(){
		double discountPercentage;
		switch(jobSize()) {
		case 'X': discountPercentage = 0.03; break;
		case 'L': discountPercentage = 0.02; break;
		case 'M': discountPercentage = 0.01; break;
		default: discountPercentage = 0.00;
		}
		return orderAmount-(orderAmount*discountPercentage);
	}
	
	public double getTax() {
		if(orderAmount>1500)
			return 0;
		else
			return getDiscount()*taxRate;
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if(isPositive(quantity))
			this.orderAmount = orderAmount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(isPositive(quantity))
			this.quantity = quantity;
	}

	public static double getTaxRate() {
		return taxRate;
	}
	private boolean isPositive(double checkThis) {
		if(checkThis<=0)
			System.out.println("error, number must be positive");
		
		return checkThis>0;
	}

}

