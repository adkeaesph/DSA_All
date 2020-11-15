package problems;

import advanced_structures.*;
import java.util.*;
import java.util.Map.Entry;

import advanced_structures.AdjacentDestinationVertex;
public class Kcore {

	public static GraphUsingSTL KcoreProblem(GraphUsingSTL g, int k) {
		while (true) {
			Map<String, Set<AdjacentDestinationVertex>> adjList = g.getAdjacencyList();
			Iterator<Entry<String, Set<AdjacentDestinationVertex>>> it = adjList.entrySet().iterator();
			boolean allNodesHaveDegreeMoreThanOrEqualK = true;
			List<String> setOfVertices = new ArrayList<>();
			while (it.hasNext()) {
				Entry<String, Set<AdjacentDestinationVertex>> entry = it.next();
				if (entry.getValue().size() < k) {
					allNodesHaveDegreeMoreThanOrEqualK = false;
					setOfVertices.add(entry.getKey()); 
				}
			}
			for(int i=0;i<setOfVertices.size();i++)
				g.deleteNode(setOfVertices.get(i));
			if (allNodesHaveDegreeMoreThanOrEqualK)
				break;
		}
		
		return g;
	}
	
	public static void main(String[] args) {
		

	}

}
