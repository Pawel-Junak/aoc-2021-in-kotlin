package day03

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val listList = hashMapOf<Int, MutableList<Int>>()
        input.forEach {
            it.mapIndexed { index, s ->
                listList[index]?.add(s.digitToInt())
                    ?: listList.put(index, mutableListOf(s.digitToInt()))
            }
        }

        var gamma = ""
        var epsilon = ""

        for (i in 0..100) {
            listList.get(i)?.let {
                var one = 0
                var zero = 0
                it.forEach {
                    if (it == 1) {
                        one++
                    } else {
                        zero++
                    }
                }
                if (one > zero) {
                    gamma = gamma.plus("1")
                    epsilon = epsilon.plus("0")
                } else {
                    gamma = gamma.plus("0")
                    epsilon = epsilon.plus("1")
                }
            }
        }

        val gammaInt = gamma.toInt(2)
        val epsilonint = epsilon.toInt(2)
        return gammaInt * epsilonint
    }

    fun part2(input: List<String>): Int {
//        val listList = hashMapOf<Int, MutableList<Int>>()
//        input.forEach {
//            it.mapIndexed { index, s ->
//                listList[index]?.add(s.digitToInt())
//                    ?: listList.put(index, mutableListOf(s.digitToInt()))
//            }
//        }
//
//        var oxygen: String = ""
//        val oxygenList = mutableListOf(input)
//        var co: String = ""
//        val coList = mutableListOf(input)
//
//
//        for (i in 0..100) {
//            listList.get(i)?.let {
//                var one = 0
//                var zero = 0
//                it.forEach {
//                    if (it == 1) {
//                        one++
//                    } else {
//                        zero++
//                    }
//                }
//                if (one > zero) {
//                    gamma = gamma.plus("1")
//                    epsilon = epsilon.plus("0")
//                } else {
//                    gamma = gamma.plus("0")
//                    epsilon = epsilon.plus("1")
//                }
//            }
//        }
//
//        val gammaInt = gamma.toInt(2)
//        val epsilonint = epsilon.toInt(2)
//        return gammaInt * epsilonint
//
//
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("input_test", "day03")
    check(part1(testInput) == 198)
//    check(part2(testInput) == 230)

    val input = readInput("input", "day03")
    println(part1(input))
//    println(part2(input))
}
