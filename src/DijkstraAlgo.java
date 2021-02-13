import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DijkstraAlgo {
	
	int[] dist;
	boolean[] visited;
	
	DijkstraAlgo(int size) {
		
		dist = new int[size];
		visited = new boolean[size];
		
		for(int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
	}
	
	
	int[] dijkstraAlgo(int index, Graph graph) {
		
		List<ArrayList<HashMap<Integer, Integer>>> arr = graph.getList();
		PriorityQueue pq = new PriorityQueue();
		
		dist[index] = 0;
		pq.push(index, dist[index]);
		
		while(pq.getSize() > 0) {
			
			HashMap<Integer, Integer> last = pq.deleteNode();
			int val = (int) last.keySet().toArray()[0];
			visited[val] = true;
			
			for(HashMap<Integer, Integer> map : arr.get(val)) {
				int key = (int) map.keySet().toArray()[0];
				int newDistance = map.get(key) + dist[val];
				int oldDistance = dist[key];
				
				if(!visited[key]) {
					if(newDistance < oldDistance) {
						dist[key] = newDistance;
					}
					pq.push(key, dist[key]);
				}
			}
		}
		
		return dist;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DijkstraAlgo algo = new DijkstraAlgo(7);
		Graph graph = new Graph(7);
		graph.addEdge(0, 2, 4);
		graph.addEdge(0, 2, 2);
		graph.addEdge(2, 1, 8);
		graph.addEdge(2, 5, 1);
		graph.addEdge(5, 6, 1);
		graph.addEdge(6, 5, 1);
		graph.addEdge(3, 1, 1);
		graph.addEdge(0, 4, 3);
		graph.addEdge(2, 3, 1);
		graph.addEdge(4, 6, 4);
		
		long startTime = System.nanoTime();
		
		int[] dist = algo.dijkstraAlgo(0, graph);
		
		for(int i = 0; i < dist.length; i++) {
			System.out.println("From 0 to " + i + " ; Distance: " + dist[i]);
		}
		
		long endTime = System.nanoTime() - startTime;
		System.out.println("Total time of execution: " + (float) endTime/1_000_000_000 + " seconds.");
		
	}
}
