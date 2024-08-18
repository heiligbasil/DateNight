package com.heiligbasil.datenight

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.heiligbasil.datenight.ui.theme.DateNightTheme

@Composable
fun ScreenDetails(searchResult: SearchResult) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalDivider()
        Text(text = searchResult.title, fontSize = 50.sp, color = Color.Red)
        HorizontalDivider()
        Text(text = searchResult.description, fontSize = 25.sp, color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenDetailsPreview() {
    DateNightTheme(darkTheme = true) {
        ScreenDetails(sampleResults[0])
    }
}
