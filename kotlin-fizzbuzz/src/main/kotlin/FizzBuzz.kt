class FizzBuzz {

    fun of(number: Int): String {
        if (!isFizz(number) && !isBuzz(number))
            return Integer.toString(number)

        val sb = StringBuilder()

        if (isFizz(number)) sb.append("Fizz")
        if (isBuzz(number)) sb.append("Buzz")

        return  sb.toString()
    }

    private fun isFizz(number: Int) =
            number % 3 == 0 || Integer.toString(number).contains('3')

    private fun isBuzz(number: Int) =
            number % 5 == 0 || Integer.toString(number).contains('5')

}
