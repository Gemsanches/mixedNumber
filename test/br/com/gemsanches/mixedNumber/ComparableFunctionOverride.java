package br.com.gemsanches.mixedNumber;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ComparableFunctionOverride {
	
	@Test
	public void compareDifferentValues() {
		Mixed bigger = new Mixed(500,3,14);
		Mixed smaller = new Mixed(3,14,500);
		assertTrue(bigger.compareTo(smaller) > 0);
		assertTrue(smaller.compareTo(bigger) < 0);
	}
	
	@Test
	public void compareWithSameIntegerPart() {
		Mixed bigger = new Mixed(5,7,9);
		Mixed smaller = new Mixed(5,3,4);
		assertTrue(bigger.compareTo(smaller) > 0);
		assertTrue(smaller.compareTo(bigger) < 0);
	}
	
	@Test
	public void compareWithSameValues() {
		Mixed firstMixed = new Mixed(5.75,2);
		Mixed secondMixed = new Mixed(5,3,4);
		assertTrue(firstMixed.compareTo(secondMixed) == 0);
		assertTrue(secondMixed.compareTo(firstMixed) == 0);
	}
}
