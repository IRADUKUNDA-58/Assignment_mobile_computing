//QUESTION :Write a Kotlin Program that takes an integer from the command line  and
// displays the number in words. For example, if the number is 123, the
// program should display: one hundred twenty three .
// Assume your program can handle six digit integers or less.

fun main() {
    print("Enter a number (range is 1 to 99999): ")
    val input = readLine()

    val number = input?.toIntOrNull()

    if (number != null && number in 0..999999) {
        val words = convertToWords(number)
        println("Number in words: $words")
    } else {
        println("Invalid input. Please enter a non-negative integer up to 999999.and  check if your number is not fraction")
    }
}

fun convertToWords(number: Int): String {
    val units = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = arrayOf("", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    val hundredThousands = number / 100000   // for hundred thousand
    val tenThousands = (number % 100000) / 10000//for te thousands
    val thousands = (number % 10000) / 1000     //for thousands
    val hundreds = (number % 1000) / 100          //for  hundreds
    val tensDigit = (number % 100) / 10     //for tens
    val unitsDigit = number % 10          // for one to nine

    val result = StringBuilder()

    if (hundredThousands > 0) {
        result.append("${units[hundredThousands]} hundred ")
    }

    if (tenThousands > 1) {
        result.append("${tens[tenThousands]} ")
    } else if (tenThousands == 1) {
        result.append("${teens[thousands]} ")
        return result.toString().trim()
    }

    if (thousands > 0) {
        result.append("${units[thousands]} thousand ")
    }

    if (hundreds > 0) {
        result.append("${units[hundreds]} hundred ")
    }

    if (tensDigit > 1) {
        result.append("${tens[tensDigit]} ")
    } else if (tensDigit == 1) {
        result.append("${teens[unitsDigit]} ")
        return result.toString().trim()
    }

    if (unitsDigit > 0) {
        result.append(units[unitsDigit])
    }

    return result.toString().trim()
}
