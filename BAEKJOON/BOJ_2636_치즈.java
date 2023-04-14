package boj2636;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 치즈가 없는 칸을 기준으로 BFS
 * 만약 더 이상 나아갈 수 없는 이유가 모두 치즈 때문이라면 치즈 속 공간임을 의미 -> 그때 만난 치즈는 없애지 않는다.
 * */

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<Point> cheese;
	static boolean[][] visit;

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int prev = count();
		int cnt = 0;
		while (prev != 0) {
			cheese = new ArrayList<>();
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visit[i][j])
						continue;
					if (map[i][j] == 0) {
						BFS(i, j);
					}
				}
			}
			for (int p = 0; p < cheese.size(); p++) {
				Point pnt = cheese.get(p);
				map[pnt.i][pnt.j] = 0;
			}
			cnt++;
			int temp = count();
			if (temp == 0) {
				break;
			}
			prev = temp;
		}
		System.out.println(cnt);
		System.out.println(prev);
	}

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };

	public static void BFS(int i, int j) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(i, j));
		visit[i][j] = true;
		boolean chk = true;
		ArrayList<Point> list = new ArrayList<>();
		while (!q.isEmpty()) {
			Point pnt = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = pnt.i + di[k];
				int nj = pnt.j + dj[k];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
					chk = false;
					continue;
				}
				if (visit[ni][nj])
					continue;
				if (map[ni][nj] == 1) {
					visit[ni][nj] = true;
					list.add(new Point(ni, nj));
					continue;
				}
				q.add(new Point(ni, nj));
				visit[ni][nj] = true;
			}
		}
		if (!chk) {
			for (int p = 0; p < list.size(); p++) {
				cheese.add(list.get(p));
			}
		}
	}

	public static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
