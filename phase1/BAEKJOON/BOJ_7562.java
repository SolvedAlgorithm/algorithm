package bj7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] inArr = br.readLine().split(" ");
			int curr_x = Integer.parseInt(inArr[0]);
			int curr_y = Integer.parseInt(inArr[1]);
			inArr = br.readLine().split(" ");
			int x = Integer.parseInt(inArr[0]);
			int y = Integer.parseInt(inArr[1]);
			if (curr_x == x && curr_y == y) {
				System.out.println(0);
			} else {
				System.out.println(knight(n, curr_x, curr_y, x, y));
			}
		}

	}

	public static int knight(int n, int curr_x, int curr_y, int x, int y) {
		Queue<Tuple> queue = new LinkedList<>();
		int[][] visited = new int[n][n];
		int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = 0;
			}
		}
		queue.add(new Tuple(curr_x, curr_y));
		visited[curr_x][curr_y] = 0;
		while (!queue.isEmpty()) {
			Tuple a = queue.poll();
			for (int i = 0; i < 8; i++) {
				int new_x = a.x + dx[i];
				int new_y = a.y + dy[i];
				if (new_x >= n || new_y >= n || new_x < 0 || new_y < 0) {
					continue;
				}

				if (visited[new_x][new_y] > 0) {
					continue;
				}
				queue.add(new Tuple(new_x, new_y));
				visited[new_x][new_y] = visited[a.x][a.y] + 1;
				if (new_x == x && new_y == y) {
					return visited[new_x][new_y];
				}
			}

		}
		return 0;

	}

}

class Tuple {
	int x, y;

	public Tuple(int i, int j) {
		this.x = i;
		this.y = j;
	}
}