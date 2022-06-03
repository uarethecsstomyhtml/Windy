package com.example.windyapp


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


class MainViewModel : ViewModel() {

    val sum by derivedStateOf {
        var result = ""
        numbers.forEach { numberFlow ->
            runBlocking(Dispatchers.IO) {
                result += numberFlow.first()
            }
            result += ("\n")
        }

        flowOf(result)
    }

    private val numbers = mutableStateListOf<Flow<Int>>()

    fun addNumber(number: Int) {
        val result = flow {
            delay((numbers.lastIndex + 1) * 100L)
            emit(number)
        }
        numbers.add(result)
    }

}