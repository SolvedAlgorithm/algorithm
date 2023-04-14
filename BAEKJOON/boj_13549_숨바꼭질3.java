package boj13549;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/*
 * 수빈이의 위치를 x라고 할 때
 * 수빈이가 x-1, x+1로 이동할 때는 1초가 걸리고 2*x로 이동할 때는 0초가 걸린다.
 * -> 수빈이가 K의 위치에 도달하는 최소 시간을 출력
 * 
 * BFS를 이용하였다.
 * 처음 수빈이의 위치 N과 0(경과 시간)을 큐에 넣어주었다.
 * 만약 큐에서 꺼낸 Tuple의 idx 값이 K와 같다면 ans를 update 해주고 (더 작은 것으로) continue. 그 다음 행동을 할 필요 없음
 * 방문체크를 int 배열로 해주었다. 만약 이전에 방문했을 때 걸린 시간보다 더 적은 시간에 방문할 수 있다면 방문을 할 수 있도록 해주어야 하기 때문에
 * 수빈이의 행동이 1초 혹은 0초가 걸리기 때문에 필요.
 * 
 * */

public class Main {
	static class Tuple {
		int idx, time;

		public Tuple(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		int ans = Integer.MAX_VALUE;
		Queue<Tuple> Q = new ArrayDeque<>();
		visit[N] = 0;
		Q.add(new Tuple(N, 0));
		while (!Q.isEmpty()) {
			Tuple tp = Q.poll();
			if (tp.idx == K) {
				ans = Math.min(ans, tp.time);
				continue;
			}
			if (tp.idx - 1 >= 0) {
				if (visit[tp.idx - 1] > tp.time + 1) {
					Q.add(new Tuple(tp.idx - 1, tp.time + 1));
					visit[tp.idx - 1] = tp.time + 1;
				}
			}
			if (tp.idx + 1 <= 100000) {
				if (visit[tp.idx + 1] > tp.time + 1) {
					Q.add(new Tuple(tp.idx + 1, tp.time + 1));
					visit[tp.idx + 1] = tp.time + 1;
				}
			}
			if (tp.idx * 2 <= 100000) {
				if (visit[tp.idx * 2] > tp.time) {
					Q.add(new Tuple(tp.idx * 2, tp.time));
					visit[tp.idx * 2] = tp.time;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
