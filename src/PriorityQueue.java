import java.util.HashMap;

class Node {
	int val;
	Node next = null;
	int priority;
	
	public Node(int val, int prio) {
		this.val = val;
		this.priority = prio;
	}
}

public class PriorityQueue {
	int size = 0;
	
	Node head = null;
	
	public Node addNode(int val, int prio) {
		Node node = new Node(val, prio);
		size++;
		return node;
	}
	
	public HashMap<Integer, Integer> getHead() {
		HashMap<Integer, Integer> hash = new HashMap<>();
		hash.put(head.val, head.priority);
		return hash;
	}
	
	public Node push(int val, int prio) {
		Node newNode = addNode(val, prio);
		
		
		if(head == null) {
			head = newNode;
		} else {
			
			if(head.priority > prio) {
				newNode.next = head;
				head = newNode;
			}
			Node start = head;
			while(start.next != null && start.next.priority < prio) {
				start = start.next;
			}
			Node temp = start.next;
			start.next = newNode;
			newNode.next = temp;
			
		}
		
		return newNode;
		
	}
	
	int getSize() {
		return size;
	}
	
	
	public HashMap<Integer, Integer> deleteNode() {
		HashMap<Integer, Integer> hash = new HashMap<>();
		if(size == 0 ) {
			return hash;
		}
		hash.put(head.val, head.priority);
		head = head.next;
		size--;
		return hash;
		
	}
	
	public void printQueue() {
		Node start = head;
		while(start.next != null) {
			System.out.print(start.val + ", " + start.priority);
			System.out.println();
			start = start.next;
		}
		System.out.print(start.val + ", " + start.priority);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue pq = new PriorityQueue();
		pq.push(3, 2);
		pq.push(5, 1);
		pq.push(4, 856);
		pq.push(7, 5);
		pq.push(9, 6);
		pq.push(12, 34);
		pq.deleteNode();
		pq.push(3, 64);
		pq.deleteNode();
		pq.deleteNode();
		pq.deleteNode();
		pq.deleteNode();
		pq.deleteNode();
		pq.deleteNode();
		pq.deleteNode();
		pq.deleteNode();
		//pq.printQueue();
		System.out.println(pq.getSize());
		
	}

}
