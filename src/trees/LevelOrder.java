package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
	List<List<Integer>> levels = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return levels;
		}

		helperRec(root, 0);

		return levels;
	}

	private void helperRec(TreeNode node, int level) {
		// Start the current level.
		if (levels.size() == level) {
			levels.add(new ArrayList<Integer>());
		}

		// Fulfill the current level.
		levels.get(level).add(node.val);

		// Process child nodes for the next level.
		if (node.left != null) {
			helperRec(node.left, level + 1);
		}
		if (node.right != null) {
			helperRec(node.right, level + 1);
		}
	}

	private void helperIteration(TreeNode root, int level) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// Start the current level.
			levels.add(new LinkedList<Integer>());

			// Number of elements in the current level.
			int levelLength = queue.size();
			for (int i = 0; i < levelLength; i++) {
				TreeNode node = queue.remove();

				// Fulfill the current level.
				levels.get(level).add(node.val);

				// Add child nodes of the current level
				// in the queue for the next level.
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			level++;
		}
	}
}
