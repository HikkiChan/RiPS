import java.util.*
import java.util.concurrent.locks.ReentrantLock

object GasStation {

    private val lock = ReentrantLock()
    private val fillingUnit = initFillingUnit()

    init {
        fillingUnit.forEach { it.start() }
        initCars()
    }

    private fun initFillingUnit() = LinkedList<FillingUnit>().apply {
        for (i in 1..3) {
            add(FillingUnit("Filling unit $i"))
        }
    }

    private fun initCars() {
        for (i in 1..10) {
            Car("Car $i").start()
        }
    }

    private fun getCurrentFillingUnit(car: Car) = fillingUnit.firstOrNull { it.contains(car) }

    fun moveCarToShortestQueue(car: Car) {
        val currentFillingUnit = getCurrentFillingUnit(car)

        val minQueue = fillingUnit.minBy { it.queueSize() }!!

        if (currentFillingUnit == null || minQueue.queueSize() < currentFillingUnit.indexOf(car)) {
            currentFillingUnit?.dequeue(car)
            println("${car.name} leaves ${currentFillingUnit?.name ?: "parking"} and goes to ${minQueue.name}")
            minQueue.enqueue(car)
        }
        lock.unlock()
    }
}