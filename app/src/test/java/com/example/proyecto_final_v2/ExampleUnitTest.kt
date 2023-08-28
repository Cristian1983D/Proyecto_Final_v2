package com.example.proyecto_final_v2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class TextComparisonViewModelTest {

    private lateinit var viewModel: TextComparisonViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = TextComparisonViewModel()
    }

    @Test
    fun testTextComparisonSameTexts() {
        viewModel.text1.value = "Hello"
        viewModel.text2.value = "Hello"
        viewModel.compareTexts()
        val result = viewModel.comparisonResult.value
        assertEquals(true, result)
    }

    @Test
    fun testTextComparisonDifferentTexts() {
        viewModel.text1.value = "Hello"
        viewModel.text2.value = "World"
        viewModel.compareTexts()
        val result = viewModel.comparisonResult.value
        assertEquals(false, result)
    }
}
