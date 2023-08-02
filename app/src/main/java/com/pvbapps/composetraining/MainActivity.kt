package com.pvbapps.composetraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pvbapps.composetraining.ui.theme.ComposeTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTrainingTheme {
                MyApp(
                    modifier = Modifier.fillMaxSize(),
                    names = listOf("Apuli", "Compose")
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(
        modifier = Modifier.padding(vertical = 4.dp),
        color = MaterialTheme.colorScheme.primary,
    ) {
        Row() {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(text = "Hello,")
                Text(text = "$name!")
            }
            ShowMore(modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .weight(weight = 1f, fill = true)
                .padding(horizontal = 24.dp)
            )
        }
    }
}

@Composable
fun ShowMore(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    ) {
        Box {
            ElevatedButton(
                modifier = Modifier
                    .align(alignment = Alignment.CenterEnd),
                onClick = {}
            ) {
                Text(text = "Show more")
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, names: List<String>) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeTrainingTheme {
        MyApp(names = listOf("Apuli", "Default"))
    }
}