package bj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String room = br.readLine();
		answer(room);

	}

	public static void answer(String room) {
		int[] number = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int max = 0;
		boolean chk = false;
		for (int i = 0; i < room.length(); i++) {
			int idx = room.charAt(i) - '0';
			number[idx]++;
		}

		for (int i = 0; i < 10; i++) {
			if (i == 6 || i == 9) {
				continue;
			}
			if (max < number[i]) {
				max = number[i];
			}
		}
		int temp = (number[6] + number[9]) / 2;
		if ((number[6] + number[9]) % 2 == 1) {
			temp++;
		}
		max = Math.max(max, temp);
		System.out.println(max);
	}

}
