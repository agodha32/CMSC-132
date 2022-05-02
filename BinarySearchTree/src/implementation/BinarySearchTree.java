package implementation;

import java.util.Comparator;
import java.util.TreeSet;

public class BinarySearchTree<K, V> {
	/*
	 * You may not modify the Node class and may not add any instance nor static
	 * variables to the BinarySearchTree class.
	 */
	private class Node {
		private K key;
		private V value;
		private Node left, right;

		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private Node root;
	private int treeSize, maxEntries;
	private Comparator<K> comparator;

	public BinarySearchTree(Comparator<K> comparator, int maxEntries) {
		this.root = null;
		treeSize = 0;
		this.maxEntries = maxEntries;
		this.comparator = comparator;
	}

	public BinarySearchTree<K, V> add(K key, V value) throws TreeIsFullException {
		if (root == null) {
			root = new Node(key, value);
			treeSize++;
		} else {
			addAux(key, value, root);
		}
		return this;
	}

	private void addAux(K key, V value, Node node) {
		int compare = this.comparator.compare(key, node.key);
		if (compare == 0) {
			node.value = value;
		} else if (compare < 0) {
			if (node.left == null) {
				node.left = new Node(key, value);
				treeSize++;
			} else {
				addAux(key, value, node.left);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(key, value);
				treeSize++;
			} else {
				addAux(key, value, node.right);
			}
		}
	}

	public String toString() {
		if (root == null) {
			return "EMPTY TREE";
		} else {
			return toStringAux(root);
		}
	}

	private String toStringAux(Node rootAux) {
		return rootAux == null ? ""
				: toStringAux(rootAux.left) + "{" +
						rootAux.key + ":" + rootAux.value + "}" + toStringAux(rootAux.right);
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return treeSize;
	}

	public boolean isFull() {
		return treeSize == maxEntries;
	}

	public KeyValuePair<K, V> getMinimumKeyValue() throws TreeIsEmptyException {
		if (isEmpty()) {
			throw new TreeIsEmptyException("Tree is Empty");
		} else {
			return getValueMin(root);
		}
	}

	private KeyValuePair<K, V> getValueMin(Node node) {
		if (node.left == null) {
			return new KeyValuePair<K, V>(node.key, node.value);
		} else {
			return getValueMin(node.left);
		}
	}

	public KeyValuePair<K, V> getMaximumKeyValue() throws TreeIsEmptyException {
		if (isEmpty()) {
			throw new TreeIsEmptyException("Tree is Empty");
		} else {
			return getValueMax(root);
		}
	}

	private KeyValuePair<K, V> getValueMax(Node node) {
		if (node.right == null) {
			return new KeyValuePair<K, V>(node.key, node.value);
		} else {
			return getValueMax(node.right);
		}
	}

	public KeyValuePair<K, V> find(K key) {
		return findKey(key, root);
	}

	private KeyValuePair<K, V> findKey(K key, Node node) {
		if (node == null) {
			return null;
		} else {
			int compare = comparator.compare(key, node.key);
			if (compare < 0) {
				return findKey(key, node.left);
			} else if (compare > 0) {
				return findKey(key, node.right);
			} else {
				return new KeyValuePair<K, V>(key, node.value);
			}
		}
	}

	public BinarySearchTree<K, V> delete(K key) throws TreeIsEmptyException {
		if (isEmpty()) {
			throw new TreeIsEmptyException("Tree is Empty");
		} else if (key == null) {
			throw new IllegalArgumentException("Key is Null");
		} else {
			root = delete(key, root);
			return this;
		}
	}

	private Node delete(K key, Node node) {
		int compare = comparator.compare(key, node.key);
		if (compare > 0) {
			node.right = delete(key, node.right);
		} else if (compare < 0) {
			node.left = delete(key, node.left);
		} else {
			if (node.left != null && node.right != null) {
				Node temp = node;
				KeyValuePair<K, V> maxLeft = getValueMax(node.left);
				temp.value = maxLeft.getValue();
				node.left = delete(maxLeft.getKey(), node.left);
			} else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				node = null;
			}
		}
		treeSize--;
		return node;

	}

	public void processInorder(Callback<K, V> callback) {
		if (callback == null) {
			throw new IllegalArgumentException("Callback is null");
		} else {
			processInOrder(root, callback);
		}
	}

	private void processInOrder(Node node, Callback<K, V> callback) {
		if (node == null) {
			return;
		}
		processInOrder(node.left, callback);
		callback.process(node.key, node.value);
		processInOrder(node.right, callback);
	}

	public BinarySearchTree<K, V> subTree(K lowerLimit, K upperLimit) {
		BinarySearchTree<K, V> toReturn = new BinarySearchTree<K, V>(comparator, maxEntries);
		toReturn.root = subTreeAux(lowerLimit, upperLimit, root, toReturn.root);
		return toReturn;
	}

	private Node subTreeAux(K k1, K k2, Node node, Node mostRecent) {
		if (node == null) {
			return mostRecent;
		}
		int lowerLim = this.comparator.compare(node.key, k1);
		int upperLim = this.comparator.compare(node.key, k2);
		if (lowerLim < 0) {
			subTreeAux(k1, k2, node.right, mostRecent);
		} else if (upperLim > 0) {
			subTreeAux(k1, k2, node.left, mostRecent);
		}

		if ((lowerLim >= 0 && upperLim <= 0) || (lowerLim == 0 || upperLim == 0)) {
			if (mostRecent == null) {
				mostRecent = new Node(node.key, node.value);
			} else {
				if (this.comparator.compare(node.key, mostRecent.key) > 0) {
					mostRecent.right = new Node(node.key, node.value);
					mostRecent = mostRecent.right;
				} else {
					mostRecent.left = new Node(node.key, node.value);
					mostRecent = mostRecent.left;
				}
			}
			subTreeAux(k1, k2, node.right, mostRecent);
			subTreeAux(k1, k2, node.left, mostRecent);
		}
		return mostRecent;

	}

	public TreeSet<V> getLeavesValues() {
		TreeSet<V> toReturn = new TreeSet<V>();
		value(toReturn, this.root);
		return toReturn;
	}

	private void value(TreeSet<V> addValue, Node node) {
		if (node == null) {
				return;
		}
		if (node.left == null && node.right == null) {
			addValue.add(node.value);
			return;
		}
		if (node.left != null) {
			value(addValue, node.left);
		}
		if (node.right != null) {
			value(addValue, node.right);
		}
	}

}
