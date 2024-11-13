fun main() {
    val threadPool = ThreadPool(3)

    Thread.sleep(1000)

    threadPool.execute {
        println("task1 started")
        Thread.sleep(1000)
        println("task1 finished")
    }
    threadPool.execute {
        println("task2 started")
        Thread.sleep(1000)
        println("task2 finished")

    }
    threadPool.execute { // запуск трёх задач, симулирующих долгие вычисления
        println("task3 started")
        Thread.sleep(1000)
        println("task3 finished")
    }

    threadPool.execute { // четвертая задача должна начать выполняться только после завершения одной из первых трёх
        println("task4 started")
        Thread.sleep(1000)
        println("task4 finished")
    }

    threadPool.shutdown(false)
}