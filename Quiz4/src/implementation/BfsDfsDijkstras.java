package implementation;

/*
 *  
 *  Provide your answers in the variables and arrays below. 
 *  Read the comments as they will specify what you need to 
 *  do. Run main() to verify the answers you have provided.
 * 
 *  For BFS and DFS you must use the algorithms discussed in
 *  lecture where a stack or queue is used.  You MUST use 
 *  alphabetical order when adding nodes to the stack or queue,
 *  otherwise you will not pass secret tests.
 * 
 */

public class BfsDfsDijkstras {
	// Provide the Breadth first search result in the following variable
	// Replace "UPDATEWITHYOURANSWER" with your answer
	public static String BREADTH_FIRST_SEARCH = "FBACED";
	
	// Provide the Depth first search result in the following variable
	// Replace "UPDATEWITHYOURANSWER" with your answer
	public static String DEPTH_FIRST_SEARCH = "EFBACD";
	
	// Dijkstra's answers will be provided next.  A cost of -1 represents infinity and
	// a predecessor of "-" represents no predecessor. We have used the value -9 for costs
	// so the code compiles, but you must update that value to a cost or -1. Similarly, 
	// we have initialized predecessors with "*", but you must update entries with the 
	// expected predecessor or no predecessor ("-").  If you leave the -9 and the "*" the
	// answers will be considered wrong.
	
	// Table1: Update the following variables with values after processing one node
	// Do not forget to initialize TABLE1_PROCESSING_NODE with the appropriate node
	// Replace "UPDATEWITHYOURANSWER" with your answer
	public static String TABLE1_PROCESSING_NODE          = "C";
	//                                                        "A", "B", "C", "D", "E", "F"	
	public static int[]  TABLE1_DIJKSTRAS_COST           = {   -1,  -1,  0,  2,  9,  -1};
	public static String[]  TABLE1_DIJKSTRAS_PREDECESSOR = {  "-", "-", "-", "C", "C", "-"};
	
	
	// Table2: Update the following variables with values after processing two nodes
	// Do not forget to initialize TABLE2_PROCESSING_NODE with the appropriate node
	// Replace "UPDATEWITHYOURANSWER" with your answer
	public static String TABLE2_PROCESSING_NODE          = "D";
	//                                                        "A", "B", "C", "D", "E", "F"	
	public static int[]  TABLE2_DIJKSTRAS_COST           = {   -1,  -1,  0,  2,  4,  -1};
	public static String[]  TABLE2_DIJKSTRAS_PREDECESSOR = {  "-", "-", "-", "C", "D", "-"};
	
	
	// Table3: Update the following variables with values after processing three nodes
	// Do not forget to initialize TABLE3_PROCESSING_NODE with the appropriate node
	// Replace "UPDATEWITHYOURANSWER" with your answer
	public static String TABLE3_PROCESSING_NODE          = "E";
	//                                                       "A", "B", "C", "D", "E", "F"	
	public static int[]  TABLE3_DIJKSTRAS_COST           = {  -1,  -1,  0,  2,  4,  7};
	public static String[]  TABLE3_DIJKSTRAS_PREDECESSOR = { "-", "-", "-", "C", "D", "E"};

	
	/* ****** DO NOT CHANGE NOR MODIFY ANYTHING FROM THIS POINT ON ****** */
	
	
	public static void main(String[] args) {
		String answer = "\nYour answers are:\n";
		answer += "\nBreadthFirstSearch Answer: \"" + BREADTH_FIRST_SEARCH + "\"";
		
		answer += " and number of vertices: " + BREADTH_FIRST_SEARCH.length() + "\n";
		answer += "DepthFirstSearch Answer: \"" + DEPTH_FIRST_SEARCH + "\"";
		answer += " and number of vertices: " + DEPTH_FIRST_SEARCH.length() + "\n";
		System.out.println(answer);

		System.out.println("Dijktra's Answers");
		printTable("Table1", TABLE1_PROCESSING_NODE, DIJKSTRAS_NODES, TABLE1_DIJKSTRAS_COST, TABLE1_DIJKSTRAS_PREDECESSOR);
		printTable("Table2", TABLE2_PROCESSING_NODE, DIJKSTRAS_NODES, TABLE2_DIJKSTRAS_COST, TABLE2_DIJKSTRAS_PREDECESSOR);
		printTable("Table3", TABLE3_PROCESSING_NODE, DIJKSTRAS_NODES, TABLE3_DIJKSTRAS_COST, TABLE3_DIJKSTRAS_PREDECESSOR);
	}
	
	public static String[] DIJKSTRAS_NODES       	     = { "A", "B", "C", "D", "E", "F"}; 
	
	public static void printTable(String tableLabel, String processingNode, String[] nodes, int[] costs, String[] predecessors) {
		System.out.println("\n" + tableLabel + " after processing node " + processingNode);
		
		/* Nodes */
		System.out.printf("%12s", "Node");
		for (String node : nodes) {
			System.out.printf("%4s", node);
		}
		System.out.println();
		
		System.out.printf("%12s", "Cost");
		/* Costs */
		for (int cost : costs) {
			System.out.printf("%4d", cost);
		}
		System.out.println();
		
		/* Predecessors */
		System.out.printf("%12s", "Predecessor");
		for (String predecessor : predecessors) {
			System.out.printf("%4s", predecessor);
		}
		System.out.println("\n\n");
	}
}
