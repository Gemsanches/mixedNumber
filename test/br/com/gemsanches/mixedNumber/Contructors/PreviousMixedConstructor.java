package br.com.gemsanches.mixedNumber.Contructors;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.gemsanches.mixedNumber.Mixed;

public class PreviousMixedConstructor {
	
	@Test
	public void MustCreateFromOtherMixedNumber() {
		/* CAUTION: the necessity of a previous mixed number, created by *
		 * an independent method, causes this test to have a dependency  *
		 * on the constructor used here.							     */
		Mixed previousMixed = new Mixed(5,3,4);
		
		Mixed mixed = new Mixed(previousMixed);
		assertTrue(mixed.getIntegerPart() == 5);
		assertTrue(mixed.getNumerator() == 3);
		assertTrue(mixed.getDenominator() == 4);
	}
	
	//TODO MustCreatFromOperationsThatResultInMixedNumber
	//this require the operations to be implemented
}
