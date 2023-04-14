package bj2089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		int quotient = 0;
		int remain = 0;
		while (true) {
			if (n > 0) {
				quotient = -(n / 2);
				remain = n % 2;
			} else {
				quotient = (-n + 1) / 2;
				remain = n % 2;
			}
			if (remain == 0) {
				sb.append(0);
			} else {
				sb.append(1);
			}
			n = quotient;
			if (n == 0) {
				break;
			}
		}
		System.out.println(sb.reverse().toString());
	}

}
