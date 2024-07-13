import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

suspend fun main(args: Array<String>) = coroutineScope {
    // do background work here
    var i = 0
    while (isActive) {
        println("active for ${++i} sec")
        delay(1000)
    }
}