package br.com.gemsanches.mixedNumber;

public class Mixed extends Number implements Comparable<Mixed>{

	private static final long serialVersionUID = 5626564375058500028L;
	
	public static final int   MAX_HOUSES = 10;//limited by Integer.MAX_VALUE
	public static final double   MAX_PRECISION = Math.pow(0.1, MAX_HOUSES);
	
	private int integerPart;
	private int numerator;
	private int denominator = 1;
	
	
	public Mixed (int i) {
		this.integerPart = i;
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public Mixed (int integer, int numerator, int denominator) {
		this.integerPart = integer;
		this.numerator = numerator;
		this.denominator = denominator;
		this.verifyFractionComponents();
		this.safelyReduceFraction();
	}
	
	public Mixed (Mixed m) {
		this.integerPart = m.integerPart;
		this.numerator = m.numerator;
		this.denominator = m.denominator;
		this.safelyReduceFraction();
	}
	
	public Mixed (double d, int numberOfDecimalHouses) {
		double decimalPart;
		double powerOfTen = Math.pow(10, numberOfDecimalHouses);
		this.verifyDoubleSuport(d);
		this.verifyNumberOfHouses(numberOfDecimalHouses);
		this.integerPart = (int) d;
		decimalPart = (d-this.integerPart) * powerOfTen;
		this.numerator = (int) decimalPart;
		this.denominator = (int) powerOfTen;
		this.safelyReduceFraction();
	}
	
	/**
	 * @param precision Must be between 1 and MAX_PRECISION
	 * */
	public Mixed (double d, double precision) {
		double decimalPart;
		this.verifyDoubleSuport(d);
		this.verifyPrecision(precision);
		this.integerPart = (int) d;
		this.denominator = (int) Math.round(1/precision);
		decimalPart = d - this.integerPart;
		decimalPart *= this.denominator;
		this.numerator = (int) decimalPart;
		this.safelyReduceFraction();
	}
	
	private void safelyReduceFraction() {
		//Overflow detection MUST be executed before fraction simplification.
		this.detectOverflow();
		this.simplifyFraction();
	}
	
	private void detectOverflow() {
		int integerPartAfter = this.integerPart+(this.numerator/this.denominator);
		if(this.integerPart > integerPartAfter) {
			throw new RuntimeException("An overflow have ocuried.");
		}
	}

	private void simplifyFraction() {
		while(this.numerator >= this.denominator) {
			this.numerator -= this.denominator;
			this.integerPart ++;
		}
		int gcd = gcd(this.numerator,this.denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
	}

	private static int gcd(int p, int q) {
	        if (q == 0) {
	            return p;
	        }
	        return gcd(q, p % q);
	    }
	
	private void verifyFractionComponents() {
		if(this.denominator == 0) {
			throw new ArithmeticException("Denominator cannot be zero.");
		}
		if(this.numerator < 0 || this.denominator < 0) {
			throw new ArithmeticException("Fraction components does not carry signal.");
		}
	}
	
	private void verifyDoubleSuport(double d) {
		if(d > Integer.MAX_VALUE) {
			throw new RuntimeException("Number too big to suport.");
		}
	}
	
	private void verifyNumberOfHouses(int numberOfDecimalHouses) {
		if(numberOfDecimalHouses < 0 || numberOfDecimalHouses > MAX_HOUSES) {
			throw new RuntimeException("Invalid number of decimal houses.");
		}
	}
	
	private void verifyPrecision(double precision) {
		if(precision < MAX_PRECISION || precision > 1) {
			throw new RuntimeException("Invalid precision.");
		}
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
	public String toString() {
		if(this.numerator == 0) {
			return String.valueOf(this.integerPart);
		}
		return this.integerPart+
			   "&("+
			   this.numerator+
			   "/"+
			   this.denominator+
			   ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Mixed other = (Mixed) obj;
		if (this.denominator != other.denominator) {
			return false;
		}
		if (this.integerPart != other.integerPart) {
			return false;
		}
		if (this.numerator != other.numerator) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + integerPart;
		result = prime * result + numerator;
		return result;
	}

	
	@Override
	public int intValue() {
		return this.integerPart;
	}

	@Override
	public long longValue() {
		return this.integerPart;
	}

	@Override
	public float floatValue() {
		return this.integerPart + ((float)this.numerator/this.denominator);
	}

	@Override
	public double doubleValue() {
		return this.integerPart + ((double)this.numerator/this.denominator);
	}

	
	@Override
	public int compareTo(Mixed other) {
		int thisNumeratorAsSimpleFraction=this.integerPart*this.denominator
										  +this.numerator;
		int otherNumeratorAsSimpleFraction=other.integerPart*other.denominator
										   +other.numerator;
		return thisNumeratorAsSimpleFraction-otherNumeratorAsSimpleFraction;
	}
	
	
	
	
	public Mixed convertFrom(double d) {
		// TODO Implement recurring decimal detection
		return null;
	}

}
