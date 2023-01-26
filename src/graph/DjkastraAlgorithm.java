package graph;

import java.util.List;
import java.util.PriorityQueue;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=32
 * 
 * https://takeuforward.org/data-structure/g-35-print-shortest-path-dijkstras-algorithm/
 */
public class DjkastraAlgorithm {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int v = 3;
		int s = 2;
		List<List<List<Integer>>> adj = List.of(List.of(List.of(1, 1), List.of(2, 6)),
				List.of(List.of(2, 3), List.of(0, 1)), List.of(List.of(1, 3), List.of(0, 6)));
		int[] dis = new int[v];
		// setting all the values to infinity
		for (int i = 0; i < v; i++)
			dis[i] = Integer.MAX_VALUE;
		// distance from source to source is 0
		dis[s] = 0;

		// in queue we will store the next point and distance to source
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1[1], pair2[1]));
		minHeap.offer(new int[] { s, 0 });

		while (!minHeap.isEmpty()) {
			int[] pair = minHeap.poll();
			int source = pair[0];
			int prevDistance = pair[1];
			
			
		}
	}

}
