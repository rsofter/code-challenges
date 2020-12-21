package linkedlists;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dammyNode = new ListNode(-1);
		ListNode current = dammyNode;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}

			current = current.next;
		}

		current.next = (l1 == null) ? l2 : l1;

		return dammyNode.next;
	}
}
