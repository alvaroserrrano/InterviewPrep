package edu.wmich.cs1120.stack.alvaro;
import java.io.IOException;

//THIS CLASS PRINTS THE SUMATION OF NUMBER N
public class StackAddition {
	static int num;
	static int ans;
	static Stack theStack;
	public static void main(String[] args) throws IOException{
		num = 50;
		stackAddition();
		System.out.println("Sum of " + num + " is " +ans);
	}//main
	
	public static void stackAddition() {
		theStack = new Stack(10000);
		ans = 0;
		while(num > 0) {
			theStack.push(num);
			--num;
		}
		while(!theStack.isEmpty()){
			int newN = theStack.pop();
			ans += newN;
		}
	}
	
	
}//class
