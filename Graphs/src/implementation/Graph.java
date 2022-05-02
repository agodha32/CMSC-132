package implementation;

import java.util.*;

/**
 * Implements a graph. We use two maps: one map for adjacency properties 
 * (adjancencyMap) and one map (dataMap) to keep track of the data associated 
 * with a vertex. 
 * 
 * @author cmsc132
 * 
 * @param <E>
 */
public class Graph<E> {
	/* You must use the following maps in your implementation */
	private HashMap<String, HashMap<String, Integer>> adjacencyMap;
	/* You must use the following maps in your implementation */
	private HashMap<String, E> dataMap;
	
	public Graph() {
		
		this.adjacencyMap = new HashMap<String, HashMap<String, Integer>> ();
		this.dataMap = new HashMap<String, E> ();
		
	}
	
	public void addVertex(String vertexName, E data) throws IllegalArgumentException {
		
		this.adjacencyMap.put(vertexName, new HashMap<String, Integer> ());
		this.dataMap.put(vertexName, data);
		
	}
	
	public void addDirectedEdge(String startVertexName, String endVertexName, int cost) 
			throws IllegalArgumentException {
		
		this.adjacencyMap.get(startVertexName).put(endVertexName, cost);
		
	}
	
	public String toString() {
		
		String toReturn = "";
		
		TreeSet<String> vertices = (TreeSet<String>) getVertices();
		
		toReturn += "Vertices: " + vertices + "\nEdges:\n";
		
		for(String edge : vertices) {
			
			toReturn += "Vertex(" + edge + ")--->" + this.adjacencyMap.get(edge) + "\n";
			
		}
		
		return toReturn;
		
	}
	
	public Map<String, Integer> getAdjacentVertices(String vertexName) {
		
		return this.adjacencyMap.get(vertexName);
		
	}
	
	public int getCost(String startVertexName, String endVertexName) 
			throws IllegalArgumentException {
		
		return this.adjacencyMap.get(startVertexName).get(endVertexName);
		
	}
	
	public Set<String> getVertices() {
		
		return new TreeSet<String> (this.dataMap.keySet());
		
	}
	
	public E getData(String vertex) throws IllegalArgumentException {
		
		return this.dataMap.get(vertex);
		
	}
	
	public void doDepthFirstSearch(String startVertexName, CallBack<E> callback) 
			throws IllegalArgumentException {
		
		TreeSet<String> visited = new TreeSet<String> ();
		Stack<String> discovered = new Stack<String> ();
		
		discovered.add(startVertexName);
		
		while(!(discovered.isEmpty())) {

			String exist = discovered.lastElement();
			discovered.remove(discovered.lastElement());
			
			if(!(visited.contains(exist))) {
				
				visited.add(exist);
				callback.processVertex(exist, this.dataMap.get(exist));

				HashMap<String, Integer> keySet = this.adjacencyMap.get(exist);
				Set<String> keyset = keySet.keySet();
				
				
				for(String check : keyset) {
					
					if(!(visited.contains(check))) {
						
						discovered.add(check);
						
					}
					
				}
				
			}
			
		}
		
		
	}
	
	public void doBreadthFirstSearch(String startVertexName, CallBack<E> callback) 
			throws IllegalArgumentException {
		
		TreeSet<String> visited = new TreeSet<String> ();
		Queue<String> discovered = new PriorityQueue<String> ();
		
		discovered.add(startVertexName);
		
		while(!(discovered.isEmpty())) {
			
			String exist = discovered.peek();
			discovered.remove(discovered.peek());
			
			if(!(visited.contains(exist))) {
				
				visited.add(exist);
				callback.processVertex(exist, this.dataMap.get(exist));

				HashMap<String, Integer> keySet = this.adjacencyMap.get(exist);
				Set<String> keyset = keySet.keySet();
				
				
				for(String check : keyset) {
					
					if(!(visited.contains(check))) {
						
						discovered.add(check);
						
					}
					
				}
				
			}
			
		}
		
		
	}

	
	public int doDijkstras(String startVertexName, String endVertexName, 
			ArrayList<String> shortestPath) {
				
		TreeSet<String> processed = new TreeSet<String>();
		TreeSet<String> unprocessed = new TreeSet<String>();
		
		unprocessed.add(startVertexName);
		
		TreeMap<String, TreeMap<Integer, String>> predecessor = new TreeMap<String, 
				TreeMap<Integer, String>>();
		
		for(String nodeName : this.dataMap.keySet()) {
			
			predecessor.put(nodeName, new TreeMap<Integer, String>());
			predecessor.get(nodeName).put(Integer.MAX_VALUE, "None");
			
		}
		
		
		
		predecessor.get(startVertexName).remove(Integer.MAX_VALUE);
		predecessor.get(startVertexName).put(0, startVertexName);
				
		while(!(unprocessed.isEmpty())) {
			
			int smallestCost = Integer.MAX_VALUE;
			String smallestCostName = null;
			
			for(String nodeName : unprocessed) {
				
				if(!(processed.contains(nodeName)) && 
						predecessor.get(nodeName).firstKey() < smallestCost) {
					
					smallestCost = predecessor.get(nodeName).firstKey();
					smallestCostName = nodeName;
					
				}
				
			}
			
			processed.add(smallestCostName);
			unprocessed.remove(smallestCostName);
			
		for(String smaller : this.adjacencyMap.get(smallestCostName).keySet()) {

			if(!(processed.contains(smaller))) {	
					
				unprocessed.add(smaller);
				
				if(predecessor.get(smallestCostName).firstKey() + 
						this.adjacencyMap.get(smallestCostName).get(smaller) < 
						predecessor.get(smaller).firstKey()) {
					
						predecessor.get(smaller).put(predecessor.get(smallestCostName).
							firstKey() + this.adjacencyMap.get(smallestCostName).
							get(smaller), smallestCostName);
					
						predecessor.get(smaller).remove(Integer.MAX_VALUE);
					
					}
				
				}
			}
			
		}
		
		for(String x : predecessor.keySet()) {
			
			if(predecessor.get(x).firstKey() == Integer.MAX_VALUE) {
			
				String name = predecessor.get(x).get(Integer.MAX_VALUE);
				predecessor.get(x).remove(Integer.MAX_VALUE);
				predecessor.get(x).put(-1, name);
			
			}
							
		}
		
		String nodeName = endVertexName;
		shortestPath.add(nodeName);			
		
		while(!(nodeName.equals(startVertexName))) {

		
			if(predecessor.get(nodeName).firstKey() != -1) {
		
				int num = predecessor.get(nodeName).firstKey();
				System.out.println(num + nodeName + "\n");
				nodeName = predecessor.get(nodeName).get(num);
				shortestPath.add(0, nodeName);
			
			} else {
			
				shortestPath.clear();
				shortestPath.add("None");
				break;
			
			}
			
		}
	
		return predecessor.get(endVertexName).firstKey();
		
	}
	
}