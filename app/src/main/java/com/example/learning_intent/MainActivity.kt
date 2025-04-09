package com.example.learning_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learning_intent.ui.theme.Learning_intentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Learning_intentTheme {
                FirstScreen()
            }
        }
    }
}

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("First Activity")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                context.startActivity(
                    Intent(context, SecondActivity::class.java).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK
                    )
                )
            },
        ) {
            Text("2st Activity")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun FirstScreenPrev() {
    FirstScreen()
}