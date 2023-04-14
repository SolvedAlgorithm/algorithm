package bj1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int len = input.length();
		String temp = "";

		Queue<Integer> number = new LinkedList<>();
		Queue<String> operator = new LinkedList<>();

		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == '-') {
				number.add(Integer.parseInt(temp));
				temp = "";
				operator.add("-");
			} else if (input.charAt(i) == '+') {
				number.add(Integer.parseInt(temp));
				temp = "";
				operator.add("+");
			} else {
				temp += input.charAt(i);
			}
		}
		number.add(Integer.parseInt(temp));
		len = operator.size();
		int ans = number.poll();
		int operand = 0;
		while(!operator.isEmpty()) {
			operand += number.poll();
			String op = operator.poll();
			if(op.equals("+")) {
				ans += operand;
				operand = 0;
			}else if (op.equals("-")) {
				while(!operator.isEmpty()) {
					String op2 = operator.peek();
					if(op2.equals("+")) {
						operator.poll();
						operand += number.poll();
					}else if(op2.equals("-")) {
						break;
					}
				}
				ans -= operand;
				operand = 0;
			}
			
		}
		System.out.println(ans);

	}

}
