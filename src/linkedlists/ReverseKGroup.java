package linkedlists;

public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode ptr = head;
		ListNode kTail = null;

		// Head of the final, modified linked list.
		ListNode newHead = null;

		while (ptr != null) {
			int count = 0;

			// Start counting nodes from the head.
			ptr = head;

			// Find the head of the next k nodes.
			while (count < k && ptr != null) {
				ptr = ptr.next;
				count++;
			}

			// If we counted k nodes, reverse them.
			if (count == k) {
				// Reverse k nodes and get the new head.
				ListNode revHead = reverseLinkedList(head, k);

				// newHead is the head of the final linked list.
				if (newHead == null) {
					newHead = revHead;
				}

				// kTail is the tail of the previous block of reversed k nodes.
				if (kTail != null) {
					kTail.next = revHead;
				}

				kTail = head;
				head = ptr;
			}
		}

		// Attach the final, possibly un-reversed portion.
		if (kTail != null) {
			kTail.next = head;
		}

		return newHead == null ? head : newHead;
	}

	public ListNode reverseKGroupRec(ListNode head, int k) {
		int count = 0;
		ListNode ptr = head;

		// See if there are at least k nodes left on the linked list.
		while (count < k && ptr != null) {
			ptr = ptr.next;
			count++;
		}

		// If we have k nodes, we reverse them
		if (count == k) {
			// Reverse the first k nodes of the list and get the reversed list's head
			ListNode reversedHead = reverseLinkedList(head, k);

			// Recurse on the remaining linked list.
			// Since our recursion returns the head of the overall processed
			// list, we use that and the "original" head of the "k" nodes
			// to re-wire the connections.
			head.next = reverseKGroup(ptr, k);
			return reversedHead;
		}

		return head;
	}

	private ListNode reverseLinkedList(ListNode head, int k) {
		ListNode newHead = null;
		ListNode ptr = head;

		while (k > 0) {
			// Keep track of the next node to process in the original list
			ListNode nextNode = ptr.next;

			// Insert the node pointed to by "ptr"
			// at the beginning of the reversed list.
			ptr.next = newHead;
			newHead = ptr;

			// Move on to the next node.
			ptr = nextNode;

			k--;
		}

		// Return the head of the reversed list.
		return newHead;
	}
}
