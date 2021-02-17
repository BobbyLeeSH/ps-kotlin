package baekjoon


fun main() {
    val (number, changes, sums) = readLine()!!.split(" ").map { it.toInt() }
    val numbers = mutableListOf(0L)
    for (i in 0 until number) {
        numbers.add(readLine()!!.toLong())
    }

    val segTree = LongArray(number * 4)

    // initialize segment tree
    segTreeInit(1, number, 1, numbers, segTree)

//    for (node in segTree) {
//        print("$node, ")
//    }
//    println()
//    println(segTree)


    for (i in 0 until changes + sums) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }

        if (a == 1L) {
            val diff = c - numbers[b.toInt()]
            numbers[b.toInt()] = c
            update(1, number, 1, b.toInt(), diff, segTree)

//            println("updated:")
//            for (node in segTree) {
//                print("$node, ")
//            }
//            println()
        } else {
            val sum = sum(1, number, 1, b.toInt(), c.toInt(), segTree)
            println(sum)
        }
    }
}

fun segTreeInit(start: Int, end: Int, node: Int, arr: List<Long>, tree: LongArray): Long {
    if (start == end) {
        tree[node] = arr[start]
        return tree[node]
    }

    val mid = (start + end) / 2

    // 재귀적으로 두 부분으로 나눈 뒤에 그 합을 자기 자신으로 함.
    tree[node] = segTreeInit(start, mid, node * 2, arr, tree) + segTreeInit(mid + 1, end, node * 2 + 1, arr, tree)
    return tree[node]
}

fun sum(start: Int, end: Int, node: Int, left: Int, right: Int, tree: LongArray): Long {
    // 범위 밖에 있는 경우
    if (left > end || right < start) {
        return 0
    }

    // 범위 안에 있는 경우
    if (left <= start && end <= right) {
        return tree[node]
    }

    // 그렇지 않다면, 두 부분으로 나누어 합을 구하기
    val mid = (start + end) / 2
    return sum(start, mid, node * 2, left, right, tree) + sum(mid + 1, end, node * 2 + 1, left, right, tree)
}

fun update(start: Int, end: Int, node: Int, idx: Int, diff: Long, tree: LongArray) {
    // 범위 밖에 있는 경우
    if (idx < start || idx > end) {
        return
    }

    // 범위 안에 있으면 내려가며 다른 원소도 갱신
    tree[node] += diff
    if (start == end) {
        return
    }
    val mid = (start + end) / 2
    update(start, mid, node * 2, idx, diff, tree)
    update(mid + 1, end, node * 2 + 1, idx, diff, tree)
}