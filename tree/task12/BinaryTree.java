package com.tree.task12;

class TreeNode {
	int key;
	TreeNode left, right;

	public TreeNode(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {
	private TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	private TreeNode insertRec(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}

		return root;
	}

	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private TreeNode deleteRec(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.key) {
			root.left = deleteRec(root.left, key);
		} else if (key > root.key) {
			root.right = deleteRec(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.key = minValue(root.right);

			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	private int minValue(TreeNode root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	public void inorder() {
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	public void preorder() {
		preorderRec(root);
		System.out.println();
	}

	private void preorderRec(TreeNode root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	public void postorder() {
		postorderRec(root);
		System.out.println();
	}

	private void postorderRec(TreeNode root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.key + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder traversal:");
		tree.inorder(); // Output: 20 30 40 50 60 70 80

		System.out.println("Preorder traversal:");
		tree.preorder(); // Output: 50 30 20 40 70 60 80

		System.out.println("Postorder traversal:");
		tree.postorder(); // Output: 20 40 30 60 80 70 50

		tree.delete(20);

		System.out.println("Inorder traversal after deletion:");
		tree.inorder(); // Output: 30 40 50 60 70 80
	}
}
