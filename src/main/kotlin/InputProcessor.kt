class InputProcessor {
    private fun processInput(
        inputMessage: String,
        exceptionMessage: String,
        validator: (String?) -> Boolean,
        maximumRetryCount: Int = 5
    ): String {
        var input: String? = null

        var retryCounter = 0
        while (input.isNullOrEmpty() || validator(input)) {
            require(retryCounter < maximumRetryCount) { "'${input}'" + exceptionMessage }
            println(inputMessage)
            input = readlnOrNull()
            retryCounter++
        }
        return input
    }

    val numberArugumentExceptionMessage = "은(는) 올바른 숫자가 아닙니다."

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
            numberArugumentExceptionMessage,
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
            numberArugumentExceptionMessage,
            ::isNotNumeric
        ).toDouble()
    }
}