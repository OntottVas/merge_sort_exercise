import java.util.List;

public class Main {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        /*ListNode merged = mergedList(list1, list2);
        printListNode(merged);*/

        //printListNode(list(list1, list2));

        ListNode merged = list(list1, list2);
        printListNode(merged);

    }

    public static void printListNode(ListNode list) {
        String output = "[";
        while (list != null) {
            output += list.val + " ";
            list = list.next;
        }
        System.out.println(output.substring(0, output.length() - 1) + "]");
    }

    public static ListNode list(ListNode list1,ListNode list2) {
        ListNode merged = new ListNode();
        ListNode temp = merged;

        while (list1 != null && list2 != null) {
            if (list1 != null) {
                if (list1.val <= list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }
        }

        if (list1 == null) {
            temp.next = list2;
        } else if (list2 == null) {
            temp.next = list1;
        }

        return merged.next;
    }
}