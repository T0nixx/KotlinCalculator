class Calculator(
    val operation: AbstractOperation,
    val num1: Double,
    val num2: Double
) {
    fun calculate(): Double {
        return operation.operate(num1, num2)
    }
}
