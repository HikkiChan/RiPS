import java.util.*

class FillingUnit(name: String) : Thread(name) {

    private val lockObject = Object()
    private var queue = LinkedList<Car>()

    init {
        isDaemon = true
    }

    fun enqueue(car: Car) {
        synchronized(queue) {
            queue.addLast(car)
        }
        synchronized(lockObject) {
            lockObject.notify()
        }
    }

    fun dequeue(car: Car) = synchronized(queue) { queue.remove(car) }

    fun contains(car: Car) = synchronized(queue) { queue.contains(car) }

    fun queueSize() = synchronized(queue) { queue.size }

    fun indexOf(car: Car) = synchronized(queue) { queue.indexOf(car) }

    override fun run() {
        println("$name start work in the gas station")
        while (true) {
            try {
                synchronized(lockObject) {
                    while (queue.size == 0) {
                        lockObject.wait()
                    }
                }
                with(queue.peek()) {
                    synchronized(this) {
                        println("${this@FillingUnit.name} starts to fuel ${this.name}")
                        isBeingServed = true
                        Thread.sleep((10000 * Math.random()).toLong())
                        println("${this@FillingUnit.name} finishes fuelling ${this.name}")
                        isServed = true
                    }
                }
                synchronized(queue) { queue.poll() }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    override fun toString(): String {
        return name
    }
}