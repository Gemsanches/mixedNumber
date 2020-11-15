package br.com.gemsanches.mixedNumber.Contructors;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.gemsanches.mixedNumber.Mixed;

public class ThreeIntegersConstructor {
	
	@Test
	public void mustCreateFromThreePositivesInts() {
		Mixed mixed = new Mixed(5,3,4);
		assertTrue(mixed.getIntegerPart() == 5);
		assertTrue(mixed.getNumerator() == 3);
		assertTrue(mixed.getDenominator() == 4);
	}
	
	@Test
	public void mustCreateFromNegativeIntegerPartAndPostivesFractionPart() {
		Mixed mixed = new Mixed(-5,3,4);
		assertTrue(mixed.getIntegerPart() == -5);
		assertTrue(mixed.getNumerator() == 3);
		assertTrue(mixed.getDenominator() == 4);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = ArithmeticException.class)
	public void mustNotCreateFromZeroOnDenominator() {
		Mixed mixed = new Mixed(5,3,0);
	}	
	
	@SuppressWarnings("unused")
	@Test(expected = ArithmeticException.class)
	public void mustNotCreateFromNegativeNumerator() {
		Mixed mixed = new Mixed(5,-3,4);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = ArithmeticException.class)
	public void mustNotCreateFromNegativeDenominator() {
		Mixed mixed = new Mixed(5,3,-4);
	}
	
	@Test
	public void mustReduceFractionToSimplestForm() {
		Mixed mixed = new Mixed(5,13,4);
		assertTrue(mixed.getIntegerPart() == 8);
		assertTrue(mixed.getNumerator() == 1);
		assertTrue(mixed.getDenominator() == 4);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = RuntimeException.class)
	public void mustDetectOverflow() {
		Mixed mixed = new Mixed(Integer.MAX_VALUE,5,4);
	}
	
}
