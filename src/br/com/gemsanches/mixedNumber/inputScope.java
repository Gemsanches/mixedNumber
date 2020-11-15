package br.com.gemsanches.mixedNumber;

public class inputScope {
	
	
	
	public static int between (int minimum, int maximum) {
		int result = Integer.MIN_VALUE;
		boolean expectingValidAnswer = true;
		while (expectingValidAnswer) {
			//read input
			expectingValidAnswer = result<minimum || result>maximum;
			if(expectingValidAnswer) {
				System.out.print("Invalid input: must be between ");
				System.out.println(minimum + " and " + maximum + ".");
			}
		}
		return result;
	}
	
	
	//TODO adaptar para qualquer tipo numérico
	public static Number between (Number minimum, Number maximum) {
		Number result = Double.MIN_VALUE;
		boolean expectingValidAnswer = true;
		while (expectingValidAnswer) {
			//read input
			expectingValidAnswer = result.doubleValue()<minimum.doubleValue()
								|| result.doubleValue()>maximum.doubleValue();
			if(expectingValidAnswer) {
				System.out.print("Invalid input: must be between ");
				System.out.println(minimum + " and " + maximum + ".");
			}
		}
		return result;
	}
	
	
}
