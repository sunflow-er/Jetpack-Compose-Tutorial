package org.javaapp.jetpackcompose

import android.content.res.Configuration
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.javaapp.jetpackcompose.ui.theme.JetpackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JetpackComposeTheme { // Material Theme
                Surface(modifier = Modifier.fillMaxSize()) { // Surface
                    MessageCard(Message("Android", "Jetpack Compose"))
                }
            }

        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp) // Set image size to 40dp
                .clip(CircleShape) // Clip image to be shaped as a Circle
                .border(
                    1.5.dp,
                    MaterialTheme.colorScheme.primary,
                    CircleShape
                ) // Material Design - Color
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary, // Material Design - Color
                style = MaterialTheme.typography.titleSmall // Material Design - Typography
            )
            Spacer(modifier = Modifier.height(4.dp)) // Add a vertical space between the author and message texts

            Surface (shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) { // Material Design - Shape
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}


@Preview(name = "Light Mode") // 에뮬레이터가 아닌 안드로이드 스튜디오 내에서 미리 볼 수 있음, 매개변수가 없는 Composable 함수에 사용 가능
@Preview (
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    JetpackComposeTheme {
        Surface {
            MessageCard(
                Message(
                    "Lexi", "Hey, take a look at Jetpack Compose, it's great!"
                )
            )
        }
    }

}


