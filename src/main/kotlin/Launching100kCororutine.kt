import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    println("Thread name = ${Thread.currentThread().name}")
    repeat(1_000_000)
    {
        launch {
            delay(3000)
            print(".")
        }
    }
}

