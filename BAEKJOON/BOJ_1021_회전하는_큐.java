package bj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			deque.add(i);
		}
		inArr = br.readLine().split(" ");
		int answer = 0;
		for (int i = 0; i < m; i++) {
			int select = Integer.parseInt(inArr[i]);
			int front = deque.indexOf(select);
			int back = deque.size() - front;
			if (front > back) {
				for (int j = 0; j < back; j++) {
					int temp = deque.pollLast();
					deque.addFirst(temp);
				}
				answer += back;
			} else {
				for (int j = 0; j < front; j++) {
					int temp = deque.pollFirst();
					deque.addLast(temp);
				}
				answer += front;
			}
			deque.pollFirst();

		}

		System.out.println(answer);

	}

}
