package boj17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 섬을 indexing 한다.
 * 섬 번호를 기준으로 수직, 수평으로 이어지는 edge를 그려 graph를 그린다.
 * prim 알고리즘으로 MST를 구한다.
 * */

public class Main {
	static int N, M, Cnt;
	static int[][] Map, Graph;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[] id = { 0, 1 };
	static int[] jd = { 1, 0 };

	static class Point implements Comparable<Point> {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}

		@Override
		public int compareTo(Point o) {
			return this.j - o.j;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");

		N = Integer.parseInt(inArr[0]);
		M = Integer.parseInt(inArr[1]);
		Map = new int[N][M];
		for (int i = 0; i < N; i++) {
			inArr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(inArr[j]);
			}
		} // end input

		// 섬 구하기
		island();
		// 그래프 그리기
		Graph = new int[Cnt + 1][Cnt + 1];
		for (int i = 0; i < Cnt + 1; i++) {
			Arrays.fill(Graph[i], Integer.MAX_VALUE);
		}
		drawGraph();

		// prim 알고리즘. MST
		boolean[] check = new boolean[Cnt + 1];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		check[1] = true;
		for (int i = 2; i < Cnt + 1; i++) {
			if (Graph[1][i] != Integer.MAX_VALUE) {
				pq.add(new Point(i, Graph[1][i]));
			}
		}
		int count = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			Point pnt = pq.poll();
			if (check[pnt.i])
				continue;
			count++;
			check[pnt.i] = true;
			sum += pnt.j;
			if (count == Cnt)
				break;
			for (int k = 1; k < Cnt + 1; k++) {
				if (Graph[pnt.i][k] != Integer.MAX_VALUE) {
					pq.add(new Point(k, Graph[pnt.i][k]));
				}
			}
		}
		if (all(check)) {
			System.out.println(sum);
		} else {
			System.out.println(-1);
		}
	}

	// 섬에 index를 부여한다.
	// 섬을 이루는 좌표들의 Map 값을 각 섬의 index 값으로 저장한다.
	static void island() {
		boolean[][] visit = new boolean[N][M];
		Cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j])
					continue;
				if (Map[i][j] == 1) {
					Cnt++;
					Queue<Point> queue = new ArrayDeque<>();
					queue.add(new Point(i, j));
					visit[i][j] = true;
					Map[i][j] = Cnt;

					while (!queue.isEmpty()) {
						Point pnt = queue.poll();
						for (int k = 0; k < 4; k++) {
							int ni = pnt.i + di[k];
							int nj = pnt.j + dj[k];

							if (ni < 0 || nj < 0 || ni >= N || nj >= M)
								continue;
							if (visit[ni][nj] || Map[ni][nj] == 0)
								continue;
							visit[ni][nj] = true;
							Map[ni][nj] = Cnt;
							queue.add(new Point(ni, nj));
						}
					}
				}
			}
		}
	}

	// 섬들로 그래프를 그린다.
	static void drawGraph() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] > 0) {
					for (int k = 0; k < 2; k++) {
						int ni = i;
						int nj = j;
						int dist = 0;
						int near = -1;
						while (true) {
							ni += id[k];
							nj += jd[k];
							if (ni >= N || nj >= M)
								break;
							if (Map[ni][nj] != 0) {
								if (Map[ni][nj] != Map[i][j]) {
									near = Map[ni][nj];
								}
								break;
							}
							dist++;
						}
						if (near > 0) {
							if (dist > 1) {
								Graph[near][Map[i][j]] = Math.min(dist, Graph[near][Map[i][j]]);
								Graph[Map[i][j]][near] = Math.min(dist, Graph[Map[i][j]][near]);
							}
						}
					}
				}
			}
		}
	}

	static boolean all(boolean[] check) {
		for (int i = 1; i < check.length; i++) {
			if (!check[i])
				return false;
		}
		return true;
	}

	static void print(int[][] arr) {
		System.out.println("------------------------------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("------------------------------------");
	}
}
