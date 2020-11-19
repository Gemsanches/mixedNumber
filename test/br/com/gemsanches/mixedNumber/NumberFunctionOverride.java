package br.com.gemsanches.mixedNumber;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NumberFunctionOverride {
	/* CAUTION: the necessity of a previous mixed number, created by  *
	 * an independent method, causes these tests to have a dependency *
	 * on the constructor used here.							      */
	Mixed mixed = new Mixed(5,3,4);
	
	@Test
	public void mustFloorToInteger() {
		assertTrue(mixed.intValue() == 5);
	}
	
	@Test
	public void mustFloorToLong() {
		assertTrue(mixed.longValue() == 5);
	}
	
	@Test
	public void mustCalculateToFloat() {
		assertTrue(mixed.floatValue() == 5.75f);
	}
	
	@Test
	public void mustCalculateToDouble() {
		assertTrue(mixed.doubleValue() == 5.75);
	}
}
