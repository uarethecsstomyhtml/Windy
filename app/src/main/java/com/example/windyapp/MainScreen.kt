package com.example.windyapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf

@Composable
fun MainScreen(viewModel: MainViewModel) {
    var number by remember {
        mutableStateOf("")
    }

    val sum = viewModel.sum.collectAsState(initial = "")

    Column {
        TextField(
            value = number,
            onValueChange = { number = it },
            modifier = Modifier.fillMaxWidth().padding(all = 16.dp),
            label = { Text(stringResource(id = R.string.hint_enter_number)) }
        )
        Button(
            onClick = { viewModel.addNumber(number.toInt()) },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.action_start))
        }
        Text(text = sum.value, modifier = Modifier.padding(all = 16.dp))
    }
}