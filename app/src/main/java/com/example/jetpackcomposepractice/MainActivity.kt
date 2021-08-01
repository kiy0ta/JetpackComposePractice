package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
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
    var isSelected by remember { mutableStateOf(false) }
    // animateColorAsStateは2色の中間色を自動で補完する
    val backGroundColor by animateColorAsState(if (isSelected) Color.Magenta else Color.Transparent)
    Text(
        text = "Hello , $name",
        modifier = Modifier
            .padding(24.dp)
            .background(color = backGroundColor)
            .clickable(onClick = { isSelected = !isSelected })
    )
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
    // UIを再構成する際に失いたくないデータはrememberを使用して、覚えておくことができる
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            NameList(names = names)
//            for (name in names) {
//                Hello("Hello,$name")
//                Divider(color = Color.Black)
//            }
//            Divider(color = Color.Transparent, thickness = 32.dp)
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount -> counterState.value = newCount }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(backgroundColor = if (count % 2 == 1) Color.Blue else Color.Red)
    ) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    // LazyColumnはスクロール可能な列を表示する
    // 画面に表示されている要素のみをレンダリングするため、大きなリストをレンダリングするときにパフォーマンスを向上させることができる
    LazyColumn(modifier = modifier) {
        items(items = names) { it ->
            Hello(name = it)
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