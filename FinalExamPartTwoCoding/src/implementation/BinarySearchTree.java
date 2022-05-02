package implementation;

import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> {
	private class Node {
		private K key;
		private V data;
		private Node left, right;

		public Node(K key, V data) {
			this.key = key;
			this.data = data;
		}
	}

	private Node root;

	public void processNodesTwoChildren(Task<K, V> task) {

		processNodesWithTwoChildren(task, root);
	
	}
	
	private void processNodesWithTwoChildren(Task<K, V> task, Node node) {
		
		if(node != null) {
			
			if(node.left != null && node.right != null) {
			
				task.processing(node.key, node.data);
			
			}
			
			processNodesWithTwoChildren(task, node.left);
			processNodesWithTwoChildren(task, node.right);
			
		}
		
	}

	public ArrayList<K> getPathKeysToFind(K target) {

		ArrayList<K> keyList = new ArrayList<K>();
		
		getPath(root, target, keyList);
		
		return keyList;
		
	}
	
	private void getPath(Node node, K target, ArrayList<K> keyList) {
		
		if(node != null) {	
		
			if(node.key.compareTo(target) == 0) {
				
				keyList.add(node.key);
				
			} else if(node.key.compareTo(target) > 0) {
				
				keyList.add(node.key);
				getPath(node.left, target, keyList);
				
			} else {
				
				keyList.add(node.key);
				getPath(node.right, target, keyList);
				
			}
			
		}
		
	}

	public Set<K> getKeysNodesLevel(int targetLevel) {

		Set<K> toReturn = new TreeSet<K>();
		
		nodeLevel(root, targetLevel, toReturn, 1);
		
		return toReturn;
	
	}
	
	private void nodeLevel(Node node, int level, Set<K> set, int currLevel) {
		
		if(node != null) {
			
			if(currLevel == level) {
				
				set.add(node.key);
				
			} else {
				
				nodeLevel(node.left, level, set, currLevel + 1);
				nodeLevel(node.right, level, set, currLevel + 1);
				
			}
			
		}
		
		
		
	}


	/* Support methods */
	/* Provided: do not modify */
	public boolean add(K key, V data) {
		if (root == null) {
			root = new Node(key, data);
			return true;
		} else {
			return addAux(key, data, root);
		}
	}

	private boolean addAux(K key, V data, Node rootAux) {
		int comparison = key.compareTo(rootAux.key);

		if (comparison == 0) { // overwriting
			rootAux.data = data;
			return false;
		} else if (comparison < 0) {
			if (rootAux.left == null) {
				rootAux.left = new Node(key, data);
				return true;
			} else {
				return addAux(key, data, rootAux.left);
			}
		} else {
			if (rootAux.right == null) {
				rootAux.right = new Node(key, data);
				return true;
			} else {
				return addAux(key, data, rootAux.right);
			}
		}
	}

	/* Provided: do not modify */
	public String toString() {
		return toStringAux(root, 0);
	}

	/* Provided: do not modify */
	private String toStringAux(Node rootAux, int indentation) {
		if (rootAux == null) {
			return "";
		} else {
			int indentationDelta = 4;
			String right = toStringAux(rootAux.right, indentation + indentationDelta) + "\n";
			right += " ".repeat(indentation);
			String elem = "{" + rootAux.key + ":" + rootAux.data + "}";
			String left = toStringAux(rootAux.left, indentation + indentationDelta);
			right += " ".repeat(indentation);
			return  right + elem + left;
		}
	}
}
