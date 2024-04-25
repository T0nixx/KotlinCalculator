fun main() {
    val inputProcessor = InputProcessor()
    try {
        val num1 = inputProcessor.getFirstNumber()
        val operationName = inputProcessor.getOperationName()
        val num2 = inputProcessor.getSecondNumber()

        val operation = OperationName.getOperation(operationName)!!

        val calc = Calculator(operation, num1, num2)

        println("계산 결과: " + calc.calculate())
    } catch (e: IllegalArgumentException) {
        println(e.message)
    } catch (e: ArithmeticException) {
        println(e.message)
    } catch (e: Exception) {
        println("처리 되지 않은 예외입니다. " + e.message)
    }
}