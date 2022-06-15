package bj17103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] cnt = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			cnt[i] = 0;
		}

		boolean[] isPrime = eratos();
		for (int i = 0; i < n; i++) {
			for (int j = 2; j <= num[i] / 2; j++) {
				if (isPrime[j] && isPrime[num[i] - j]) {
					cnt[i]++;

				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(cnt[i]);
		}

	}

	public static boolean[] eratos() {
		boolean[] eratos = new boolean[1000001];
		for (int i = 0; i < 1000001; i++) {
			eratos[i] = true;
		}
		eratos[0] = false;
		eratos[1] = false;
		for (int i = 2; i < 1000001; i++) {
			for (int j = i + i; j < 1000001; j += i) {
				eratos[j] = false;
			}
		}
		LinkedList<Integer> odd_prime = new LinkedList<>();
		for (int i = 3; i < 1000001; i += 2) {
			if (eratos[i]) {
				odd_prime.add(i);
			}
		}
		return eratos;
	}
}
