package bj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testcase; test++) {
			String[] inArr = br.readLine().split(" ");
			int num1 = Integer.parseInt(inArr[0]);
			int num2 = Integer.parseInt(inArr[1]);

			if (num2 > num1) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			System.out.println(lcm(num1, num2));

		}

	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		int temp = gcd(a, b);
		int answer = a / temp;
		answer *= b;
		return answer;
	}

}
