package br.com.gemsanches.mixedNumber;

public class test {
	public static void main(String[] args) {
//		Mixed mixed = new Mixed(5);
//		System.out.println(mixed.toString());
//		System.out.println(String.valueOf(5));
//		System.out.println(5);
//		System.out.println("5");
//		System.out.println(mixed.toString()=="5");
//		System.out.println(String.valueOf(5)=="5");
//		System.out.println(mixed.toString()==String.valueOf(5));
//		System.out.println("5"=="5");
//		System.out.println(mixed.toString()==mixed.toString());
//		System.out.println(String.valueOf(5)==String.valueOf(5));
//		System.out.println(String.valueOf(5).equals(String.valueOf(5)));
//		Mixed fromMaxInt = new Mixed(Integer.MAX_VALUE+1);
//		System.out.println(fromMaxInt.getIntegerPart());
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Short.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(Math.pow(0.1, Mixed.MAX_HOUSES));
		
		Mixed m = new Mixed(Math.PI,0.0005);
		System.out.println(m.getIntegerPart());
		System.out.println(m.getNumerator());
		System.out.println(m.getDenominator());
	}
}
