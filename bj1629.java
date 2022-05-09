package bj1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		long a = Long.parseLong(inArr[0]);
		long b = Long.parseLong(inArr[1]);
		long c = Long.parseLong(inArr[2]);
		System.out.println(answer(a, b, c));

	}

	public static long answer(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}
		long temp = answer(a, b / 2, c);
		temp = temp * temp % c;
		if (b % 2 == 0) {
			return temp;
		}
		return temp * a % c;
	}

}
