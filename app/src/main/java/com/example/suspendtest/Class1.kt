package com.example.suspendtest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class Class1(
    private val interface1: Interface1,
    private val interface2: Interface2,
    private val interface3: Interface3,
    private val coroutineScope: CoroutineScope
) {

    fun start() {

        coroutineScope.launch {
            val string = interface2.execute() // interface1.execute { interface2.execute() }
            interface3.execute(string)
        }

    }

}

interface Interface1 {
    suspend fun execute(block: suspend () -> String): String
}

interface Interface2 {
    suspend fun execute(): String
}

interface Interface3 {
    fun execute(string: String)
}

