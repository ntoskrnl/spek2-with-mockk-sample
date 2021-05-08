package com.example.spek_mockk

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ExampleJUnit5Test {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun mockedTest() {
        val mock = mockk<Calculator>()

        every { mock.add(2, 2) } returns 5

        assertEquals(5, mock.add(2, 2))
    }

}