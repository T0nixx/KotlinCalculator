fun main() {
    val inputProcessor = InputProcessor()
    try {
        val num1 = inputProcessor.getFirstNumber()
        val operator = inputProcessor.getOperator()
        val num2 = inputProcessor.getSecondNumber()

        val operation = when (operator) {
            "+" -> AddOperation()
            "-" -> SubtractOperation()
            "*" -> MultiplyOperation()
            "/" -> DivideOperation()
            "%" -> RemainderOperation()
            // TODO else까지 갈 필요 없게 operator를 어떤 타입으로 제한하는 게 불가능한가?
            else -> throw IllegalArgumentException("올바른 연산자가 아닙니다.")
        }

        val calc = Calculator(
            operation,
            num1,
            num2
        )

        println("계산 결과: " + calc.calculate())
    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e: ArithmeticException) {
        println(e.message)
    } catch (e: Exception) {
        println("처리 되지 않은 예외입니다. " + e.message)
    }
}

