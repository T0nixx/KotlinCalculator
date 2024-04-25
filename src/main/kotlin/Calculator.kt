class Calculator(
    private val operation: AbstractOperation,
    private val num1: Double,
    private val num2: Double
) {
    fun calculate(): Double {
        return operation.operate(num1, num2)
    }
}
