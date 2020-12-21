package linkedlists;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}

	public ListNode reverseListRec(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = reverseListRec(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}
