package com.iliassk.dev

class AnagramChecker {
    fun areAnagrams(word1: String, word2: String) =
        word1.length == word2.length
                && Pair(word1, word2).areNotEmpty()
                && word1.containsExactlyAllLettersOf(word2)
}

private fun Pair<String, String>.areNotEmpty() = first.isNotEmpty() && second.isNotEmpty()

private fun String.containsExactlyAllLettersOf(word: String) = getLetters().containsAll(word.getLetters())

private fun String.getLetters() = lowercase().toCharArray().asList()
