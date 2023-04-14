package bj1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		long cnt = 0;
		long idx = 0;
		while (true) {
			idx++;
			long temp = s - idx;
			if (temp == 0) {
				cnt++;
				break;
			} else if (temp < idx + 1) {
				continue;
			}
			s -= idx;
			cnt++;
			if (s == 0) {
				break;
			}
		}
		System.out.println(cnt);

	}

}
