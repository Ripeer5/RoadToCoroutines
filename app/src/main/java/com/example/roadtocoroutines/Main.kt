package com.example.roadtocoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain

fun main() {
    val mainThreadSurrogate = newSingleThreadContext("UI thread")
    Dispatchers.setMain(mainThreadSurrogate)
    val job = GlobalScope.launch(Dispatchers.Default) {
        println("begin")

        delay(2000)
        withContext(Dispatchers.Main) {
            println("dispMain = ${Thread.currentThread().id}")
        }


        /*println("thread main ? : ${Thread.currentThread().id}")
        val test = async(Dispatchers.Main){
            println("thread : ${Thread.currentThread().id} ")
            returnString()
        }
        *//*val texteEnSortieDeCor = task.await()*//*
        println("retour de l'async : ${test.await()}")
*/
    }
    runBlocking {
        job.join()
    }
    println("de retour sur le premier thread: ${Thread.currentThread().id}")
}

