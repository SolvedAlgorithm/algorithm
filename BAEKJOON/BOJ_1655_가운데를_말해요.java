package bj1655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();
		int testcase = Integer.parseInt(str);
		PriorityQueue<Integer> small = new PriorityQueue<>();
		PriorityQueue<Integer> big = new PriorityQueue<>();
		int mid = 0;
		for (int i = 0; i < testcase; i++) {
			str = bf.readLine();
			int n = Integer.parseInt(str);
			if (i == 0) {
				mid = n;
				bw.write(Integer.toString(mid));
				bw.newLine();
			} else {
				if (n > mid) {
					big.add(n);
				} else {
					small.add((-1) * n);
				}
				if (((i + 1) / 2) < big.size()) {
					small.add((-1) * mid);
					mid = big.poll();
				} else if (((i + 1) / 2) <= small.size()) {
					if ((i + 1) % 2 == 0) {
						big.add(mid);
						mid = (-1) * small.poll();
					}
				}
				bw.write(Integer.toString(mid));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();

	}

}
