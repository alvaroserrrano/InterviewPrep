package pmt;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  str = "abbc";
		System.out.println(isPalindromeRecursive(str));
		System.out.println(isPalindromeReverse(str));
		System.out.println(isPalindrome(str));

	}

	/*
	 * Check wheter a string is a palindrome
	 * A palindrome is a word, phrase, number
	 *  or other sequences of chars which reads 
	 *  the same backwards as forwards
	 */
	
	//SIMPLE APPROACH
	public static boolean isPalindrome(String str) {
		int length = str.length();
		int forward = 0;
		int backward = length - 1;
		while(backward > forward) {
			char forwardChar = str.charAt(forward++);
			char backwardChar = str.charAt(backward--);
			if(forwardChar != backwardChar) {
				return false;
			}
		}
		return true;
	}
	
	//REVERSING THE STRING
	public static boolean isPalindromeReverse(String str) {
		int length = str.length();
		String reverse = "";
		for(int i = length - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}
		if(reverse.equals(str))
			return true;
		return false;
	}
	
	//RECURSIVE
	public static boolean isPalindromeRecursive(String str) {
		return isPalindromeRecursive(str, 0, str.length() - 1);
	}
	//overloaded
	public static boolean isPalindromeRecursive(String str,
			int forward, int backward) {
		//Single char
		if(forward == backward)
			return true;
		if(str.charAt(forward) != str.charAt(backward))
			return false;
		if(forward < backward +1) {
			return isPalindromeRecursive(str, forward + 1, backward - 1);
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
