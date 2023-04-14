package bj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			String op = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			if (n == 0) {
				AC_zero(op, n);
				continue;
			}
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");

			String[] inArr = temp.split(",");
			int[] number = new int[n];
			for (int j = 0; j < n; j++) {
				number[j] = Integer.parseInt(inArr[j]);
			}
			AC(op, n, number);
		}

	}

	public static void AC_zero(String op, int n) {
		int len = op.length();
		for (int i = 0; i < len; i++) {
			if (op.charAt(i) == 'D') {
				System.out.println("error");
				return;
			}
		}
		System.out.println("[]");
	}

	public static void AC(String op, int n, int[] number) {
		StringBuffer sb = new StringBuffer();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			deque.add(number[i]);
		}
		boolean reverse = false;
		int len = op.length();
		for (int i = 0; i < len; i++) {
			if (op.charAt(i) == 'R') {
				reverse = !reverse;
			} else if (op.charAt(i) == 'D') {
				if (deque.isEmpty()) {
					System.out.println("error");
					return;
				}
				if (reverse) {
					deque.pollLast();
				} else {
					deque.pollFirst();
				}
			}
		}
		String answer = "[";
		while (!deque.isEmpty()) {
			if (reverse) {
				sb.append(deque.pollLast());
			} else {
				sb.append(deque.pollFirst());
			}
			if (deque.isEmpty()) {
				break;
			} else {
				sb.append(",");
			}
		}

		sb.append("]");
		answer += sb.toString();
		System.out.println(answer);
	}

}
