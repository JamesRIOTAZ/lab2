package com.acme.testing;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.acme.utils.ConversionService;

public class TestConversionService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ConversionService.fluidOunces(1.1f));
		System.out.println(ConversionService.gallons(2.2f));
		System.out.println(ConversionService.grams(BigInteger.valueOf(30)));
		System.out.println(ConversionService.milliliters(40));
		System.out.println(ConversionService.ounces(BigDecimal.valueOf(50)));
		System.out.println(ConversionService.pints(6.6f));
		System.out.println(ConversionService.pounds(BigDecimal.valueOf(7.7)));

		// can you figure out why these do not compile
		ConversionService.fluidOunces((float)1.1);
		ConversionService.grams(BigInteger.valueOf(30));
		ConversionService.milliliters((int)4.0);
		BigInteger grams = ConversionService.grams(BigInteger.valueOf(30));
		BigInteger byteGrams = ConversionService.grams(BigInteger.valueOf(30));
		
		System.out.println(grams);
		System.out.println(byteGrams);

		// why do these still work even though the types are different
		
		System.out.println("------------------------------------");
		double ounces = ConversionService.fluidOunces(1.1f);
		System.out.println(ounces);
		long milliliters = ConversionService.milliliters(40);
		System.out.println(milliliters);
		double decimalmilliliters = ConversionService.milliliters(40);
		System.out.println(decimalmilliliters);
		BigInteger s = BigInteger.valueOf(30);
		System.out.println(ConversionService.grams(s));
		byte b = 4;
		System.out.println(ConversionService.milliliters(b));
		char z = 'z';
		System.out.println(ConversionService.milliliters(z));
		System.out.println(ConversionService.gallons(200));
		System.out.println(ConversionService.ounces(BigDecimal.valueOf(50.5f)));
		System.out.println(ConversionService.pints(6L));
		System.out.println(ConversionService.pounds(BigDecimal.valueOf(7L)));
		

		// compare these results.  Can you tell why they are different?
		
		System.out.println("------------------------------------");
		float bigGallons = ConversionService.gallons(123456789123456789L); //float * float 0.2642f;
		System.out.println(bigGallons);
		double bigGallons2 = 123456789123456789L * 0.2642; // double * double
		System.out.println(bigGallons2);
		

		
		System.out.println("------------------------------------");
		BigInteger bigGrams = ConversionService.grams(BigInteger.valueOf(1234567890)); //int * int 1000;
		System.out.println(bigGrams);
		long bigGrams2 = 1234567890L * 1000L; //long to long
		System.out.println(bigGrams2);
		
	}

}
