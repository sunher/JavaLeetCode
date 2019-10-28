package list;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        StringBuilder stringBuilder = new StringBuilder();

        int temp = 0;
        while (node1!=null||node2!=null){
            int x = (node1!=null?node1.val: 0)  + (node2!=null?node2.val:0) + temp;
            if(x>9){
                temp = 1;
                stringBuilder.append(x%10);
            }else {
                temp = 0;
                stringBuilder.append(x);
            }
            if(node1!=null){
                node1 = node1.next;
            }

            if(node2!=null){
                node2 = node2.next;
            }


        }
        if(temp!=0){
            stringBuilder.append(1);
        }

        String xx=stringBuilder.reverse().toString();
        ListNode h = new ListNode(Integer.valueOf(String.valueOf(xx.charAt(0))));
        ListNode current =h;

        for (int i = 1;i<xx.length();i++){
            current.next = new ListNode(Integer.valueOf(String.valueOf(xx.charAt(i))));
            current = current.next;
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

        addTwoNumbers(h,new ListNode(0));
    }


}
