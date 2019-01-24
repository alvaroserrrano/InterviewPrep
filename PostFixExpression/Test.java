package interviewQuestions;

import java.util.Stack;

public class Test {

	//Method to evaluate a postfix expression
	public static int evaluatePostFixExpression(String exp) {
		
		//create Stack
		Stack<Integer> stack = new Stack <>();
		
		//Scan all chars in the expression one by one
			//if char == number -->push
			//if char == operator -->pop numbers from stack
								//-->do operation
								//push result back to Stack
		//When expression is ended the number in the stack is the final answer
		
		//Scan all chars in expression
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			//if c == number--> push to Stack
			if(Character.isDigit(c))
				stack.push(c - '0');
			
			//if c == operator-->pop numbers and dp operations
			else {
				int value1 = stack.pop();
				int value2 = stack.pop();
				
				switch(c) {
				case '+':
					stack.push(value2 + value1);
					break;
				case '-':
					stack.push(value2 - value1);
					break;
				case '*':
					stack.push(value2 * value1);
					break;
				case '/':
					stack.push(value2 / value1);
					break;
				}
			}
		}
		
		return stack.pop();
		
	}
	
	public static void main (String[] args) {
		String exp = "231*+9-";
		System.out.println("Postfic evaluation :  " + evaluatePostFixExpression(exp));
	}
	
}
