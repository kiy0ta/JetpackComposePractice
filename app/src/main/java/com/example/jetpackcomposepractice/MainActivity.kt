package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractice.ui.theme.JetpackComposepracticeTheme

/**
 * 勉強用
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposepracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column {
            // importが3種類あるので注意すること
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth() // match-parent
                    .clip(shape = RoundedCornerShape(20.dp)),// 画像の角を丸める
                contentScale = ContentScale.Crop // 画像の幅が、列の幅いっぱいになるように調整する
            )

            // ImageとText Columnの間にスペースを開けるためのプロパティ
            Spacer(Modifier.height(16.dp))

            // 列を使用したい場合
            Column {
                Text(
                    text = "この例では、記事のタイトルは非常に短いものでした。しかし、記事のタイトルが長すぎるような場合、それによってアプリの外観が損なわれることは望ましくありません。最初のテキスト要素を変更してみます",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis // 長すぎる場合は、表示されるテキストを自動的に切り捨てる
                )
                Text(text = "I am $name", style = typography.body1)
            }
            // スタイルを設定したい場合
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Hello $name!")
                Text(text = "I am $name")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposepracticeTheme {
        Greeting("Android")
    }
}