package bj3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.length() % 2 == 1) {
				continue;
			}
			if (answer(input)) {
				count++;
			}
		}
		System.out.println(count);

	}

	public static boolean answer(String str) {
		Stack<Character> stack = new Stack<>();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (stack.isEmpty()) {
				stack.add(str.charAt(i));
			} else {
				if (stack.peek() == str.charAt(i)) {
					stack.pop();
				} else {
					stack.add(str.charAt(i));
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
