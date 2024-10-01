interface FigureService {
    fun addSquare(property: Double)
    fun addCircle(property: Double)
    fun getPerimeter(): Double
    fun getArea(): Double
}

object FigureServiceImpl : FigureService {
    private val figureList: MutableList<Figure> = mutableListOf()

    override fun addSquare(property: Double) {
        figureList.add(Square(property))
    }

    override fun addCircle(property: Double) {
        figureList.add(Circle(property))
    }

    override fun getPerimeter(): Double {
        var result: Double = 0.0

        for (figure in figureList) {
            result += when (figure) {
                is Circle -> 2 * Math.PI * figure.property
                is Square -> 4 * figure.property
            }
        }

        return result
    }

    override fun getArea(): Double {
        var result: Double = 0.0

        for (figure in figureList) {
            result += when (figure) {
                is Circle -> Math.PI * figure.property * figure.property
                is Square -> figure.property * figure.property
            }
        }

        return result
    }
}