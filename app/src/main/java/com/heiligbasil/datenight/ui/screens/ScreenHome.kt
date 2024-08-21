package com.heiligbasil.datenight.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.heiligbasil.datenight.R
import com.heiligbasil.datenight.ui.theme.DateNightTheme
import com.heiligbasil.datenight.ui.theme.onPrimaryLight

@Composable
fun ScreenHome(onNavigateToScreenResults: (searchQuery: String) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        BackgroundImage(R.drawable.background1, R.string.background1_credit)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            ScreenTitle()
            HorizontalDivider()
            UserImageAndName(
                R.drawable.profile1,
                R.string.profile1_credit,
                R.string.profile1_name
            )
            HorizontalDivider()
            SearchButton(onNavigateToScreenResults)
        }
    }
}

@Composable
fun ScreenTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
private fun UserImageAndName(image: Int, imageCredit: Int, name: Int) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .width(IntrinsicSize.Max)
            .padding(all = 10.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = imageCredit),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(1.dp, onPrimaryLight, CircleShape),
            alignment = Alignment.CenterStart
        )
        Spacer(modifier = Modifier.width(10.dp))
        val profileGreeting = stringResource(id = R.string.generic_profile_greeting)
        val profileName = stringResource(id = name)
        Text(text = "$profileGreeting $profileName", color = onPrimaryLight, fontSize = 16.sp)
    }
}

@Composable
fun SearchButton(onNavigateToScreenResults: (searchQuery: String) -> Unit) {
    var enabled by remember { mutableStateOf(true) }
    Button(onClick = {
        enabled = false
        onNavigateToScreenResults("date night ideas involving nature")
    }, content = {
        Text(text = "Search")
    },
        enabled = enabled
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenHomePreview() {
    DateNightTheme(darkTheme = true) {
        ScreenHome {}
    }
}
