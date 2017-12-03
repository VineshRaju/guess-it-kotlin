/**A singleton class containing the Core functions for splitting and transposing
 * @author vineshraju on 19/5/17
 */


object Util {

    val alphabets = "abcdefghijklmnopqrstuvwxyz"

    private inline val Int.limit get() = minOf(this, alphabets.length)
    private inline val Int.noOfGroupsNeeded get() = Math.ceil(alphabets.length / this.toDouble()).toInt()

    /**
     * Splits the alphabets of the English language into groups.
     *
     * @param groupsOf the maximum number of characters in each group
     * @return an Array<String> containing the groups
     */
    fun splitAlphabetsInto(groupsOf: Int): Array<String> {

        /*val alphabets = StringBuilder("abcdefghijklmnopqrstuvwxyz").reverse()
            for (i in alphabets.length - groupsOf downTo 1 step groupsOf) alphabets.insert(i, ",")
            return alphabets.reverse().split(",".toRegex()).toTypedArray()*/
        val charsInEachGroup = groupsOf.limit

        return Array(charsInEachGroup.noOfGroupsNeeded,
                {
                    val start = it * charsInEachGroup
                    val end = (start + charsInEachGroup).limit
                    alphabets.substring(start..end - 1)
                })

    }

    /**
     * Transposes groups with the nth character in each group at the nth group
     *
     * @param groups The groups which has to be transposed
     * @return Transposed groups
     */
    fun getTransposedGroupsFor(groups: Array<String>) = Array(groups.size,
            {
                var groupAtThisIndex = ""
                for (groupIndex in groups.indices) {
                    groupAtThisIndex += groups[groupIndex].take(1)
                    groups[groupIndex] = if (groups[groupIndex].length == 1) " " else groups[groupIndex].drop(1)
                }
                groupAtThisIndex
            })

}

/**
 * Extension to remove redundant characters and spaces and sort it alphabetically
 */
inline val String.arranged: String
    get() = toSortedSet().joinToString(separator = "").trimStart()
