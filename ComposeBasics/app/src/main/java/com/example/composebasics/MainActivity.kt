package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main3()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Main1(){
    Column {
        TutImage(R.drawable.screenshot_2024_01_22_141641)
        Text(
            text = stringResource(id = R.string.Title),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(id = R.string.P1),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.P2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Main2(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TutImage(path = R.drawable.ic_task_completed, ContentScale.Fit)
        Text(
            text = stringResource(id = R.string.Noti),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.msg),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Main3(){
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f),
        ){
            Tile(
                head = stringResource(id = R.string.TLH),
                para = stringResource(id = R.string.TLP),
                modifier = Modifier
                    .background(colorResource(id = R.color.TL))
                    .fillMaxWidth(.5f))
            Tile(
                head = stringResource(id = R.string.TRH),
                para = stringResource(id = R.string.TRP),
                modifier = Modifier
                    .background(colorResource(id = R.color.TR))
                    .fillMaxWidth())
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Tile(
                head = stringResource(id = R.string.BLH),
                para = stringResource(id = R.string.BLP),
                modifier = Modifier
                    .background(colorResource(id = R.color.BL))
                    .fillMaxWidth(.5f))
            Tile(
                head = stringResource(id = R.string.BRH),
                para = stringResource(id = R.string.BRP),
                modifier = Modifier
                    .background(colorResource(id = R.color.BR))
                    .fillMaxWidth())
        }
    }
}

@Composable
fun TutImage(path: Int, scale: ContentScale = ContentScale.Crop){
    val img = painterResource(id = path)
    Image(
        painter = img,
        contentScale = scale,
        contentDescription = "img",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Tile(modifier: Modifier = Modifier, head: String, para: String){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp)
    ){
        Text(
            text = head,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = para,
            textAlign = TextAlign.Justify,
            lineHeight = 32.sp
        )
    }
}
