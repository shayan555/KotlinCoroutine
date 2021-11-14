import kotlinx.coroutines.*

fun main() = runBlocking<Unit>{

//    println("Main Started")
//    GlobalScope.launch {
//        println("Some work started")
//        delay(3000)
//        println("Work completed")
//    }
//
//    Thread.sleep(4000)
//    println("Main ends")

    val resultList = mutableListOf<String>()

    val job1 = async {
        return@async doNetworkRequest(1)
    }

    val job2 = async {
        return@async doNetworkRequest(2)
    }
    resultList.add(job1.await())
    resultList.add(job2.await())

    println("Result is : $resultList")

    println("runBlocking complete")

}
private suspend fun doNetworkRequest(number:Int): String {
    println("network request $number started")
    delay(500)
    return "network request $number complete"
}

