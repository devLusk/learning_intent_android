package com.example.learning_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.unit.dp
import com.example.learning_intent.ui.theme.Learning_intentTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learning_intentTheme {
                SecondActivityScreen()
            }
        }
    }
}

@Composable
fun SecondActivityScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Second Activity")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            try {
                context.startActivity(
                    Intent(Intent.ACTION_MAIN).apply {
                        setPackage("com.google.android.youtube")
                    }
                )
            } catch (e: Exception) {
                Toast.makeText(context, "YouTube is not installed", Toast.LENGTH_SHORT).show()
            }
        }) { Text("Open YouTube") }
    }
}