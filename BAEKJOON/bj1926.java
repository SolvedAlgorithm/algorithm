package bj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);

		int[][] map = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		int maxArea = 0;
		int cnt = 0;
		boolean chk = false;
		for (int i = 0; i < n; i++) {
			inArr = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(inArr[j]);
				if (map[i][j] == 1) {
					chk = true;
					visit[i][j] = false;
				} else {
					visit[i][j] = true;
				}
			}
		}
		if (!chk) {
			System.out.println(0);
			System.out.println(0);
		} else {
			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, -0, 1, -1 };

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j]) {
						continue;
					}
					cnt++;
					Queue<Tuple> queue = new LinkedList<>();
					int area = 1;
					visit[i][j] = true;
					queue.add(new Tuple(i, j));
					while (!queue.isEmpty()) {
						Tuple pop = queue.poll();
						for (int k = 0; k < 4; k++) {
							int newX = pop.x + dx[k];
							int newY = pop.y + dy[k];
							if (newX >= n || newY >= m || newX < 0 || newY < 0) {
								continue;
							}

							if (!visit[newX][newY]) {
								visit[newX][newY] = true;
								queue.add(new Tuple(newX, newY));
								area++;
							}

						}

					}
					maxArea = Math.max(maxArea, area);

				}
			}
			System.out.println(cnt);
			System.out.println(maxArea);
		}

	}

}

class Tuple {
	int x, y;

	public Tuple(int a, int b) {
		this.x = a;
		this.y = b;
	}
}