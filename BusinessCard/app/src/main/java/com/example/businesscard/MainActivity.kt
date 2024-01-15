package com.example.businesscard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color.Transparent)

    ) {
        Spacer(modifier = modifier.height(200.dp))
        ProfileSection(
            name = "Ammari Thaowan",
            title = "Androind Developer",
            modifier = modifier.weight(2f))
        ContactsSection()
    }
}

@Composable
fun ProfileSection(name: String, title: String, modifier: Modifier = Modifier) {
    var logoPic = painterResource(R.drawable.android_logo)
    Column(
//        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(10.dp)
    ) {
        Text(
            text = "Ammari Thaowan",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
//            modifier = modifier.padding(vertical = 10.dp)
        )
        Spacer(Modifier.height(10.dp))
        Image(
            painter = logoPic,
            contentDescription = "Android Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(150.dp)
                .background(Color.Black)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = title,
//            modifier = modifier.padding(vertical = 10.dp)
        )
    }
}

@Composable
fun ContactsSection(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
        .padding(10.dp)) {

        Contact(
            icons = Icons.Filled.Phone,
            content = "065-0458xxx",
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Contact(
            icons = Icons.Filled.Email,
            content = "tw.ammari@gmail.com",
            modifier = modifier.weight(1.5f)
        )
    }
}

@Composable
fun Contact(
    icons: ImageVector,
    describe: String? = null,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .fillMaxWidth()
    ) {
        Icon(
            imageVector = icons,
            contentDescription = describe,
            modifier = Modifier.width(16.dp),
//            tint = Color
        )
        Spacer(Modifier.width(5.dp))
        Text(
            text = content,
            fontSize = 12.sp,
            softWrap = false,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
//        ProfileSection("Android")
//        ContactsSection()
//        Contact(Icons.Filled.Phone, content = "065-0458xxx")
        BusinessCardApp()
    }
}