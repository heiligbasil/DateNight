package com.heiligbasil.datenight

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.heiligbasil.datenight.ui.theme.DateNightTheme
import com.heiligbasil.datenight.ui.theme.inverseOnSurfaceLight
import com.heiligbasil.datenight.ui.theme.onPrimaryLight
import com.heiligbasil.datenight.ui.theme.primaryContainerLight

@Composable
fun ScreenResults(onNavigateToScreenDetails: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(15) { index ->
            Card(
                border = BorderStroke(1.dp, inverseOnSurfaceLight),
                modifier = Modifier
                    .padding(start = 2.dp, end = 2.dp, bottom = 4.dp)
                    .fillMaxSize(),
                onClick = onNavigateToScreenDetails
            ) {
                Row {
                    ConstraintLayout {
                        val (icon, number) = createRefs()
                        val contentDescriptionPrefix =
                            stringResource(id = R.string.search_results_icon_description)
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            tint = primaryContainerLight,
                            modifier = Modifier
                                .size(80.dp)
                                .constrainAs(icon) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                },
                            contentDescription = "$contentDescriptionPrefix ${index + 1}"
                        )
                        Text(
                            text = (index + 1).toString(),
                            color = onPrimaryLight,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(start = 25.dp, top = 20.dp, end = 41.dp)
                                .constrainAs(number) {
                                    top.linkTo(icon.top)
                                    //bottom.linkTo(parent.bottom)
                                    start.linkTo(icon.start)
                                    end.linkTo(icon.end)
                                }
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(
                            text = sampleResults.get(index).title,
                            color = onPrimaryLight,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(bottom = 5.dp)
                        )
                        Text(
                            text = sampleResults.get(index).description,
                            color = onPrimaryLight,
                            fontSize = 10.sp,
                            lineHeight = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenResultsPreview() {
    DateNightTheme(darkTheme = true) {
        ScreenResults {}
    }
}
