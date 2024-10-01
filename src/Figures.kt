sealed class Figure(val property: Double)

data class Square(val size: Double) : Figure(size) {
    init {
        this.toString()
    }
}

data class Circle(val radius: Double) : Figure(radius) {
    init {
        this.toString()
    }
}