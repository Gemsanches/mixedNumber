package br.com.gemsanches.mixedNumber.Contructors;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.gemsanches.mixedNumber.Mixed;

public class DoubleAndPrecisionConstructor {
	
	@Test
	public void mustCreateFromDoubleAndPrecision() {
		Mixed mixed = new Mixed(Math.PI,0.00001);
		assertTrue(mixed.getIntegerPart() == 3);
		assertTrue(mixed.getNumerator() == 14159);
		assertTrue(mixed.getDenominator() == 100000);
		
	}
	
	@Test
	public void mustReduceFractionToSimplestForm() {
		Mixed mixed = new Mixed(Math.PI,0.01);
		assertTrue(mixed.getIntegerPart() == 3);
		assertTrue(mixed.getNumerator() == 7);
		assertTrue(mixed.getDenominator() == 50);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = RuntimeException.class)
	public void mustNotAcceptNegativePrecision() {
		Mixed mixed = new Mixed(Math.PI,-0.001);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = RuntimeException.class)
	public void mustNotAcceptZeroPrecision() {
		Mixed mixed = new Mixed(Math.PI,0.0);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = RuntimeException.class)
	public void mustNotAcceptPrecisionSmalerThanItCanHandle() {
		double tooMuchPrecision = Mixed.MAX_PRECISION/10;
		Mixed mixed = new Mixed(Math.PI,tooMuchPrecision);
	}
	
	@SuppressWarnings("unused")
	@Test (expected = RuntimeException.class)
	public void mustNotAcceptPrecisionBiggerThanItCanHandle() {
		Mixed mixed = new Mixed(Math.PI,3.0);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void mustDetectIfCannotAcomodateDouble() {
		double biggerThanMaxInt = Integer.MAX_VALUE + 1.5;
		Mixed mixed = new Mixed(biggerThanMaxInt,0.001);
	}
}
