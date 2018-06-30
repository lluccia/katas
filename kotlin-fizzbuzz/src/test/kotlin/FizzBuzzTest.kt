import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

class FizzBuzzTest {

    val fizzBuzz = FizzBuzz()

    @Test
    fun nonFizzBuzzNumbersShouldPrintItself() {
        assertEquals("1", fizzBuzz.of(1))
    }


    @Test
    fun multiplesOf3ShouldPrintFizz() {
        assertEquals("Fizz", fizzBuzz.of(3))
        assertEquals("Fizz", fizzBuzz.of(6))
    }

    @Test
    fun multiplesOf5ShouldPrintBuzz() {
        assertEquals("Buzz", fizzBuzz.of(5))
        assertEquals("Buzz", fizzBuzz.of(10))
    }

    @Test
    fun multiplesOf3and5ShouldPrintFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.of(15))
    }

    @Test
    fun numbersContaining3ShouldPrintFizz() {
        assertEquals("Fizz", fizzBuzz.of(13))
        assertEquals("Fizz", fizzBuzz.of(311))
    }

    @Test
    fun numbersContaining5ShouldPrintBuzz() {
        assertEquals("Buzz", fizzBuzz.of(52))
        assertEquals("Buzz", fizzBuzz.of(592))
    }

    @Test
    fun numbersContaining3and5ShouldPrintFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.of(593))
    }

    @Test
    fun print1to100() {
        for (i in 1..100) println(fizzBuzz.of(i))
    }
}