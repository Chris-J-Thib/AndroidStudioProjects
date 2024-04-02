package com.gameDesignTips

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gameDesignTips.ui.theme.DaysOfGameDesignTheme
import java.time.LocalDate

//All images were generated at https://designer.microsoft.com/image-creator
val pics = arrayOf(
    R.drawable.define_your_vision,
    R.drawable.start_small,
    R.drawable.research,
    R.drawable.gdd,
    R.drawable.mechanics,
    R.drawable.iterate,
    R.drawable.difficulty,
    R.drawable.art,
    R.drawable.optimize,
    R.drawable.testing,
    R.drawable.story,
    R.drawable.accessibility,
    R.drawable.feedback,
    R.drawable.community,
    R.drawable.marketing,
    R.drawable.monetization,
    R.drawable.organized,
    R.drawable.failures,
    R.drawable.network,
    R.drawable.flexible,
    R.drawable.experience,
    R.drawable.sound,
    R.drawable.document,
    R.drawable.inspired,
    R.drawable.celebrate,
    R.drawable.trends,
    R.drawable.support,
    R.drawable.help,
    R.drawable.persistent,
    R.drawable.`fun`
)

class MainActivity : ComponentActivity() {
    @SuppressLint("ApplySharedPref")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //gets current date
        val today = LocalDate.now()

        //gets saved data
        val dates = getSharedPreferences("initDate", MODE_PRIVATE)

        //if first time running will set current date and the initial date
        if (dates.all.isEmpty()) {
            dates.edit().apply {
                putLong("Init", today.toEpochDay())
                commit()
            }
        }

        //how many days since initialization
        //val daysSinceInit = today.toEpochDay() - dates.getLong("Init", 0)

        val daysSinceInit = 50

        setContent {
            Main(minOf(daysSinceInit.toInt()+1, 30))

        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)

@RequiresApi(Build.VERSION_CODES.O)

@Composable
fun Main(count: Int = 3) {
    DaysOfGameDesignTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .height(LocalConfiguration.current.screenHeightDp.dp),
                content = {
                    item {
                        Text(
                            modifier = Modifier
                                .padding(20.dp),
                            fontSize = 24.sp,
                            text = stringResource(id = R.string.app_name)
                        )
                    }
                    items(count) {
                        CardBuilder(it)
                    }
                })
        }
    }


}

@Composable
fun CardBuilder(index: Int) {
    val expand = remember { mutableStateOf(false) }
    val content = stringArrayResource(id = R.array.Tips)[index].split(":")
    val title = content[0]
    val body = content[1]

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize()
        .height(if (expand.value) 550.dp else 200.dp)
        .padding(20.dp)
        .clickable { expand.value = !expand.value },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ) )
    {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                text = "Day ${index + 1}"
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp),
                fontSize = 20.sp,
                text = title
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = pics[index]),
                contentDescription = title
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                lineHeight = 20.sp,
                text = body
            )
        }

    }
}