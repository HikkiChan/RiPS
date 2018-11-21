import java.util.*
import kotlin.collections.ArrayList

class FillingUnit(name: String) : Thread(name) {

    private var queue = Collections.synchronizedList(ArrayList<Car>())

    init {
        isDaemon = true
    }

    fun enqueue(car: Car) {
        queue.add(car)
    }

    fun dequeue(car: Car) = queue.remove(car)

    fun contains(car: Car) = queue.contains(car)

    fun queueSize() = queue.size

    fun indexOf(car: Car) = queue.indexOf(car)

    override fun run() {
        println("$name start work in the gas station")
        while (true) {
            try {
                while (queue.size == 0) {
                    sleep(100)
                }
                with(queue[0]) {
                    println("${this@FillingUnit.name} starts to fuel ${this.name}")
                    isBeingServed = true
                    Thread.sleep((10000 * Math.random()).toLong())
                    println("${this@FillingUnit.name} finishes fuelling ${this.name}")
                    isServed = true
                }
                queue.removeAt(0)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }
    override fun toString(): String {
        return name
    }
}