package bj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][][] visit;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");

		int m = Integer.parseInt(inArr[0]);
		int n = Integer.parseInt(inArr[1]);
		int h = Integer.parseInt(inArr[2]);
		int[][][] map = new int[n][m][h];
		visit = new boolean[n][m][h];
		Queue<Tuple> queue = new LinkedList<>();

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				inArr = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					map[i][j][k] = Integer.parseInt(inArr[j]);
					if (map[i][j][k] == 1) {
						visit[i][j][k] = true;
						queue.add(new Tuple(i, j, k));
					} else if (map[i][j][k] == 0) {
						visit[i][j][k] = false;
						cnt++;
					} else { // -1 -> None
						visit[i][j][k] = true;
					}
				}
			}
		}

		int answer = 0;
		while (true) {
			queue = bfs(queue, n, m, h);
			if (queue.size() == 0) {
				break;
			}
			answer++;
		}
		if (cnt > 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static Queue<Tuple> bfs(Queue<Tuple> queue, int n, int m, int h) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int[] dk = { -1, 1 };
		Queue<Tuple> tomato = new LinkedList<>();
		while (!queue.isEmpty()) {
			Tuple pop = queue.poll();
			for (int d = 0; d < 4; d++) {
				int newX = pop.x + dx[d];
				int newY = pop.y + dy[d];

				if (newX >= n || newY >= m || newX < 0 || newY < 0) {
					continue;
				}
				if (!visit[newX][newY][pop.z]) {
					tomato.add(new Tuple(newX, newY, pop.z));
					visit[newX][newY][pop.z] = true;
					cnt--;
				}

			}
			for (int d = 0; d < 2; d++) {
				int newK = pop.z + dk[d];
				if (newK >= h || newK < 0) {
					continue;
				}
				if (!visit[pop.x][pop.y][newK]) {
					tomato.add(new Tuple(pop.x, pop.y, newK));
					visit[pop.x][pop.y][newK] = true;
					cnt--;
				}
			}

		}
		return tomato;
	}

}

class Tuple {
	int x, y, z;

	public Tuple(int a, int b, int c) {
		this.x = a;
		this.y = b;
		this.z = c;
	}
}
