class BadPropertyException(private val property: String) : IllegalArgumentException() {

    override val message: String
        get() = "Введено неверное значение параметра property: $property\n"
}

class UnsupportedFigureException(private val figureName: String) : IllegalArgumentException() {
    override val message: String
        get() = "Данный тип фигуры не поддерживается: $figureName\n"
}

class WrongOperationTypeException(private val operation: String) : IllegalArgumentException() {
    override val message: String
        get() = "Введен неизвестный тип операции: $operation\n"
}