package leetcode

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var count = 0
        var values = mutableListOf<Int>()

        lists.forEach {
            var temp = it
            while (temp != null) {
                values.add(temp.`val`)
                temp = temp.next
            }
        }
        if (values.isEmpty()) return null

        values.sort()
        println(values)
        val ret = ListNode(values[0])
        var curr = ret
        for (i in 1 until values.size) {
            curr.next = ListNode(values[i])
            curr = curr.next!!
        }

        return ret
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}