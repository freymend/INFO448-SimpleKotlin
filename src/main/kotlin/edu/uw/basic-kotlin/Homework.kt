package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    return when (arg) {
        is String -> {
            when (arg) {
                "Hello" -> "world"
                else -> "Say what?"
            }
        }
        is Int -> {
            when (arg) {
                0 -> "zero"
                1 -> "one"
                in 3..9 -> "low number"
                else -> "a number"
            }
        }
        else -> "I don't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(x: Int, y: Int): Int {
    return x + y
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(x: Int, y: Int): Int {
    return x - y
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(x: Int, y: Int, callback: (x: Int, y: Int) -> Int): Int {
    return callback(x, y)
}

// write a class "Person" with first name, last name and age
class Person(val firstName: String, val lastName: String, val age: Int) {
    val debugString = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(val amount: Int, val currency: String) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("amount must be positive")
        }

        when (currency) {
            "USD" -> {}
            "EUR" -> {}
            "CAN" -> {}
            "GBP" -> {}
            else -> throw IllegalArgumentException("currency must be USD EUR, CAN, or GBP")
        }
    }

    fun convert(currency: String) : Money {
        val convert: (denomination: String) -> Double = { denomination ->
            when (denomination) {
                "USD" -> 4.0
                "EUR" -> 6.0
                "CAN" -> 5.0
                "GBP" -> 2.0
                else -> throw IllegalArgumentException("currency must be USD EUR, CAN, or GBP")
            }
        }
        val to = convert(currency)
        val from = convert(this.currency)

        val convertMultiplier = to / from
        val newAmount = (amount * convertMultiplier).toInt()
        return Money(newAmount, currency)
    }

    operator fun plus(other: Money): Money {
        val converted = other.convert(currency)
        return Money(amount + converted.amount, currency)
    }
}