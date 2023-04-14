package bj1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] number = new int[n];
		int negative = 0;
		int zero = 0;
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(br.readLine());
			if (number[i] == 0) {
				zero++;
			}
			if (number[i] < 0) {
				negative++;
			}
		}
		Arrays.sort(number);
		int sum = 0;
		if (negative == 1) {
			if (zero == 0) {
				sum += number[0];
			}
		} else {
			for (int i = 0; i < negative; i += 2) {
				int temp = 0;
				if (i + 1 < negative) {
					temp = number[i] * number[i + 1];
				} else {
					if (zero == 0) {
						temp = number[i];
					}
				}
				sum += temp;
			}
		}
		for (int i = n - 1; i >= negative + zero; i -= 2) {
			int temp = 0;
			if (i - 1 >= negative + zero) {
				if (number[i] == 1 || number[i - 1] == 1) {
					temp = number[i] + number[i - 1];
				} else {
					temp = number[i] * number[i - 1];
				}
			} else {
				temp = number[i];
			}
			sum += temp;
		}
		System.out.println(sum);
	}

}
