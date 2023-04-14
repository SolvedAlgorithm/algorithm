package bj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int N = Integer.parseInt(str);
		str = br.readLine();
		String[] temp = str.split(" ");
		int[] input = new int[N];
		int max = -1;
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(temp[i]);
			if (max < input[i]) {
				max = input[i];
			}
		}

		int[] primes = Eratos(max);

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (primes[input[i]] == 0)
				count++;
		}

		System.out.println(count);
	}

	public static int[] Eratos(int N) {
		int[] eratos = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			eratos[i] = 0;
		}
		eratos[1] = 1;
		for (int i = 2; i < N + 1; i++) {
			if (eratos[i] == 1)
				continue;
			if (i * i > N)
				break;
			for (int j = i * i; j < N + 1; j += i) {
				eratos[j] = 1;
			}

		}
		return eratos;
	}
}
