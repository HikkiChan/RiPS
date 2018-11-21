class Car(name: String) : Thread(name) {
    @Volatile
    var isServed = false
    var isBeingServed = false

    override fun run() {
        Thread.sleep((10000 * Math.random()).toLong())
        println("$name enters the gas station")
        while (!isServed) {
            if (!isBeingServed) {
                GasStation.moveCarToShortestQueue(this)
                sleep(100)
            }
        }
        println("$name leaves the gas station")
    }
}