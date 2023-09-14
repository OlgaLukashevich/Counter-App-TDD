package com.example.counter_app_tdd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.counter_app_tdd.ui.theme.CounterAppTDDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTDDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

class CounterViewModel {
    var count by mutableStateOf(0)
        private set

    fun incrementCount() {
        count++
    }

    fun resetCount() {
        count = 0
    }
}
@Composable
fun Counter() {
    val viewModel = remember { CounterViewModel() }
    val count = viewModel.count

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: $count",
            modifier = Modifier.weight(4f)
        )
        Button(
            onClick = { viewModel.incrementCount() }
        ) {
            Text("Click me")
        }
        Button(
            onClick = { viewModel.resetCount() }
        ) {
            Text("Reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterAppTDDTheme {
        Counter()
    }
}