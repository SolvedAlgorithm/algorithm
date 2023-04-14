package bj5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testcase; test++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<String>> call = new ArrayList<>();
			for (int i = 0; i < 11; i++) {
				call.add(new ArrayList<String>());
			}
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				call.get(input.length()).add(input);
			}

		}

	}

}
