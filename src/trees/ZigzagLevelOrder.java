package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		LinkedList<Integer> levelList = new LinkedList<Integer>();
		// Add the root element with a delimiter to kick off the BFS loop.
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);
		queue.addLast(null);

		boolean leftRightDirection = true;

		while (!queue.isEmpty()) {
			TreeNode current = queue.pollFirst();
			if (current != null) {
				if (leftRightDirection) {
					levelList.addLast(current.val);
				} else {
					levelList.addFirst(current.val);
				}

				if (current.left != null)
					queue.addLast(current.left);
				if (current.right != null)
					queue.addLast(current.right);
			} else {
				// We finish the scan of one level.
				result.add(levelList);
				levelList = new LinkedList<Integer>();
				// Prepare for the next level.
				if (!queue.isEmpty())
					queue.addLast(null);
				leftRightDirection = !leftRightDirection;
			}
		}
		return result;
	}
}
