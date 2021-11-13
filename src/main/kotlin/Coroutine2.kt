import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main()
{
//    create100kThreads()
    create100kCoroutines()
}

fun create100kThreads()
{

    var duration = measureTimeMillis {
        repeat(100_00)
        {
            thread {
                Thread.sleep(3000)
                print(".")
            }
        }
    }
    print("Time = ${duration/1000} seconds")

}


fun create100kCoroutines() = runBlocking()
{

    var duration = measureTimeMillis {
        repeat(100_000)
        {
            launch {
                delay(3000)
                print(".")
            }
        }
    }
    print("Time = ${duration/1000} seconds")

}