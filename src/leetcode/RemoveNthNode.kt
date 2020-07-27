package leetcode

class RemoveNthNode {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var nthNode = head
        var curr = head

        repeat(n) {
            nthNode = nthNode?.next
        }
        if (nthNode == null) return head?.next

        var temp = head?.next

        while (true) {
            nthNode = temp

            repeat(n) {
                nthNode = nthNode?.next
            }
            if (nthNode == null) break

            temp = temp?.next
            curr = curr?.next
        }

        curr?.next = temp?.next
        return head
    }

    data class ListNode(
            var `val`: Int,
            var next: ListNode?
    )
}