package bj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] inArr = br.readLine().split(" ");
		int[] height = new int[n + 1];
		int[] answer = new int[n + 1];
		Stack<Tuple> stack = new Stack<>();
		for (int i = 1; i < n + 1; i++) {
			height[i] = Integer.parseInt(inArr[i - 1]);
			answer[i] = 0;
		}
		stack.add(new Tuple(0, Integer.MAX_VALUE));
		for (int i = 1; i < n + 1; i++) {
			while (stack.peek().height < height[i]) {
				stack.pop();
			}
			System.out.print(stack.peek().idx + " ");
			stack.add(new Tuple(i, height[i]));
		}

	}

}

class Tuple {
	int height, idx;

	public Tuple(int i, int h) {
		this.idx = i;
		this.height = h;
	}
}
