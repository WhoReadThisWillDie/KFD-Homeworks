import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.locks.ReentrantLock

class ThreadPool(threadCount: Int) : Executor {
    private val tasksQueue = LinkedList<Runnable>()

    private var isRunning = true
    private val lock = ReentrantLock()
    private val queueIsNotEmpty = lock.newCondition()

    private val threads = List<Thread>(threadCount) {
        Thread {
            while (true) {
                var task: Runnable?
                lock.lock()

                try {
                    while (tasksQueue.isEmpty() && isRunning) {
                        queueIsNotEmpty.await()
                    }
                    if (tasksQueue.isEmpty() && !isRunning) {
                        return@Thread
                    }

                    task = tasksQueue.poll()
                } finally {
                    lock.unlock()
                }

                try {
                    if (!Thread.currentThread().isInterrupted) task?.run()
                } catch (_: InterruptedException) {
                    Thread.currentThread().interrupt()
                    println("Task is cancelled as ThreadPool was shut down")
                }
            }
        }
    }

    init {
        threads.forEach { it.start() }
    }

    override fun execute(command: Runnable) {
        lock.lock()
        try {
            tasksQueue.add(command)
            queueIsNotEmpty.signal()
        } finally {
            lock.unlock()
        }
    }

    fun shutdown(wait: Boolean) {
        lock.lock()
        try {
            isRunning = false
            queueIsNotEmpty.signalAll()
        } finally {
            lock.unlock()
        }

        if (wait) threads.forEach { it.join() }
        else {
            threads.forEach { it.interrupt() }
        }
    }
}