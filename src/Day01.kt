fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.map { it.toInt() }
            .zipWithNext { s1, s2 ->
                if (s1 < s2) sum++
            }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.map { it.toInt() }
            .windowed(3, 1)
            .zipWithNext { s1, s2 ->
                if (s1.sum() < s2.sum()) sum++
            }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
