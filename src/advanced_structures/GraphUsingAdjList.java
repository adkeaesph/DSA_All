package advanced_structures;

import java.util.ArrayList;
import java.util.List;

import core_structure.GraphNode;

public class GraphUsingAdjList {
	private List<GraphNode<Integer>> head_nodes; //so that I can have as many vertices as I want
	
	public GraphUsingAdjList() {
		
	}
	
	public GraphUsingAdjList(int vertices) {
		this();
		head_nodes = new ArrayList<>();
		for(int i=0;i<vertices;i++)
			head_nodes.add(new GraphNode<>(i));
	}
	
	public GraphUsingAdjList(List<Integer> vertices) {
		this();
		head_nodes = new ArrayList<>();
		for(int i=0;i<vertices.size();i++)
			head_nodes.add(new GraphNode<>(vertices.get(i)));
	}
	
	public List<GraphNode<Integer>> getHead_nodes() {
		return head_nodes;
	}

	public void setHead_nodes(List<GraphNode<Integer>> head_nodes) {
		this.head_nodes = head_nodes;
	}

	public void addNode() {
		int prev_size = head_nodes.size();
		head_nodes.add(new GraphNode<>(prev_size));
	}
	
	public void addDirectedEdge(int srcVertex, int dstnVertex) {
		GraphNode<Integer> temp = head_nodes.get(srcVertex);
		boolean edgeAlreadyExists = false;
		while(temp.getNext()!=null) {
			if(temp.getNext().getData() == dstnVertex) {
				edgeAlreadyExists = true;
				break;
			}
			temp = temp.getNext();
		}
		if(!edgeAlreadyExists)
			temp.setNext(new GraphNode<>(dstnVertex));
	}
	
	public void addUndirectedEdge(int srcVertex, int dstnVertex) {
		addDirectedEdge(srcVertex, dstnVertex);
		addDirectedEdge(dstnVertex, srcVertex);
	}
	
	public void addDirectedWeightedEdge(int srcVertex, int dstnVertex, int weight_src_to_dstn) {
		GraphNode<Integer> temp = head_nodes.get(srcVertex);
		boolean edgeAlreadyExists = false;
		while(temp.getNext()!=null) {
			if(temp.getNext().getData() == dstnVertex) {
				edgeAlreadyExists = true;
				break;
			}
			temp = temp.getNext();
		}
		if(!edgeAlreadyExists)
			temp.setNext(new GraphNode<>(dstnVertex, weight_src_to_dstn));
		else
			temp.getNext().setWeight(weight_src_to_dstn);
	}
	
	public void addUndirectedWeightedEdge(int srcVertex, int dstnVertex, int weight_src_to_dstn, int weight_dstn_to_src) {
		addDirectedWeightedEdge(srcVertex, dstnVertex, weight_src_to_dstn);
		addDirectedWeightedEdge(dstnVertex, srcVertex, weight_dstn_to_src);
	}
	
	public void addUndirectedWeightedEdge(int srcVertex, int dstnVertex, int bi_directional_same_weight) {
		addUndirectedWeightedEdge(srcVertex, dstnVertex, bi_directional_same_weight, bi_directional_same_weight);
	}
	
	public void deleteDirectedEdge(int srcVertex, int dstnVertex) {
		GraphNode<Integer> temp = head_nodes.get(srcVertex);
		while(temp.getNext()!=null) {
			if(temp.getNext().getData() == dstnVertex) {
				temp.setNext(temp.getNext().getNext());
				break;
			}
		}
	}
	
	public void deleteUndirectedEdge(int srcVertex, int dstnVertex) {
		deleteDirectedEdge(srcVertex, dstnVertex);
		deleteDirectedEdge(dstnVertex, srcVertex);
	}
	
	public void display() {
		System.out.println();
		System.out.println("-----------------Adjacency List----------------");
		for(int i=0;i<head_nodes.size();i++) {
			GraphNode<Integer> temp = head_nodes.get(i);
			System.out.print(temp);
			while(temp.getNext()!=null) {
				System.out.print("  ->  "+temp.getNext());
				temp = temp.getNext();
			}
			System.out.println();
		}
	}
}
