package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val map = mutableMapOf<String, Int>()
        input.forEach {
            val splitted = it.split(" ")
            val value = map.getOrDefault(splitted.first(), 0)
            map.put(splitted.first(), value + splitted.last().toInt())
        }
        val horizontal = map.getValue("forward")
        val up = map.getValue("up")
        val down = map.getValue("down")
        return horizontal * (down - up)
    }

    fun part2(input: List<String>): Int {
        val map = mutableMapOf<String, Int>()
        var aim = 0
        input.forEach {
            val splitted = it.split(" ")
            val value = map.getOrDefault(splitted.first(), 0)
            when (splitted.first()) {
                "up" -> aim -= splitted.last().toInt()
                "down" -> aim += splitted.last().toInt()
                "forward" -> {
                    val depth = map.getOrDefault("depth", 0)
                    map.put(splitted.first(), value + splitted.last().toInt())
                    val newDepth = depth + (aim * splitted.last().toInt())
                    map.put("depth", newDepth)
                }
            }
            map.put(splitted.first(), value + splitted.last().toInt())
        }
        val horizontal = map.getValue("forward")
        val depth = map.getValue("depth")
        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("input_test", "day02")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("input", "day02")
    println(part1(input))
    println(part2(input))
}
