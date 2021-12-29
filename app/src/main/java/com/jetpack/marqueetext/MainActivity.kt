package com.jetpack.marqueetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.marqueetext.ui.theme.MarqueeTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val myId = "inlineContent"
            val text = buildAnnotatedString {
                append("Do you like Jetpack Compose? ")
                appendInlineContent(myId, "icon")
            }
            val inlineContent = mapOf(
                Pair(
                    myId,
                    InlineTextContent(
                        Placeholder(
                            width = 15.sp,
                            height = 15.sp,
                            placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Like",
                            tint = Color.Red
                        )
                    }
                )
            )

            MarqueeTextTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Marquee & Inline Text",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Marquee Text",
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                            MarqueeText(
                                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                gradientEdgeColor = Color.White.copy(alpha = 0.9f)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            MarqueeText(
                                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                gradientEdgeColor = Color.White.copy(alpha = 0.9f)
                            )
                            Spacer(modifier = Modifier.height(100.dp))
                            Text(
                                text = "Inline Text Content with Image/Icon",
                                color = Color.Red,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = text,
                                inlineContent = inlineContent,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}




















