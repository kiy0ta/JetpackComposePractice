package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractice.ui.theme.JetpackComposepracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposepracticeTheme {
        // Surfaceはviewの方をimportするとエラーになる
        // 背景色の設定
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Hello(name: String) {
    Text(text = "Hello , $name", modifier = Modifier.padding(24.dp))
}

@Composable
fun MyScreenContent(names: List<String> = listOf("tanaka", "YAMADA")) {
    Column {
        for (name in names) {
            Hello("Hello,$name")
            Divider(color = Color.Black)
        }
    }
}

@Preview("Text preview")
@Composable
fun preview() {
    MyApp {
        MyScreenContent()
    }
}