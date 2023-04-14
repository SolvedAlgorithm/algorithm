package bj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] height = new long[n + 1];
		long[] answer = new long[n + 1];
		long result = 0;
		height[0] = 0;
		answer[0] = 0;

		for (int i = 1; i < n + 1; i++) {
			height[i] = Long.parseLong(br.readLine());
			answer[i] = 0;
		}
		Stack<Tuple> stack = new Stack<>();
		stack.add(new Tuple(0, Long.MAX_VALUE));
		for (int i = n; i > 0; i--) {
			int pop_idx = 0;
			long cnt = 0;
			while (stack.peek().height < height[i]) {
				Tuple a = stack.pop();
				pop_idx = a.idx;
				cnt += answer[pop_idx] + 1;
			}
			answer[i] = cnt;
			result += answer[i];
			stack.add(new Tuple(i, height[i]));
		}
		System.out.println(result);
	}

}
class Tuple {
	int idx;
	long height;

	public Tuple(int i, long h) {
		this.idx = i;
		this.height = h;
	}
}
