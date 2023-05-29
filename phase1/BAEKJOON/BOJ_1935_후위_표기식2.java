package bj1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String equation = br.readLine();
		int len = equation.length();

		HashMap<Character, Double> operand = new HashMap<>();
		for (int i = 0; i < n; i++) {
			double temp = Double.parseDouble(br.readLine());
			int temp_key = 'A' + i;
			operand.put((char) temp_key, temp);
		}

		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			char chk = equation.charAt(i);
			if (chk == '*' || chk == '/' || chk == '+' || chk == '-') {
				if (stack.size() >= 2) {
					double b = stack.pop();
					double a = stack.pop();
					switch (chk) {
					case '*':
						stack.add(a * b);
						break;
					case '/':
						stack.add(a / b);
						break;
					case '+':
						stack.add(a + b);
						break;
					case '-':
						stack.add(a - b);
						break;
					}
				}
			}else {
				stack.add(operand.get(chk));
			}
		}
		double answer = stack.pop();
		System.out.println(String.format("%.2f", answer));

	}

}
