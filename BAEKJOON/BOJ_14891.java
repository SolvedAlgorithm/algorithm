package bj14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Tuple>> chk;
	static int[][] gearWheel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gearWheel = new int[4][8];
		chk = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				gearWheel[i][j] = input.charAt(j) - '0';
			}
			chk.add(new ArrayList<Tuple>());
		}
		int n = Integer.parseInt(br.readLine());
		int[][] op = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] inArr = br.readLine().split(" ");
			op[i][0] = Integer.parseInt(inArr[0]) - 1;
			op[i][1] = Integer.parseInt(inArr[1]);
		}
		chk.get(0).add(new Tuple(2, 1, 6));
		chk.get(1).add(new Tuple(6, 0, 2));
		chk.get(1).add(new Tuple(2, 2, 6));
		chk.get(2).add(new Tuple(6, 1, 2));
		chk.get(2).add(new Tuple(2, 3, 6));
		chk.get(3).add(new Tuple(6, 2, 2));

		for (int i = 0; i < n; i++) {
			int[] operation = init();
			int wheel = op[i][0];
			int direction = op[i][1];
			operation[wheel] = direction;
			operation = spin_chk(wheel, direction, operation);
			for (int j = 0; j < 4; j++) {
				switch (operation[j]) {
				case 0:
					continue;
				case 1:
					clockwise(j);
					break;
				case -1:
					counterclockwise(j);
					break;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			if (gearWheel[i][0] == 1) {
				answer += (int) Math.pow(2, i);
			}
		}
		System.out.println(answer);

	}

	public static void clockwise(int wheelN) {
		int temp = gearWheel[wheelN][7];
		for (int i = 7; i > 0; i--) {
			gearWheel[wheelN][i] = gearWheel[wheelN][i - 1];
		}
		gearWheel[wheelN][0] = temp;
	}

	public static void counterclockwise(int wheelN) {
		int temp = gearWheel[wheelN][0];
		for (int i = 0; i < 7; i++) {
			gearWheel[wheelN][i] = gearWheel[wheelN][i + 1];
		}
		gearWheel[wheelN][7] = temp;
	}

	public static int[] init() {
		int[] operation = new int[4];
		for (int i = 0; i < 4; i++) {
			operation[i] = 0;
		}
		return operation;
	}

	public static int[] spin_chk(int wheel, int direction, int[] operation) {
		ArrayList<Tuple> chk_wheel = chk.get(wheel);
		for (int j = 0; j < chk_wheel.size(); j++) {
			Tuple a = chk_wheel.get(j);
			if (gearWheel[wheel][a.id] != gearWheel[a.wheelN][a.idN] && operation[a.wheelN] == 0) {
				operation[a.wheelN] = -direction;
				spin_chk(a.wheelN, -direction, operation);
			}
		}
		return operation;
	}

}

class Tuple {
	int id, wheelN, idN;

	public Tuple(int i, int w, int n) {
		this.id = i;
		this.wheelN = w;
		this.idN = n;
	}

}
