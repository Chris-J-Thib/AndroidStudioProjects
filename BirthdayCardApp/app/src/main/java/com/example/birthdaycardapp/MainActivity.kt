package com.example.birthdaycardapp

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycardapp.ui.theme.BirthdayCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage()
                }
            }
        }
    }
}

@Composable
fun GreetingText(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = stringResource(id = R.string.msg),
            fontSize = 100.sp,
            lineHeight = 130.sp,
            textAlign = TextAlign.Center
        )
        Text (
            text = stringResource(id = R.string.from),
            fontSize =  40.sp,
            fontStyle = FontStyle.Italic,
            lineHeight = 45.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(20.dp)
        )
    }
}

@Composable
fun GreetingImage(){
    val image = painterResource(id = R.drawable.androidparty)
    Box(){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        GreetingText(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCardAppTheme {
        GreetingImage()

    }
}