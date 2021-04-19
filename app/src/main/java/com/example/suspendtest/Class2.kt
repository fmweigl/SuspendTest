package com.example.suspendtest

class Class2(private val c3: Class3) {

    fun start() {
//        c3.increase()
    }

}

fun Class3.increase() {
//    this.x = x + 1
}

open class Class3() {
    var x = 0
}