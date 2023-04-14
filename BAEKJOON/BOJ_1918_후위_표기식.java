package bj1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();

		int len = input.length();

		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			int pr = priority(ch);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (!stack.isEmpty() && priority(stack.peek()) >= pr) {
					sb.append(stack.pop());
				}
				stack.push(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				sb.append(ch);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

	public static int priority(char ch) {
		if (ch == '*' || ch == '/') {
			return 2;
		}
		if (ch == '+' || ch == '-') {
			return 1;
		}
		if (ch == '(' || ch == ')') {
			return 0;
		}
		return -1;
	}
}