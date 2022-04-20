package bj17396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);
		boolean[] hide = new boolean[n];
		long[] distance = new long[n];
		ArrayList<ArrayList<Tuple>> map = new ArrayList<>();
		inArr = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			if(Integer.parseInt(inArr[i]) == 0) {
				hide[i] = true;
			}else {
				hide[i] = false;
			}
			distance[i] = Long.MAX_VALUE;
			map.add(new ArrayList<Tuple>());
		}
		
		for(int i = 0; i < m; i++) {
			inArr = br.readLine().split(" ");
			int a = Integer.parseInt(inArr[0]);
			int b = Integer.parseInt(inArr[1]);
			long c = Long.parseLong(inArr[2]);
			map.get(a).add(new Tuple(b, c));
			map.get(b).add(new Tuple(a, c));
		}
		
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		distance[0] = 0;
		pq.add(new Tuple(0, 0));
		while(!pq.isEmpty()) {
			Tuple pop = pq.poll();
			int cur = pop.node;
			long dist = pop.cost;
			if(distance[cur] < dist) {
				continue;
			}
			
			int size = map.get(cur).size();
			for(int i = 0; i < size; i++) {
				Tuple getT = map.get(cur).get(i);
				if(!hide[getT.node] && getT.node != n-1) {
					continue;
				}
				if(distance[getT.node] > dist + getT.cost) {
					distance[getT.node] = dist + getT.cost;
					pq.add(new Tuple(getT.node, distance[getT.node]));
				}
				
			}
			
		}
		if(distance[n-1] == Long.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(distance[n-1]);
		}
		
	}

}

class Tuple implements Comparable<Tuple>{
	int node;
	long cost;
	public Tuple(int n, long c) {
		this.node = n; 
		this.cost = c;
	}
	
	public int compareTo(Tuple oth) {
		if(this.cost > oth.cost) {
			return 1;
		}else if(this.cost == oth.cost) {
			return 0;
		}else {
			return -1;
		}
	}
}
