package bj4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int r = Integer.parseInt(inArr[0]);
		int c = Integer.parseInt(inArr[1]);
		char[][] map = new char[r][c];
		boolean[][] visit = new boolean[r][c];
		Queue<Tuple> fire = new LinkedList<>();
		Queue<Tuple> jh = new LinkedList<>();
		boolean flag = false;
		int answer = -1;

		for (int i = 0; i < r; i++) {
			String temp = br.readLine();
			for (int j = 0; j < c; j++) {
				char ch = temp.charAt(j);
				map[i][j] = ch;
				if (ch == '.') {
					visit[i][j] = true;
				} else {
					visit[i][j] = false;
				}
				if (ch == 'J') {
					jh.add(new Tuple(i, j, 0));
					if (i == r - 1 || i == 0 || j == c - 1 || j == c) {
						flag = true;
						answer = 1;
					}
				} else if (ch == 'F') {
					fire.add(new Tuple(i, j, 0));
				}
			}
		}
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int fire_prev = 0;
		int jh_prev = 0;
		while (!fire.isEmpty() || !jh.isEmpty()) {
			if (flag) {
				break;
			}
			// 불을 먼저 이동
			while (!fire.isEmpty()) {
				if (fire.peek().cnt != fire_prev) {
					fire_prev++;
					break;
				}
				Tuple tuple = fire.poll();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						int newX = tuple.x + dx[i];
						int newY = tuple.y + dy[i];
						if (newX >= r || newX < 0 || newY >= c || newY < 0) {
							continue;
						}
						if (!visit[newX][newY]) {
							continue;
						}
						fire.add(new Tuple(newX, newY, tuple.cnt + 1));
						visit[newX][newY] = false;
					}
				}

			}
			if (cannot_move(visit, r, c)) {
				break;
			}
			// 지훈이 이동
			while (!jh.isEmpty()) {
				if (jh.peek().cnt != jh_prev) {
					jh_prev++;
					break;
				}
				Tuple tuple = jh.poll();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						int newX = tuple.x + dx[i];
						int newY = tuple.y + dy[i];
						if (newX >= r || newX < 0 || newY >= c || newY < 0) {
							continue;
						}
						if (!visit[newX][newY]) {
							continue;
						}
						if (newX == 0 || newX == r - 1 || newY == 0 || newY == c - 1) {
							flag = true;
							answer = tuple.cnt + 2;
							break;
						}
						jh.add(new Tuple(newX, newY, tuple.cnt + 1));
						
						visit[newX][newY] = false;
					}
					if (flag) {
						break;
					}
				}
				if (flag) {
					break;
				}
			}
		}
		if (flag) {
			System.out.println(answer);
		} else {
			System.out.println("IMPOSSIBLE");
		}

	}

	public static boolean cannot_move(boolean[][] visit, int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (visit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}

class Tuple {
	int x, y, cnt;

	public Tuple(int a, int b, int c) {
		this.x = a;
		this.y = b;
		this.cnt = c;
	}
}