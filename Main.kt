package search

fun main() {
 println("Enter the number of people: ")
    val numberOfPeople = readln().toInt()
    println("Enter all people:")
    val people = mutableListOf<String>()
    for (i in 1..numberOfPeople) {
      people.add(readLine()?:"nobody")
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
                println("Enter a name or email to search all suitable people.")
                val data = readln()
                val found = mutableListOf<String>()
                for (person in people) {
                    if (person.contains(data, true)) found.add(person)
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