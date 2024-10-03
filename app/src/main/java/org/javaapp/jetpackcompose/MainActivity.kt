package org.javaapp.jetpackcompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image (
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp) // Set image size to 40dp
                .clip(CircleShape) // Clip image to be shaped as a Circle
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp)) // Add a vertical space between the author and message texts
            Text(text = msg.body)
        }
    }
}

@Preview // 에뮬레이터가 아닌 안드로이드 스튜디오 내에서 미리 볼 수 있음, 매개변수가 없는 Composable 함수에 사용 가능
@Composable
fun PreviewMessageCard() {
    MessageCard(
        Message(
            "Lexi", "Hey, take a look at Jetpack Compose, it's great!"
        )
    )
}
