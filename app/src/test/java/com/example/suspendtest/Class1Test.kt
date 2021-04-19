package com.example.suspendtest

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.then
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class Class1Test {

    private lateinit var interface1: Interface1
    private lateinit var interface2: Interface2
    private lateinit var interface3: Interface3
    private lateinit var tested: Class1

    @Before
    fun setUp() {
        interface1 = mock(Interface1::class.java)
        interface2 = mock(Interface2::class.java)
        interface3 = mock(Interface3::class.java)
        tested = Class1(interface1, interface2, interface3, TestCoroutineScope())
    }

    @Test
    fun `should execute on interface2 after executing on interface1`() = runBlockingTest {
        whenever(interface2.execute()).thenReturn("string")
        tested.start()

        val captor = argumentCaptor<suspend () -> String>()
        verify(interface1).execute(captor.capture())
        captor.firstValue.invoke()

        then(interface3).should().execute("string")
    }
}