package problems;

import advanced_structures.GraphUsingAdjList;
import basic_structures.BinaryTree;

public class Test {

	public static void main(String[] args) {
//		GraphUsingAdjList graph = new GraphUsingAdjList(4);
//		graph.display();
//		
//		graph.addDirectedEdge(1, 3);
//		graph.addUndirectedEdge(2, 3);
//		graph.addDirectedWeightedEdge(3, 0, 5);
//		graph.display();
//		
//		graph.addUndirectedWeightedEdge(2, 3, 5, 7);
//		graph.display();
//		
//		graph.addUndirectedWeightedEdge(3, 0, 10);
//		graph.display();
		
		BinaryTree<Integer> bt = new BinaryTree<>(1);
		bt.setLeft(new BinaryTree<Integer>(2));
		bt.setRight(new BinaryTree<Integer>(3));
		
		bt.getLeft().setLeft(new BinaryTree<Integer>(4));
		bt.getLeft().setRight(new BinaryTree<Integer>(5));
		
		bt.getLeft().getLeft().setRight(new BinaryTree<Integer>(8));
		
		bt.getRight().setLeft(new BinaryTree<Integer>(6));
		bt.getRight().setRight(new BinaryTree<Integer>(7));
		
		bt.getRight().getLeft().setRight(new BinaryTree<Integer>(9));
		bt.getRight().getLeft().getRight().setLeft(new BinaryTree<Integer>(10));
		
		bt.inOrderTraversal();
		System.out.println();
		
		bt.preOrderTraversal();
		System.out.println();
		
		bt.postOrderTraversal();
		System.out.println();
		
		System.out.print(bt.getHeight());
		
	}

}
