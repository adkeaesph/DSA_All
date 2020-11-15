package advanced_structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class GraphUsingSTL {
	private Map<String, Set<AdjacentDestinationVertex>> adjacencyList;
	
	public GraphUsingSTL() {
		adjacencyList = new HashMap<>();
	}
	
	public GraphUsingSTL(int numberOfVertices) {
		this();
		for(int i=0;i<numberOfVertices;i++)
			adjacencyList.put(""+i, new HashSet<>());
	}
	
	public GraphUsingSTL(List<String> vertices) {
		this();
		for(int i=0;i<vertices.size();i++)
			adjacencyList.put(vertices.get(i), new HashSet<>());
	}

	public Map<String, Set<AdjacentDestinationVertex>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<String, Set<AdjacentDestinationVertex>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public void addNode(String nameOfVertex) {
		adjacencyList.put(nameOfVertex, new HashSet<>());
	}
	
	public void deleteNode(String nameOfVertex) {
		adjacencyList.remove(nameOfVertex);
		Iterator<Entry<String, Set<AdjacentDestinationVertex>>> it = adjacencyList.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, Set<AdjacentDestinationVertex>> entry = it.next();
			Set<AdjacentDestinationVertex> value = entry.getValue();
			value.remove(new AdjacentDestinationVertex(nameOfVertex));
		}
	}
	
	public void addDirectedEdge(String srcVertexName, String dstnVertexName) {
		Iterator<Entry<String,Set<AdjacentDestinationVertex>>> it = adjacencyList.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,Set<AdjacentDestinationVertex>> entry = it.next();
			if(entry.getKey().equals(srcVertexName)) {
				entry.getValue().add(new AdjacentDestinationVertex(dstnVertexName));
				break;
			}
		}
	}
	
	public void addUndirectedEdge(String srcVertexName, String dstnVertexName) {
		addDirectedEdge(srcVertexName, dstnVertexName);
		addDirectedEdge(dstnVertexName, srcVertexName);
	}
	
	public void addDirectedWeightedEdge(String srcVertexName, String dstnVertexName, int weight_src_to_dstn) {
		Iterator<Entry<String,Set<AdjacentDestinationVertex>>> it = adjacencyList.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,Set<AdjacentDestinationVertex>> entry = it.next();
			if(entry.getKey().equals(srcVertexName)) {
				entry.getValue().remove(new AdjacentDestinationVertex(dstnVertexName));
				entry.getValue().add(new AdjacentDestinationVertex(dstnVertexName, weight_src_to_dstn));
				break;
			}
		}
	}
	
	public void addUndirectedWeightedEdge(String srcVertexName, String dstnVertexName, int weight_src_to_dstn, int weight_dstn_to_src) {
		addDirectedWeightedEdge(srcVertexName, dstnVertexName, weight_src_to_dstn);
		addDirectedWeightedEdge(dstnVertexName, srcVertexName, weight_dstn_to_src);
	}
	
	public void addUndirectedWeightedEdge(String srcVertexName, String dstnVertexName, int bi_directional_same_weight) {
		addUndirectedWeightedEdge(srcVertexName, dstnVertexName, bi_directional_same_weight, bi_directional_same_weight);
	}
	
	public void deleteDirectedEdge(String srcVertexName, String dstnVertexName) {
		Iterator<Entry<String,Set<AdjacentDestinationVertex>>> it = adjacencyList.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,Set<AdjacentDestinationVertex>> entry = it.next();
			if(entry.getKey().equals(srcVertexName)) {
				entry.getValue().remove(new AdjacentDestinationVertex(dstnVertexName));
				break;
			}
		}
	}
	
	public void deleteUndirectedEdge(String srcVertexName, String dstnVertexName) {
		deleteDirectedEdge(srcVertexName, dstnVertexName);
		deleteDirectedEdge(dstnVertexName, srcVertexName);
	}
	
	public void display() {
		System.out.println();
		System.out.println("-----------------Adjacency List----------------");
		Iterator<Entry<String,Set<AdjacentDestinationVertex>>> it = adjacencyList.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String,Set<AdjacentDestinationVertex>> entry = it.next();
			System.out.print(entry.getKey());
			Set<AdjacentDestinationVertex> value = entry.getValue();
			Iterator<AdjacentDestinationVertex> jt = value.iterator();
			while(jt.hasNext()) {
				System.out.print("  ->  "+jt.next());
			}
			System.out.println();
		}
	}
}
