package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {

	public static double taxRate;

	static {
		taxRate = 0.05;
	}

	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	private static Rushable rushable;

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public Order(MyDate d, double amt, String c) {
		// this(d, amt, c,,1);
	}

	public Order(MyDate d, double amt, String c, Product p, int q) {
		setOrderDate(d);
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The Tax for " + anAmount + " is " + anAmount * Order.taxRate);
	}

	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	public String toString() {
		return quantity + " ea. " + product + " for " + customer;
	}

	public char jobSize() {
		if (quantity <= 25)
			return 'S';
		else if (quantity >= 26 && quantity <= 75)
			return 'M';
		else if (quantity > 76 && quantity <= 150)
			return 'L';
		else
			return 'X';
	}

	public double computeTotal() {
		return getDiscount() + getTax();
	}

	public double getDiscount() {
		double discountPercentage;
		switch (jobSize()) {
		case 'X':
			discountPercentage = 0.03;
			break;
		case 'L':
			discountPercentage = 0.02;
			break;
		case 'M':
			discountPercentage = 0.01;
			break;
		default:
			discountPercentage = 0.00;
		}
		return orderAmount - (orderAmount * discountPercentage);
	}

	public double getTax() {
		if (orderAmount > 1500)
			return 0;
		else
			return getDiscount() * taxRate;
	}

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		if (isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
		} else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (isPositive(quantity))
			this.orderAmount = orderAmount;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (isPositive(quantity))
			this.quantity = quantity;
	}

	public static double getTaxRate() {
		return taxRate;
	}

	private boolean isPositive(double checkThis) {
		if (checkThis <= 0)
			System.out.println("error, number must be positive");

		return checkThis > 0;
	}

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}

	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		} else {
			System.out.println("rushable not set");
		}
		return priorityOrder;
	}

	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()) {
			if (holiday.equals(proposedDate)) {
				result = true;
			}
		}
		return result;
	}

}
