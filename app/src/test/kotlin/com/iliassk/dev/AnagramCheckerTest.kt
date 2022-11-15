package com.iliassk.dev

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test

class AnagramCheckerTest {
    @Test
    internal fun `should check that 2 empty words are not anagrams`() {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("", "")
        result shouldBe false
    }

    @Test
    internal fun `should check that one empty word and one non-empty word are not anagrams`() {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("fried", "")
        result shouldBe false
    }

    @ParameterizedTest
    @ValueSource(strings = ["AB", "BA"])
    internal fun `should check that 2 words of 2 characters and same letters are anagrams`(value: String) {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("AB", value)
        result shouldBe true
    }

    @ParameterizedTest
    @ValueSource(strings = ["ACb", "BAC", "bCa", "cab", "CBa"])
    internal fun `should check that 2 words of 3 characters and same letters are anagrams`(value: String) {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("abc", value)
        result shouldBe true
    }

    @ParameterizedTest
    @ValueSource(strings = ["erif", "erfi", "eirf", "eifr", "efri", "efir", "reif", "refi", "rief", "rife", "rfei", "rfie", "ierf", "iefr", "iref", "irfe", "ifer", "ifre", "feri", "feir", "frei", "frie", "fier", "fire"])
    internal fun `should check that 2 words of 4 characters and same letters are anagrams`(value: String) {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("fire", value)
        result shouldBe true
    }

    @ParameterizedTest
    @ValueSource(strings = ["fired", "firedd"])
    internal fun `should check that 2 words of different length and same letters are not anagrams`(value: String) {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("fire", value)
        result shouldBe false
    }

    @Test
    internal fun `should check that 2 words of same length but different letters are not anagrams`() {
        val checker = AnagramChecker()
        val result = checker.areAnagrams("pride", "fired")
        result shouldBe false
    }

}