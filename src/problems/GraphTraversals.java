package problems;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import advanced_structures.GraphUsingAdjList;
import advanced_structures.GraphUsingSTL;
import core_structure.*;

public class GraphTraversals {

	public static void BFSTraversal(GraphUsingAdjList graph, int motherVertex) {
		
		Set<Integer> visitedNodes = new LinkedHashSet<>();
		visitedNodes.add(motherVertex);
		Iterator<Integer> it = visitedNodes.iterator();
		int j=0;
		while(it.hasNext()) {
			System.out.println("iteration = " + j);
			Integer initialVertex = it.next();
			GraphNode<Integer> temp = null;
			
			for(int i=0;i<graph.getHead_nodes().size();i++) {
				if(graph.getHead_nodes().get(i).getData() == initialVertex) {
					temp = graph.getHead_nodes().get(i);
					break;
				}
			}
			while(temp.getNext()!=null) {
				if(!visitedNodes.contains(temp.getNext().getData()))
					visitedNodes.add(temp.getNext().getData());
				temp = temp.getNext();
			}
			j++;
			it = visitedNodes.iterator();
			for(int i = 0;i<j;i++)
				it.next();
		}
		
		System.out.println("BFS Traversal");
		it = visitedNodes.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
	public static void recursiveDFSHelper(int initialVertex, Set<Integer> visitedNodes, GraphUsingAdjList graph) {
		for(int i=0;i<graph.getHead_nodes().size();i++) {
			if(graph.getHead_nodes().get(i).getData() == initialVertex) {
				GraphNode<Integer> temp = graph.getHead_nodes().get(i);
				while(temp.getNext()!=null) {
					if(!visitedNodes.contains(temp.getNext().getData())) {
						int data = temp.getNext().getData();
						visitedNodes.add(data);
						recursiveDFSHelper(data, visitedNodes, graph);
					}
					temp = temp.getNext();
				}
				break;
			}
		}
	}
	public static void DFSTraversal(GraphUsingAdjList graph, int motherVertex) {
		Set<Integer> visitedNodes = new LinkedHashSet<>();
		visitedNodes.add(motherVertex);
		recursiveDFSHelper(motherVertex, visitedNodes, graph);
		System.out.println("DFS Traversal");
		Iterator<Integer> it = visitedNodes.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		GraphUsingAdjList g = new GraphUsingAdjList(4);
		g.addDirectedEdge(0, 1); 
	    g.addDirectedEdge(0, 2); 
	    g.addDirectedEdge(1, 2); 
	    g.addDirectedEdge(2, 0); 
	    g.addDirectedEdge(2, 3); 
	    g.addDirectedEdge(3, 3); 
		
	    BFSTraversal(g, 2);
	    DFSTraversal(g, 2);
	    
	    GraphUsingSTL g1 = new GraphUsingSTL(8);
	    g1.addDirectedEdge("0", "1");
	    g1.addDirectedEdge("1", "2");
	    g1.addDirectedEdge("1", "6");
	    g1.addDirectedEdge("6", "7");
	    g1.addDirectedEdge("2", "3");
	    g1.addDirectedEdge("2", "4");
	    g1.addDirectedEdge("4", "5");
	    g1.addDirectedEdge("5", "6");
	    g1.addDirectedEdge("7", "2");
	    
	    g1.display();
	    
	}

}
