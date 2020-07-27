package leetcode

class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        var one = l1
        var two = l2

        var ans = one
        if (one.`val` <= two.`val`) {
            one = one.next
        } else {
            ans = two
            two = two.next
        }
        var curr = ans

        while (one != null && two != null) {
            if (one.`val` <= two.`val`) {
                curr?.next = one
                one = one.next
            } else {
                curr?.next = two
                two = two.next
            }
            curr = curr?.next
        }
        if (one == null) {
            curr?.next = two
        } else if (two == null) {
            curr?.next = one
        }

        return ans
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}