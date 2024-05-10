package com.example.bmicalculator
import kotlin.math.PI

/**
* Complete the code to make the program print "Mary is 20 years old" to standard output:
*/
fun ex1() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

/**
* Explicitly declare the correct type for each variable:
*/
fun ex2() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000
    val e: Boolean = false
    val f: Char = '\n'
}

/**
 * You have a list of “green” numbers and a list of “red” numbers.
 * Complete the code to print how many numbers there are in total.
 */
fun ex3() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val totalCount = greenNumbers.count() + redNumbers.count()
    println(totalCount)
}

/**
 * You have a set of protocols supported by your server.
 * A user requests to use a particular protocol.
 * Complete the program to check whether the requested protocol
 * is supported or not (isSupported must be a Boolean value).
 */
fun ex4() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}

/**
 * Define a map that relates integer numbers from 1 to 3 to their corresponding spelling.
 * Use this map to spell the given number.
 */
fun ex5() {
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 2
    println("$n is spelt as '${number2word[n]}'")
}

/**
 * Using a when expression, update the following program so that when you input the names of
 * GameBoy buttons, the actions are printed to output.
 * A Yes
 * B No
 * X Menu
 * Y Nothing
 * Other There is no such button
 */
fun ex6() {
    val button = "A"
    println(
            when (button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no suchbutton"
            }
    )
}

/**
 * You have a program that counts pizza slices until there’s a whole pizza with 8 slices.
 * Refactor this program in two ways:
 * Use a while loop.
 * Use a do-while loop.
 */
fun ex7a() {
    var pizzaSlices = 0
    while ( pizzaSlices < 7 ) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

fun ex7b() {
    var pizzaSlices = 0
    pizzaSlices++
    do {
        println("There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    } while (
            pizzaSlices < 8
    )
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

/**
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers
 * from 1 to 100 incrementally, replacing any number divisible by three with the word
 * "fizz", and any number divisible by five with the word "buzz".
 * Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
 */
fun ex8() {
    for (number in 1..100) {
        println(
                when {
                    number % 15 == 0 -> "fizzbuzz"
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    else -> number.toString()
                }
        )
    }
}

/**
 * You have a list of words. Use for and if to print only the words that start with the letter l.
 */

fun ex9() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (w in words) {
        if (w.startsWith("l")) println(w)
    }
}

/**
 * Write a function called circleArea that takes the radius of a circle in integer format
 * as a parameter and outputs the area of that circle.
 */

fun circleArea(radius: Int): Double {
    return PI * radius * radius
}

fun ex10() {
    println(circleArea(2))
}

fun main() {
    println("Exercise 1")
    ex1()
    println("Exercise 2")
    ex2()
    println("Exercise 3")
    ex3()
    println("Exercise 4")
    ex4()
    println("Exercise 5")
    ex5()
    println("Exercise 6")
    ex6()
    println("Exercise 7")
    ex7a()
    ex7b()
    println("Exercise 8")
    ex8()
    println("Exercise 9")
    ex9()
    println("Exercise 10")
    ex10()
}

