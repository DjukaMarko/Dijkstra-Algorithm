import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

	public List<ArrayList<HashMap<Integer, Integer>>> list = new ArrayList<>();
	
	Graph(int size){
		for(int i = 0; i < size; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	
	public List<ArrayList<HashMap<Integer, Integer>>> addEdge(int v, int key, int val) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(key, val);
		list.get(v).add(map);
		
		return list;
	}
	
	List<ArrayList<HashMap<Integer, Integer>>> getList() {
		return list;
	}
	
	public void printList() {
		for(ArrayList<HashMap<Integer, Integer>> el: list) {
			System.out.println(el);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(5);
		g.addEdge(0, 1 ,2);
		g.addEdge(0, 6, 3);
		g.addEdge(1, 3, 4);
		g.printList();
	}

}
