package codewars

class HumanReadableDurationFormat {
    fun formatDuration(seconds: Int): String {
        if (seconds == 0) return "now"

        var mutableSeconds = seconds
        val minuteInSec = 60
        val hourInSec = 3600
        val dayInSec = hourInSec * 24
        val yearInSeconds = dayInSec * 365

        val unitList = mutableListOf("year", "day", "hour", "minute", "second")
        val durationList = mutableListOf<String>()

        durationList.add(getTimeInFormat(unitList[0], mutableSeconds / yearInSeconds))
        mutableSeconds %= yearInSeconds

        durationList.add(getTimeInFormat(unitList[1], mutableSeconds / dayInSec))
        mutableSeconds %= dayInSec

        durationList.add(getTimeInFormat(unitList[2], mutableSeconds / hourInSec))
        mutableSeconds %= hourInSec

        durationList.add(getTimeInFormat(unitList[3], mutableSeconds / minuteInSec))
        mutableSeconds %= minuteInSec

        durationList.add(getTimeInFormat(unitList[4], mutableSeconds))

        val filtered = durationList.filter { it != "" }

        if (filtered.size == 1) return filtered[0]
        else {
            val builder = StringBuilder()
            builder.append(filtered[0])
            for (i in 1 until filtered.size - 1) {
                builder.append(", ").append(filtered[i])
            }
            builder.append(" and ").append(filtered[filtered.size - 1])
            return builder.toString()
        }


    }

    private fun getTimeInFormat(key: String, duration: Int): String {
        return if (duration == 0) ""
        else if (duration == 1) "$duration $key"
        else "$duration ${key}s"
    }
}