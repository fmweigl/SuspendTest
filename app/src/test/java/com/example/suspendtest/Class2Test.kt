package com.example.suspendtest

import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class Class2Test {

    private lateinit var c3: Class3
    private lateinit var tested: Class2

    @Before
    fun setUp() {
        c3 = mock()
        tested = Class2(c3)
    }

    @Test
    fun `should increase`() {
        tested.start()

        verify(c3).increase()
    }

}