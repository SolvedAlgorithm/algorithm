package bj1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] people = new long[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(br.readLine());
			people[i] *= -1;
		}
		Arrays.sort(people);
		long answer = 0;
		for (int i = 0; i < N; i++) {
			long temp = people[i] * (-1) - i;
			temp = Math.max(0, temp);
			answer += temp;

		}
		System.out.println(answer);
	}

}
