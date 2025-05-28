
// 2487. Remove Nodes From Linked List

public class RemoveNodes {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {};

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode removeNodes(ListNode head){
        head = reverse(head);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int max = head.val;

        while (head != null) {
            if(head.val >= max){
                max = head.val;
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }

        curr.next = null;

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        RemoveNodes solution = new RemoveNodes();

        ListNode head = new ListNode(5,
                new ListNode(2,
                        new ListNode(13,
                                new ListNode(3,
                                        new ListNode(8)))));


        System.out.println("Original List: ");
        solution.print(head);

        ListNode result = solution.removeNodes(head);

        System.out.println("\nProcessed List: ");
        solution.print(result);
    }

}
