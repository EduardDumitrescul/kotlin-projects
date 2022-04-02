var heroName: String = ""

fun main() {
    heroName = promptHeroName()

    // changeNarratorMood()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}
private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?") { message ->
        "\u001b[33;1m$message\u001b[0m"
    }
    /*
    val heroName = readLine() ?: ""
    require(heroName != null && heroName.isNotEmpty()) {
        "The hero must have a name."
    }
    */

    println("Madrigal");
    return "Madrigal"
}

private fun createTitle(name: String): String {
    return when {
        name.all {it.isDigit() } -> "The Identifiable"
        name.none {it.isLetter() } -> "The Witnhghess Protection Member"
        name.count {it.lowercase() in "aeiou"} > 4 -> "The Master of Vowels"
        name.all {!it.isLetter() || it.isUpperCase() } -> "The Bold"
        name.count {it.isLetter()} > 20 -> "The Verbose"
        name.reversed() == name -> "Bringer of Palindromes"
        else -> "The Renowed Hero"
    }
}