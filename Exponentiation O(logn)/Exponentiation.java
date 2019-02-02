package interviewPrep.AlvaroSerrano;

public class Exponentiation {
	
	/*
	 * There are 2 possible solution--> O(n) V O(log n)
	 */
	
	//O(n)
	/*
	 * This is a bad option
	 * Example x^8 would be = x^8, x^7, x^6...x^0 --> 9 steps
	 * 
	 * public static int power(int x, int n){
	 * 		if(n == 0)
	 * 			return 1;
	 * 		else{
	 * 			return x * power(x, n-1)
	 * 	}
	 * }
	 */
	
	//O(logn)
	/*
	 * This is the right and faster solution
	 * If n is an even integer we can return x^(n/2) * x^(n/2)
	 * 		It is better to store n/2 in a variable y = n/ 2 to reduce the number of operation; 
	 */
	public static int power(int x, int n) {
		//Base condition
		if(n == 0)
			return 1;
		int y = power(x, n / 2);
		//if exponent is odd
		if(n % 2 != 0) {
			return x * y * y;
		}
		//exponent is even
		else {
			return y * y;
		}
	}

	public static void main(String[] args) {
		int x = 2;
		int n = 10;
		System.out.printf("Solution:  %d", power(x, n));
	}

}
