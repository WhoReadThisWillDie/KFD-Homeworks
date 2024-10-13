sealed class Figure() {
    abstract val property: Double
}

data class Square(override val property: Double) : Figure()

data class Circle(override val property: Double) : Figure()