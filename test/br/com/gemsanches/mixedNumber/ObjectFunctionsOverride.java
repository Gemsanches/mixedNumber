package br.com.gemsanches.mixedNumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ObjectFunctionsOverride {
	/* CAUTION: the necessity of a previous mixed number, created by  *
	 * an independent method, causes these tests to have a dependency *
	 * on the constructors used along this class.				      */
	
	
	//toString
	@Test
	public void mustPresentMixedRepresentation() {
		Mixed mixed = new Mixed(5,3,4);
		assertTrue(mixed.toString().equals("5&(3/4)"));
	}
	
	@Test
	public void mustIgnoreIrrelevantFraction() {
		Mixed mixed = new Mixed(5,0,4);
		assertTrue(mixed.toString().equals("5"));
	}
	
	
	//equals and hashCode
	@Test
	public void mustConsiderEqualityOfValues() {
		Mixed firstMixed = new Mixed(5,3,4);
		Mixed secondMixed = new Mixed(5.75,2);
		assertTrue(firstMixed.equals(secondMixed));
		assertTrue(firstMixed.hashCode() == secondMixed.hashCode());
	}
	
	@Test
	public void mustConsiderInequalityOfIntegerPart() {
		Mixed firstMixed = new Mixed(5,3,4);
		Mixed secondMixed = new Mixed(6.75,2);
		assertFalse(firstMixed.equals(secondMixed));
		assertFalse(firstMixed.hashCode() == secondMixed.hashCode());
	}
	
	@Test
	public void mustConsiderInequalityOfNominator() {
		Mixed firstMixed = new Mixed(5,3,4);
		Mixed secondMixed = new Mixed(5.25,2);
		assertFalse(firstMixed.equals(secondMixed));
		assertFalse(firstMixed.hashCode() == secondMixed.hashCode());
	}
	
	@Test
	public void mustConsiderInequalityOfDenominator() {
		Mixed firstMixed = new Mixed(5,3,5);
		Mixed secondMixed = new Mixed(5.75,2);
		assertFalse(firstMixed.equals(secondMixed));
		assertFalse(firstMixed.hashCode() == secondMixed.hashCode());
	}
	
	@Test
	public void mustIgnoreInequalityOfIrrelevantFractionPart() {
		Mixed firstMixed = new Mixed(3,1000,500);
		System.out.println(firstMixed);
		Mixed secondMixed = new Mixed(5.00,2);
		System.out.println(secondMixed);
		assertTrue(firstMixed.equals(secondMixed));
		assertTrue(firstMixed.hashCode() == secondMixed.hashCode());
	}
	
}
