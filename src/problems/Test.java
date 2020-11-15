package problems;

import advanced_structures.GraphUsingAdjList;

public class Test {

	public static void main(String[] args) {
		GraphUsingAdjList graph = new GraphUsingAdjList(4);
		graph.display();
		
		graph.addDirectedEdge(1, 3);
		graph.addUndirectedEdge(2, 3);
		graph.addDirectedWeightedEdge(3, 0, 5);
		graph.display();
		
		graph.addUndirectedWeightedEdge(2, 3, 5, 7);
		graph.display();
		
		graph.addUndirectedWeightedEdge(3, 0, 10);
		graph.display();
		
	}

}
