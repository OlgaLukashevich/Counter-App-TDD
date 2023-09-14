package com.example.counter_app_tdd

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CounterViewModelTest {

    @Test
    fun `initial count should be 0`() {
        val viewModel = CounterViewModel()
        val count = viewModel.getCurrentCount()
        assertEquals(0, count)
    }

    @Test
    fun `incrementCount should increase count by specified amount`() {
        val viewModel = CounterViewModel()
        val incrementAmount = 5
        repeat(incrementAmount) {
            viewModel.incrementCount()
        }
        val count = viewModel.getCurrentCount()
        assertEquals(incrementAmount, count)
    }

@Test
fun `getCurrentCount should return non-negative count`() {
    val viewModel = CounterViewModel()
    val count = viewModel.getCurrentCount()
    assertTrue(count >= 0)
}
}