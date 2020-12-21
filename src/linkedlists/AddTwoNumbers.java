package linkedlists;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		ListNode p1 = l1;
		ListNode p2 = l2;
		int carry = 0;

		while (p1 != null || p2 != null) {
			int x = (p1 != null) ? p1.val : 0;
			int y = (p2 != null) ? p2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
			current = current.next;
		}

		if (carry == 1) {
			current.next = new ListNode(carry);
		}

		return dummyHead.next;
	}
}
