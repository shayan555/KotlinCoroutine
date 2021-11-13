import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    println("Main started")
    joinAll(async { coroutineOne() },
            async { coroutineTwo() }
    )
    println("Main ends")
}
suspend fun coroutineOne()
{
    println("Coroutine one started")
    delay(3000)
    println("Coroutine one complete")
}

suspend fun coroutineTwo()
{
    println("Coroutine Two started")
    delay(2000)
    println("Coroutine Two complete")
}