package bj11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] tiles = new long[n + 1];
		for (int i = 0; i < n + 1; i++) {
			tiles[i] = 0;
		}

		tiles[1] = 1;
		
		if (n == 1) {
			System.out.println(tiles[n]);
		} else {
			tiles[2] = 2;
			for (int i = 3; i < n + 1; i++) {
				tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
			}

			System.out.println(tiles[n]);
		}
	}

}
