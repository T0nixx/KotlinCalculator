abstract class AbstractOperation() {
    open fun operate(num1: Double, num2: Double): Double {
        return 0.0
    }
}

class AddOperation() : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}

class SubtractOperation() : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

class MultiplyOperation() : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

class DivideOperation() : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double {
        if (num2 == 0.0) throw ArithmeticException("0으로 나눌 수 없습니다.")
        return num1 / num2
    }
}

class ModuloOperation() : AbstractOperation() {
    override fun operate(num1: Double, num2: Double): Double {
        if (num2 == 0.0) {
            throw ArithmeticException("0으로 나눈 나머지를 구할 수 없습니다.")
        }
        return num1 % num2
    }
}

enum class OperationName(val operator: String) {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    MODULO("%");

    companion object {
        private val operatorToOperationName =
            OperationName.entries.associateBy(OperationName::operator)
        private val operationNameToOperation =
            mapOf(
                ADDITION to AddOperation(),
                SUBTRACTION to SubtractOperation(),
                MULTIPLICATION to MultiplyOperation(),
                DIVISION to DivideOperation(),
                MODULO to ModuloOperation(),
            )

        fun fromOperator(op: String) = operatorToOperationName[op]
        fun getOperation(operationName: OperationName?) =
            operationNameToOperation[operationName]
    }
}