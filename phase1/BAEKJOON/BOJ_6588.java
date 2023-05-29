package bj6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] odd_prime = eratos();
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			boolean ans = false;
			for (int i = 3; i < 500001; i++) {
				if (n < i) {
					System.out.println("Goldbach's conjecture is wrong.");
					ans = true;
					break;
				}
				if (odd_prime[i] && odd_prime[n - i]) {
					System.out.println(n + " = " + i + " + " + (n - i));
					ans = true;
					break;
				}
			}
			if(!ans) {
				System.out.println("Goldbach's conjecture is wrong.");
			
			}
			
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
