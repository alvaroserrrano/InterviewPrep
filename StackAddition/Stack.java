package edu.wmich.cs1120.stack.alvaro;

public class Stack {
	public int maxSize;
	public int[] data;
	public int top;
	//CONSTRUCTOR
	public Stack(int s) {
		maxSize = s;
		data = new int[s];
		top = -1;
	}
	public void push(int p) {
		data[++top] = p;
	}
	public int pop() {
		return data[top--];
	}
	public int peek() {
		return data[top];
	}
	public boolean isEmpty() {
		return (top == -1);
	}
}
