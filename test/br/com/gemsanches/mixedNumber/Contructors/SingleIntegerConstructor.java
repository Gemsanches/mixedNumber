package br.com.gemsanches.mixedNumber.Contructors;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gemsanches.mixedNumber.Mixed;

public class SingleIntegerConstructor {
	
	@Test
	public void mustCreateFromPositiveInt() {
		Mixed fromPositiveInt = new Mixed(5);
		assertTrue(fromPositiveInt.getIntegerPart() == 5);
		assertTrue(fromPositiveInt.getNumerator() == 0);
	}
	
	@Test
	public void mustCreateFromNegativeInt() {
		Mixed fromNegativeInt = new Mixed(-5);
		assertTrue(fromNegativeInt.getIntegerPart() == -5);
		assertTrue(fromNegativeInt.getNumerator() == 0);
	}
	
	@Test
	public void mustCreateFromZeroInt() {
		Mixed fromZero = new Mixed(0);
		assertTrue(fromZero.getIntegerPart() == 0);
		assertTrue(fromZero.getNumerator() == 0);
	}
	
	@Test
	public void mustCreateFromMaxInt() {
		Mixed fromMaxInt = new Mixed(Integer.MAX_VALUE);
		assertTrue(fromMaxInt.getIntegerPart() == Integer.MAX_VALUE);
		assertTrue(fromMaxInt.getNumerator() == 0);
	}
	
	@Test
	public void mustCreateFromNimInt() {
		Mixed fromMinInt = new Mixed(Integer.MIN_VALUE);
		assertTrue(fromMinInt.getIntegerPart() == Integer.MIN_VALUE);
		assertTrue(fromMinInt.getNumerator() == 0);
	}
	
}
