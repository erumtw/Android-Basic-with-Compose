package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Quadrant("Android", "version 14")
                    AllQuadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant(topic: String, body: String, bgColor: Color, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(16.dp)
    ) {
        Text(
            text = topic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun AllQuadrant(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxWidth()
    ){
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                topic = stringResource(R.string.top_left_topic),
                body = stringResource(R.string.top_left_body),
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier
                    .weight(1f)
            )
            Quadrant(
                topic = stringResource(R.string.top_right_topic),
                body = stringResource(R.string.top_right_body),
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )

        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                topic = stringResource(id = R.string.bt_left_topic),
                body = stringResource(id = R.string.bt_left_body),
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                topic = stringResource(R.string.bt_right_topic),
                body = stringResource(R.string.bt_right_body),
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
//        Quadrant("Text composable", "Displays text and follows the recommended Material Design guidelines.", bgColor = Color(0xFFF6EDFF),)
        AllQuadrant()
    }
}