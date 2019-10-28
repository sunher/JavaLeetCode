package list;

public class SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode sortList(ListNode head) {

        if(head == null || head.next ==null){
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next !=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode temp = slow.next;
        slow.next=null;
        ListNode left = sortList(temp);
        ListNode right = sortList(head);
       return mergeTwoLists(right,left);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header=new ListNode(0);
        if(l1==null){
            header.next=l2;
            return header.next;
        }
        if(l2==null){
            header.next=l1;
            return header.next;
        }
        if(l1.val<l2.val){
            header.next=l1;
            header.next.next=mergeTwoLists(l1.next,l2);
        }else {
            header.next=l2;
            header.next.next=mergeTwoLists(l1,l2.next);
        }


        return header.next;

    }


    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode current =h;
        for (int i = 2;i<6;i++){
            current.next = new ListNode(i);
            current = current.next;
        }

        sortList(h);

    }


}
