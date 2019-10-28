package list;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.Stack;

public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public ListNode reverseList(ListNode head) {

        ListNode prev= null;
        ListNode current = head;
        while (current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

        }
        return prev;
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {


        ListNode h = head;
        ListNode indexStart = null;
        ListNode indexEnd = null;
        ListNode xEnd = null;
        ListNode xStart = null;


        ListNode prev = null;
        ListNode current = head;
        int i =0;
        while (current!=null){
            i++;
            if(i == m -1){
                indexStart = current;
                xEnd = current.next;

            }
            if(i<m){
                current = current.next;
                continue;
            }
            if(i==n){
                indexEnd = current.next;
                xStart = current;
            }
            if(i>n){
                break;
            }
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

        }



        if(m==1){
            xEnd=h;
            xEnd.next=indexEnd;
            return xStart;
        }else {
            indexStart.next=xStart;
            xEnd.next=indexEnd;
        }
        return h;

    }


    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode current =h;
        for (int i = 2;i<6;i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        reverseBetween(h,1,5);
    }

}



