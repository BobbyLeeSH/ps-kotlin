package goldman;

import java.util.HashSet;
import java.util.Set;

public class Q1 {

    /*
     * Complete the 'condense' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */


    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
        Set<Integer> set = new HashSet<>();
        if (head == null) return null;

        SinglyLinkedListNode curr = head;
        set.add(curr.data);

        while (curr.next != null) {
            int data = curr.next.data;
            System.out.println(data);
            if (set.contains(data)) {
                curr.next = curr.next.next;
                if (curr.next == null) {
                    if (set.contains(curr.data)) curr = null;
                    break;
                }
            } else {
                set.add(data);
                curr = curr.next;
            }
        }
        return head;
    }

    private class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
