/**
 * 
 */
package module3.activity;

/**
 * @author 
 *
 */
public class PrintNumWithWhile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// Print all even numbers less than 100
		int i = 0;
		while(i<100){
			System.out.println(i);
			i=i+2;			
		}
		
		 
		// write code to Print all odd numbers less than 100

		i = 0;
		while(i < 100) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
			i++;
		}

//		using last bit to check the numbers, odd numbers ends with 1, even numbers ends with 0
//		 i = 0;
//		while(i < 100) {
//			if ((i & 1) == 1) {
//				System.out.println(i);
//			}
//			i++;
//
//		}
//


	}

}
