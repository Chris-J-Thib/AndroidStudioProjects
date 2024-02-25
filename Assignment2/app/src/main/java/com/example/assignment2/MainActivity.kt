package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpace()
        }
    }
}

@Preview
@Composable
fun ArtSpace() {
    val context = LocalContext.current
    val resources = context.resources
    val currentIndex = remember { mutableStateOf(0) }
    val descriptions = resources.getStringArray(R.array.descriptions)
    val typedArray = context.resources.obtainTypedArray(R.array.Images)
    val images = (0 until typedArray.length()).map { typedArray.getResourceId(it, 0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(modifier = Modifier
            .padding(20.dp)
            .shadow(
                elevation = 15.dp,
                shape = RectangleShape
            ),
            shape = RectangleShape

        ){
            Image(
                painter = painterResource(id = images[currentIndex.value]),
                contentDescription = descriptions[currentIndex.value],
                modifier = Modifier
                    .padding(20.dp)
                    .size(470.dp)

            )
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .background(Color(0x1A000000))
        ){
            Text(text = resources
                        .getResourceEntryName(images[currentIndex.value])
                        .split("_")
                        .joinToString(" ")
                        {it.capitalize(Locale.ROOT)},
                    fontSize = 30.sp,
                    fontWeight = FontWeight(100),
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(20.dp,10.dp,0.dp,2.dp)
                        .fillMaxWidth())


            Text(text = descriptions[currentIndex.value],
                fontSize = 10.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(20.dp,3.dp,0.dp,10.dp)
                    .fillMaxWidth())
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(25.dp,10.dp)
                .fillMaxWidth()
        ) {
            Button(modifier = Modifier
                        .size(150.dp,40.dp),
                onClick = {
                    currentIndex.value = (currentIndex.value - 1 + images.size) % images.size
                }) {Text("Previous")}

            Button(modifier = Modifier
                        .size(150.dp,40.dp),
                onClick = {
                    currentIndex.value = (currentIndex.value + 1) % images.size
                }) {Text("Next")}
        }
    }
    typedArray.recycle()
}