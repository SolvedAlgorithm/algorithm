package bj16956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();
		String[] str2int = str.split(" ");
		int R = Integer.parseInt(str2int[0]);
		int C = Integer.parseInt(str2int[1]);

		String[] Map = new String[R];
		for (int i = 0; i < R; i++) {
			Map[i] = bf.readLine();
		}
		answer(Map, R, C);
	}

	public static void answer(String[] Map, int R, int C) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		LinkedList<Coordinate> wolf = new LinkedList<>();
		for (int n = 0; n < R * C; n++) {
			int r = n / C;
			int c = n % C;
			if (Map[r].charAt(c) == 'W') {
				wolf.add(new Coordinate(r, c));
				for (int i = 0; i < 4; i++) {
					int newR = r + dx[i];
					int newC = c + dy[i];
					if (newR < 0 || newR >= R || newC < 0 || newC >= C) {
						continue;
					}
					if (Map[newR].charAt(newC) == 'S') {
						System.out.println(0);
						return;
					}
				}
			}
		}
		if (wolf.size() == 0) {
			System.out.println(1);
			for (int i = 0; i < R; i++) {
				System.out.println(Map[i]);
			}
			return;
		}
		while (!wolf.isEmpty()) {
			Coordinate coor = wolf.poll();
			for (int i = 0; i < 4; i++) {
				int newR = coor.x + dx[i];
				int newC = coor.y + dy[i];
				if (newR < 0 || newR >= R || newC < 0 || newC >= C) {
					continue;
				}
				if (Map[newR].charAt(newC) == '.') {
					String temp = Map[newR];
					Map[newR] = temp.substring(0, newC) + 'D' + temp.substring(newC + 1);
				}
			}
		}
		System.out.println(1);
		for (int i = 0; i < R; i++) {
			System.out.println(Map[i]);
		}
		return;
	}
}

class Coordinate {
	int x, y;

	public Coordinate(int a, int b) {
		this.x = a;
		this.y = b;
	}
}