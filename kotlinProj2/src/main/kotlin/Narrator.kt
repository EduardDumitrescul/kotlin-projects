import kotlin.random.Random
import kotlin.random.nextInt

var narrationModifier: (String) -> String = {it}

inline fun narrate (
    message: String,
    modifier: (String) -> String = { narrationModifier(message) }
) {
    println(modifier(message))
}

fun changeNarratorMood() {
    val mood: String
    val modifier: (String) -> String

    when(Random.nextInt(1..8)) {
        1 -> {
            mood = "loud"
            modifier = { message ->
                val numExclamationPoints = 3
                message.uppercase() + "!".repeat(numExclamationPoints)
            }
        }
        2 -> {
            mood = "tired"
            modifier = { message ->
                message.lowercase().replace(" ", "... ");
            }
        }
        3 -> {
            mood = "unsure"
            modifier = { message ->
                "$message?"
            }
        }
        4 -> {
            var narrationsGiven = 0
            mood = "like sending an itemized bill"
            modifier = { message ->
                narrationsGiven ++;
                "$message.\n(I have narrated $narrationsGiven things)"

            }
        }
        5 -> {
            mood = "lazy"
            modifier = { message ->
                message.substring(0, message.length/2)
            }
        }
        6 -> {
            mood = "leet"
            modifier = { message ->
                val regex = """"L|E|T|l|e|t""".toRegex()
                message.replace(regex) { letter: MatchResult ->
                    when (letter.value) {
                        "L" -> "1"
                        "l" -> "1"
                        "E" -> "3"
                        "e" -> "3"
                        "T" -> "7"
                        "t" -> "7"
                        else -> {
                            letter.value
                        }
                    }
                }
            }
        }
        7 -> {
            mood = "poetic"
            modifier = {message ->
                message.replace(" ".toRegex()) {
                    when (Random.nextInt(1, 10)) {
                        in 0..2 -> "\n"
                        else -> " "
                    }
                }
            }
        }
        else -> {
            mood = "professional"
            modifier = { message ->
                "$message."
            }
        }

    }
    narrationModifier = modifier
    narrate("The narrator begins to feel $mood")
}