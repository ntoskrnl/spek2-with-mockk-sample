package com.example.spek_mockk

import io.mockk.every
import io.mockk.mockk
import org.spekframework.spek2.Spek
import org.spekframework.spek2.lifecycle.CachingMode.EACH_GROUP
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object ExampleSpekTest : Spek({

    describe("2 + 2") {

        it("2 + 2 should be 4") {
            assertEquals(expected = 4, actual = 2 + 2)
        }
    }

    describe("2 + 2 with mock") {

        context("mocked calculator") {

            val calculator by memoized(EACH_GROUP) { mockk<Calculator>() }

            beforeGroup {
                // crashes when running from Android Studio:
                // java.lang.NoClassDefFoundError: io/mockk/proxy/MockKAgentFactory
                every { calculator.add(2, 2) } returns 5
            }

            it("should be 5") {
                assertEquals(expected = 5, actual = calculator.add(2, 2))
            }
        }
    }
})