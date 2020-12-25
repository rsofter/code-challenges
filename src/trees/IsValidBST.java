package trees;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidNode(root, null, null);
	}

	private boolean isValidNode(TreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}

		int nodeValue = node.val;
		if ((min != null && nodeValue <= min) || (max != null && nodeValue >= max)) {
			return false;
		}

		return isValidNode(node.left, min, nodeValue) && isValidNode(node.right, nodeValue, max);
	}
}
