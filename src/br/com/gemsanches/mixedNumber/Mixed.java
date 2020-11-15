package br.com.gemsanches.mixedNumber;

import java.lang.constant.Constable;
import java.lang.constant.ConstantDesc;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.Optional;

public class Mixed extends Number
	implements Comparable<Mixed>, Constable, ConstantDesc{

	private static final long serialVersionUID = -6480044537610067970L;
	
	private int integerPart;
	private int numerator;
	private int denominator = 1;
	public static final int   MAX_HOUSES = 10;//limited by Integer.MAX_VALUE
	public static final double   MAX_PRECISION = Math.pow(0.1, MAX_HOUSES);
	
	public Mixed (int i) {
		this.integerPart = i;
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public Mixed (int integer, int numerator, int denominator) {
		if(denominator == 0) {
			throw new ArithmeticException("Denominator cannot be zero.");
		}
		if(numerator < 0 || denominator < 0) {
			throw new ArithmeticException("Fraction components does not carry signal.");
		}
		this.integerPart = integer;
		this.numerator = numerator;
		this.denominator = denominator;
		Mixed.simplifyFraction(this);
		Mixed.detectOverflow(this.integerPart,integer);
	}
	
	public Mixed (Mixed m) {
		this.integerPart = m.integerPart;
		this.numerator = m.numerator;
		this.denominator = m.denominator;
		Mixed.simplifyFraction(this);
		Mixed.detectOverflow(this.integerPart,m.integerPart);
	}
	
	public Mixed (double d, int numberOfDecimalHouses) {
		if(numberOfDecimalHouses<0 || numberOfDecimalHouses>MAX_HOUSES) {
			throw new RuntimeException("Invalid number of decimal houses.");
		}
		if(d > (double) Integer.MAX_VALUE) {
			throw new RuntimeException("Number too big to suport.");
		}
		this.integerPart = (int) d;
		double decimalPart = (d-this.integerPart) * Math.pow(10, numberOfDecimalHouses);
		this.numerator = (int) decimalPart;
		this.denominator = (int) Math.pow(10, numberOfDecimalHouses);
		Mixed.simplifyFraction(this);
	}
	
	public Mixed (double d, double precision) {
		this.integerPart = (int) d;
				
		//this.numerator = ???
				
		this.denominator = (int) (1/precision);
	}
	
	private static void detectOverflow(int integerPartAfter, int integerPartBefore) {
		if(integerPartBefore > integerPartAfter) {
			throw new RuntimeException("An overflow have ocuried.");
		}
	}

	private static void simplifyFraction(Mixed mixed) {
		while(mixed.numerator >= mixed.denominator) {
			mixed.numerator -= mixed.denominator;
			mixed.integerPart ++;
		}
		int gcd = gcd(mixed.numerator,mixed.denominator);
		mixed.numerator /= gcd;
		mixed.denominator /= gcd;
	}

	private static int gcd(int p, int q) {
	        if (q == 0) {
	            return p;
	        }
	        return gcd(q, p % q);
	    }
	
	public int getIntegerPart() {
		return integerPart;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	
	
	
	

	@Override
	public int intValue() {
		return this.integerPart;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object resolveConstantDesc(Lookup lookup) throws ReflectiveOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<? extends ConstantDesc> describeConstable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Mixed o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Mixed convertFrom(double d) {
		// TODO Implement recurring decimal detection
		return null;
	}

}
