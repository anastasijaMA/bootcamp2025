package sef.module8.sample;
// Needs to be completed
//Run this class with -ea option enabled in JVM arguments
public class AssertSample {

	public static void test()
	{
		//1 - Type assert 5 %2 and 6%2 in separate statements

		assert (5 %2 ==1) : "Assertion failed: 5 % 2 != 1";

		assert (6 % 2 == 0) : "Assertion failed: 6 % 2 != 0";
		
	}
	public static void main(String arg[]){
		//2 - Call test()
		test();

		System.out.println("Assertions passed successfully.");
		
		
	}			
}
