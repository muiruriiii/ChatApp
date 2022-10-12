package com.android.chatapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                Surface {
                    TextConversation(TextMessages.groupConversation)
                }
            }
        }
    }
}

data class User (
    val username: String = "Bot",
    val img: Int = R.drawable.profile_default,
    val nameColor: Color = Color(0xFF018786)
)

data class TextMessage (
    val user: User,
    val body: String)

@Composable
fun TextMessageCard(text: TextMessage) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(id = text.user.img),
            contentDescription = "Profile Picture of" +  text.user.username ,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        val surfaceColor by animateColorAsState(
            if (isExpanded) Color(0xFF26BD4B) else MaterialTheme.colors.surface,
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = text.user.username,
                color = text.user.nameColor,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.width(8.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = text.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                    style = MaterialTheme.typography.body2,
                    color = if (isExpanded) Color(0xFFFFFFFF) else Color(0xFF0EB34D)
                )
            }
        }
    }
}


@Composable
fun TextConversation(texts: List<TextMessage>) {
    LazyColumn {
        items(texts) { text ->
            TextMessageCard(text = text)
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode")
@Composable
fun PreviewTextConversation() {
    ChatAppTheme {
        Surface {
            TextConversation(TextMessages.groupConversation)
        }
    }
}
