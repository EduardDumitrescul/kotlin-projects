import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isBalanced(s: String): String {
    // Write your code here
    var stack = ArrayList<Int>()
    var ok: Boolean = true
    for(chr in s) {
        when(chr) {
            '(' -> stack.add(1)
            '[' -> stack.add(2)
            '{' -> stack.add(3)
            ')' -> {
                if(stack.size == 0)
                    ok = false
                if(stack.get(stack.size - 1) != 1)
                    ok = false

                if(stack.size > 0)
                    stack.removeAt(stack.size - 1)
            }
            ']' -> {
                if(stack.size == 0)
                    ok = false
                if(stack.get(stack.size - 1) != 2)
                    ok = false

                if(stack.size > 0)
                    stack.removeAt(stack.size - 1)
            }
            '}' -> {
                if(stack.size == 0)
                    ok = false
                if(stack.get(stack.size - 1) != 3)
                    ok = false

                if(stack.size > 0)
                    stack.removeAt(stack.size - 1)
            }
        }
    }
    when(ok) {
        false -> return "NO"
        true -> return "YES"
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}
