package bj17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		long subin = Integer.parseInt(inArr[1]);
		long[] dist = new long[n];
		inArr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			long temp = Long.parseLong(inArr[i]);
			temp = subin - temp;
			if (temp < 0) {
				dist[i] = -temp;
			} else {
				dist[i] = temp;
			}
		}
		Arrays.sort(dist);
		long answer = dist[0];
		for (int i = 1; i < n; i++) {
			answer = gcd(answer, dist[i]);
		}
		System.out.println(answer);

	}

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}