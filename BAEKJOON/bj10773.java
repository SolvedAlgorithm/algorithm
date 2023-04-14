package bj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				sum -= stack.pop();
			} else {
				sum += input;
				stack.add(input);
			}
		}
		System.out.println(sum);

	}

}
