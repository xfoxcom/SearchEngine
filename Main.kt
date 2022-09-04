package search

import java.io.File

fun main(args: Array<String>) {
    val path = args[1]
    val people = File(path).readLines()
    val inverted = mutableMapOf<String, MutableList<Int>>()
    for (i in people.indices) {
       val list = people[i].split("\\s+".toRegex())
        for (s in list) {
            if(inverted.containsKey(s.lowercase())) inverted[s.lowercase()]?.add(i) else inverted.put(s.lowercase(), mutableListOf(i))
        }
    }

    while (true) {
        println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit")
        when(readln().toInt()) {
            0 -> {
                println("Bye!")
                break
            }
            1 -> {
                println("Enter a name or email to search all matching people.")
                val data = readln()
                val found = mutableListOf<String>()
                val list = inverted[data.lowercase()]

                if (list != null) {
                    for (i in list)
                        found.add(people[i])
                }

                if (found.isEmpty()) println("No matching people found.") else {
                    println("People found: ")
                    found.forEach { p -> println(p) }
                }
            }
            2 -> {
                println("=== List of people ===")
                people.stream().forEach { p -> println(p) }
            }
            else -> println("Incorrect option! Try again.")
        }
    }
}
