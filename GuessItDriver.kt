import java.util.*

/**The driver class for Guess It! game
 * @author vineshraju on 21/5/17.
 */
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    println("Enter the number of characters in your word:")
    val noOfChars = input.nextInt()

    val groups = Util.splitAlphabetsInto(noOfChars)
    //Showing groups
    for (groupIndex in groups.indices) {
        print("${groupIndex + 1}:(${groups[groupIndex]})\t")
    }

    println("\n\n(1/2)Enter the groups in which the characters of your word appear:")
    //getting the groups with the User's characters and transposing it
    val groupsContainingTheWord = Util.getTransposedGroupsFor(Array(noOfChars, { groups[input.nextInt() - 1] }))

    //Showing groups
    for (groupIndex in groupsContainingTheWord.indices) {
        print("${groupIndex + 1}:(${groupsContainingTheWord[groupIndex].arranged})\t")
    }
    println("\n\n(2/2)Enter the groups in which the characters of your word appear:")

    //finding the word
    val theWord = Array(noOfChars, { groupsContainingTheWord[input.nextInt() - 1][it] }).joinToString(separator = "")

    println("the word is $theWord!!")
}