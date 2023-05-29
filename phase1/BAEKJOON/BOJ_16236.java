package bj16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		Fish BabyShark = new Fish(0, 0, 2, 0);

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 9) {
					BabyShark = new Fish(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		int time = 0;
		while (true) {
			boolean[][] visit = init(n);
			Location move = bfs(n, BabyShark.loc.x, BabyShark.loc.y, BabyShark.size, map, visit);
			if (move.x == -1) {
				break;
			}
			BabyShark.loc.x = move.x;
			BabyShark.loc.y = move.y;
			BabyShark.cnt++;
			if (BabyShark.cnt == BabyShark.size) {
				BabyShark.size++;
				BabyShark.cnt = 0;
			}
			time += move.dist;
		}
		System.out.println(time);
	}

	public static boolean[][] init(int n) {
		boolean[][] visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = false;
			}
		}
		return visit;
	}

	public static Location bfs(int n, int x, int y, int size, int[][] map, boolean[][] visit) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		LinkedList<Location> eatable = new LinkedList<>();
		Queue<Location> queue = new LinkedList<>();
		visit[x][y] = true;
		queue.add(new Location(x, y, 0));
		int chk = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Location pop = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = pop.x + dx[i];
				int newY = pop.y + dy[i];
				if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
					continue;
				}
				if (visit[newX][newY] || map[newX][newY] > size) {
					continue;
				}
				visit[newX][newY] = true;
				if (map[newX][newY] == size || map[newX][newY] == 0) {
					queue.add(new Location(newX, newY, pop.dist + 1));
				} else {
					if (chk > pop.dist + 1) {
						chk = pop.dist + 1;
						eatable.add(new Location(newX, newY, pop.dist + 1));
					} else if (chk == pop.dist + 1) {
						eatable.add(new Location(newX, newY, pop.dist + 1));
					}
				}
			}
		}
		if (eatable.isEmpty()) {
			return new Location(-1, -1);
		}
		Collections.sort(eatable);
		Location result = eatable.get(0);
		map[result.x][result.y] = 0;
		return result;
	}

}

class Location implements Comparable<Location> {
	int x, y, dist;

	public Location(int a, int b) {
		this.x = a;
		this.y = b;
		this.dist = 0;
	}

	public Location(int a, int b, int d) {
		this.x = a;
		this.y = b;
		this.dist = d;
	}

	public int compareTo(Location oth) {
		if (this.dist > oth.dist) {
			return 1;
		} else if (this.dist < oth.dist) {
			return -1;
		} else {
			if (this.x > oth.x) {
				return 1;
			} else if (this.x < oth.x) {
				return -1;
			} else {
				if (this.y > oth.y) {
					return 1;
				} else if (this.y < oth.y) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
}

class Fish {
	Location loc;
	int size, cnt;

	public Fish(int a, int b, int s) {
		this.loc = new Location(a, b);
		this.size = s;
	}

	public Fish(int a, int b, int s, int c) {
		this.loc = new Location(a, b);
		this.size = s;
		this.cnt = c;
	}

}