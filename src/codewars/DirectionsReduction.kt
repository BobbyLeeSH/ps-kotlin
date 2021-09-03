package codewars

class DirectionsReduction {
    fun dirReduc(arr: Array<String>): Array<String> {
        var reductionRequired = true
        val list = arr.toMutableList()
        while (reductionRequired) {
            reductionRequired = false
            var index = 0
            while (index < list.size - 1) {
                if ((list[index] == "SOUTH" && list[index + 1] == "NORTH")
                    || (list[index] == "NORTH" && list[index + 1] == "SOUTH")
                    || (list[index] == "EAST" && list[index + 1] == "WEST")
                    || (list[index] == "WEST" && list[index + 1] == "EAST")
                ) {
                    list.removeAt(index + 1)
                    list.removeAt(index)
                    reductionRequired = true
                } else {
                    index++
                }
            }
        }
        return list.toTypedArray()
    }
}