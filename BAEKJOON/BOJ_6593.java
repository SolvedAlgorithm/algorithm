import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][][] map;
	// 동 서 남 북 상 하
	static int[] dk = { 0, 0, 0, 0, -1, 1 };
	static int[] di = { 0, 0, 1, -1, 0, 0 };
	static int[] dj = { 1, -1, 0, 0, 0, 0 };

	static int sK, sI, sJ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inArr = br.readLine().split(" ");
		while (true) {
			int L = Integer.parseInt(inArr[0]);
			int R = Integer.parseInt(inArr[1]);
			int C = Integer.parseInt(inArr[2]);

			if (L == 0 && L == R && R == C) {
				break;
			} // program end

			map = new char[L][R][];

			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					map[k][i] = br.readLine().toCharArray();
					for (int j = 0; j < C; j++) {
						if (map[k][i][j] == 'S') {
							sK = k;
							sI = i;
							sJ = j;
						}
					}
				}
				br.readLine();
			}
			// end testcase input

			// solve
			int answer = process(new boolean[L][R][C]);
			if (answer == Integer.MIN_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + answer + " minute(s).");
			}

			inArr = br.readLine().split(" ");
		}
	}

	static int process(boolean[][][] visit) {
		int l = visit.length;
		int r = visit[0].length;
		int c = visit[0][0].length;

		visit[sK][sI][sJ] = true;
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(sK, sI, sJ, 0));
		while (!queue.isEmpty()) {
			Tuple tp = queue.poll();

			// 동서남북상하 탐색
			for (int m = 0; m < 6; m++) {
				int nk = tp.k + dk[m];
				int ni = tp.i + di[m];
				int nj = tp.j + dj[m];
				// 범위 벗어나면 안됨
				if (nk < 0 || ni < 0 || nj < 0 || nk >= l || ni >= r || nj >= c)
					continue;
				// 방문했거나 지나갈 수 없는 곳은 못감
				if (visit[nk][ni][nj] || map[nk][ni][nj] == '#')
					continue;
				// 탈출!
				if (map[nk][ni][nj] == 'E') {
					return tp.time + 1;
				}
				visit[nk][ni][nj] = true;
				queue.add(new Tuple(nk, ni, nj, tp.time + 1));
			}
		}
		// 위에서 반환이 안되었으면 탈출 못한 것
		return Integer.MIN_VALUE;
	}

}

class Tuple {
	int k, i, j, time;

	public Tuple(int k, int i, int j, int t) {
		this.k = k;
		this.i = i;
		this.j = j;
		this.time = t;
	}
}