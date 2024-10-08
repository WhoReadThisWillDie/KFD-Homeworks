interface ConsoleService {
    fun work()
}

object ConsoleServiceImpl : ConsoleService {
    override fun work() {
        while (true) {
            print(
                """    
                Введите тип операции, которую хотите исполнить:
                1) Добавить фигуру
                2) Получить площадь всех фигур
                3) Получить периметр всех фигур
                4) Завершить выполнение
                
                """.trimIndent()
            )

            try {
                val operation = getOperation(readln())

                when (operation) {
                    Operation.INSERT -> addFigure()
                    Operation.GET_AREA -> getArea()
                    Operation.GET_PERIMETER -> getPerimeter()
                    Operation.EXIT -> break
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    @Throws(WrongOperationTypeException::class)
    private fun getOperation(input: String): Operation {
        return when (input) {
            "1" -> Operation.INSERT;
            "2" -> Operation.GET_AREA;
            "3" -> Operation.GET_PERIMETER;
            "4" -> Operation.EXIT;
            else -> throw WrongOperationTypeException(input)
        }
    }

    @Throws(UnsupportedFigureException::class, BadPropertyException::class)
    private fun addFigure() {
        println("Введите фигуру в формате <фигура> <размер>")
        val input = readln().split(" ")

        try {
            val property: Double = input[1].toDouble()
            if (property <= 0 || property.isNaN()) throw BadPropertyException(input[1])

            when (val figureName: String = input[0]) {
                "Circle" -> FigureServiceImpl.addCircle(property)
                "Square" -> FigureServiceImpl.addSquare(property)
                else -> throw UnsupportedFigureException(figureName)
            }

            println("Фигура добавлена")
        } catch (e: NumberFormatException) {
            throw BadPropertyException(input[1])
        } catch (e: IndexOutOfBoundsException) {
            throw Exception("Некорректный ввод")
        }
    }

    private fun getArea() {
        println("Площадь всех фигур: ${FigureServiceImpl.getArea()}")
    }

    private fun getPerimeter() {
        println("Периметр всех фигур: ${FigureServiceImpl.getPerimeter()}")
    }
}