package bj1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] in = new int[n + 1];
		int[] time = new int[n + 1];
		int[] finish = new int[n + 1];
		ArrayList<ArrayList<Integer>> works = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			in[i] = 0;
			time[i] = 0;
			works.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < n + 1; i++) {
			String[] inArr = br.readLine().split(" ");
			time[i] = Integer.parseInt(inArr[0]);
			int size = inArr.length;
			in[i] = size - 2;
			for (int j = 1; j < size - 1; j++) {
				int a = Integer.parseInt(inArr[j]);
				works.get(a).add(i);
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			if (in[i] == 0) {
				queue.add(i);
			}
			finish[i] = time[i];
		}
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			ArrayList<Integer> temp = works.get(pop);
			int size = temp.size();
			for (int i = 0; i < size; i++) {
				in[temp.get(i)]--;
				if (in[temp.get(i)] == 0) {
					queue.add(temp.get(i));
				}
				finish[temp.get(i)] = Math.max(finish[temp.get(i)], finish[pop] + time[temp.get(i)]);
			}

		}
		for (int i = 1; i < n + 1; i++) {
			System.out.println(finish[i]);
		}
	}

}
