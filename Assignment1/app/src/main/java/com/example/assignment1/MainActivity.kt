import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.R

@Composable
fun LogoNameTitleSection() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.ic_android),
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )

        // Name and Title
        Text(
            text = "Christian Thibodeau",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "SODV Student",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun ContactInformationSection() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Phone Icon and Contact Number
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = TextFieldValue("123-456-7890"),
                onValueChange = {},
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.Black)
            )
        }

        // Title Icon and Job Title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = TextFieldValue("SocialMediaHandle"),
                onValueChange = {},
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.Black)
            )
        }

        // Email Icon and Email Address
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = TextFieldValue("your.email@example.com"),
                onValueChange = {},
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.Black)
            )
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LogoNameTitleSection()
        Spacer(modifier = Modifier.height(16.dp))
        ContactInformationSection()
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}
