package trees;

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	private boolean isMirror(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}

		if (tree1 == null || tree2 == null) {
			return false;
		}

		return (tree1.val == tree2.val) && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
	}
}
