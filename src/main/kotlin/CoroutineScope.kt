import kotlinx.coroutines.*

private val scope  = CoroutineScope(Dispatchers.Default + CoroutineName("S100"))
fun main()
{

    val job = scope.launch(Dispatchers.IO  + CoroutineName("c100")) {
        println("$this")
        delay(3000)
        println("${coroutineContext[CoroutineName.Key]}")
        println(isCoroutineActive())
    }
    job.invokeOnCompletion {
        if (it is CancellationException) println("coroutine cancel") else println("coroutine complete")
    }

    Thread.sleep(200)
    onDestroy()
    println(isCoroutineActive())

}

private fun onDestroy()
{
    println("Cancel scope")
    scope.cancel()
}

private fun isCoroutineActive():Boolean
{
    return scope.isActive
}