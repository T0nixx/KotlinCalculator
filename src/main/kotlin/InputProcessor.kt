class InputProcessor {
    private fun processInput(
        inputMessage: String,
        exceptionMessage: String,
        validator: (String?) -> Boolean
    ): String {
        var input: String? = null
        var counter = 0

        while (input.isNullOrEmpty() || validator(input)) {
            require(counter < 5) { "'${input}'" + exceptionMessage }
            println(inputMessage)
            input = readlnOrNull()
            counter++
        }
        return input
    }

    private fun isNotNumeric(toCheck: String?): Boolean {
        return toCheck?.toDoubleOrNull() == null
    }

    private fun isIllegalOperator(operator: String?): Boolean {
        return operator !in arrayOf("+", "-", "*", "/", "%")
    }

    fun getFirstNumber(): Double {
        val firstNumberMessage = "계산에 사용될 첫번째 값을 입력해주세요."

        return processInput(
            firstNumberMessage,
            "은(는) 올바른 숫자가 아닙니다.",
            ::isNotNumeric
        ).toDouble()

    }

    fun getOperator(): String {
        val operatorMessage = "계산에 사용될 연산의 연산자 \"+, -, *, /, %\" 중 하나를 입력해주세요."
        return processInput(
            operatorMessage,
            "은(는) 올바른 연산자가 아닙니다.",
            ::isIllegalOperator
        )
    }

    fun getSecondNumber(): Double {
        val secondNumberMessage = "계산에 사용될 두번째 값을 입력해주세요."
        return processInput(
            secondNumberMessage,
            "은(는) 올바른 숫자가 아닙니다.",
            ::isNotNumeric
        ).toDouble()
    }
}