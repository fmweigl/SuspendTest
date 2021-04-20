package com.example.suspendtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), Interface1, Interface2, Interface3 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c = Class1(this, this, this, GlobalScope)
        c.start()
    }

    override suspend fun execute(block: suspend () -> String): String {
        Log.d("xyz1", "execute interface1")
        return block()
    }

    override suspend fun execute(): String {
        Log.d("xyz1", "execute interface2")
        return "someString"
    }

    override fun execute(string: String) {
        Log.d("xyz1", "execute interface3 $string")
    }
}