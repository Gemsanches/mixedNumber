package br.com.gemsanches.mixedNumber.Contructors;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.gemsanches.mixedNumber.Mixed;

public class DoubleAndHousesNumberConstructor {
	
	@Test
	public void mustCreateFromDoubleAndDecimal() {
		Mixed mixed = new Mixed(Math.PI,5);
		assertTrue(mixed.getIntegerPart() == 3);
		assertTrue(mixed.getNumerator() == 14159);
		assertTrue(mixed.getDenominator() == 100000);
	}
	
	@Test
	public void mustReduceFractionToSimplestForm() {
		Mixed mixed = new Mixed(Math.PI,2);
		assertTrue(mixed.getIntegerPart() == 3);
		assertTrue(mixed.getNumerator() == 7);
		assertTrue(mixed.getDenominator() == 50);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = RuntimeException.class)
	public void mustNotAcceptNegativeDecimal() {
		Mixed mixed = new Mixed(Math.PI,-5);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = RuntimeException.class)
	public void mustNotAcceptPrecisionBiggerThanItCanHandle() {
		int tooManyDecimalHouses = Mixed.MAX_HOUSES + 1;
		Mixed mixed = new Mixed(Math.PI,tooManyDecimalHouses);
	}
		
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void mustDetectIfCannotAccommodateDouble() {
		double biggerThanMaxInt = Integer.MAX_VALUE + 1.5;
		Mixed mixed = new Mixed(biggerThanMaxInt,4);
	}
}
