package com.heiligbasil.datenight.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.heiligbasil.datenight.R
import com.heiligbasil.datenight.Utils.urlDecode
import com.heiligbasil.datenight.ui.entities.SearchResult
import com.heiligbasil.datenight.ui.entities.SearchResult.Companion.defaultImage
import com.heiligbasil.datenight.ui.entities.sampleResults
import com.heiligbasil.datenight.ui.theme.DateNightTheme
import com.heiligbasil.datenight.ui.theme.inverseOnSurfaceLight
import com.heiligbasil.datenight.ui.theme.onPrimaryLight
import com.heiligbasil.datenight.ui.theme.primaryContainerLight

@Composable
fun ScreenResults(
    searchResults: ArrayList<SearchResult>,
    onNavigateToScreenDetails: (SearchResult) -> Unit
) {
    BackgroundImage(R.drawable.background1, R.string.background1_credit)
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(searchResults.size) { index ->
            Card(
                border = BorderStroke(1.dp, inverseOnSurfaceLight),
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                onClick = {
                    onNavigateToScreenDetails(searchResults[index])
                }
            ) {
                Row {
                    ConstraintLayout {
                        val (image, icon, number) = createRefs()
                        val iconDescription = R.string.search_results_icon_description
                        val iconContentDescription = stringResource(id = iconDescription)
                        val imageDescription = R.string.search_results_image_description
                        val imageContentDescription = stringResource(id = imageDescription)
                        val defaultImage = painterResource(id = defaultImage)
                        AsyncImage(
                            model = searchResults[index].imageUrl?.urlDecode(),
                            placeholder = defaultImage,
                            error = defaultImage,
                            fallback = defaultImage,
                            contentDescription = "$imageContentDescription ${index + 1}",
                            contentScale = ContentScale.FillBounds,
                            clipToBounds = true,
                            modifier = Modifier
                                .size(100.dp)
                                .constrainAs(image) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                }
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            tint = primaryContainerLight,
                            modifier = Modifier
                                .size(100.dp)
                                .constrainAs(icon) {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                },
                            contentDescription = "$iconContentDescription ${index + 1}"
                        )
                        Text(
                            text = (index + 1).toString(),
                            color = onPrimaryLight,
                            fontSize = 20.sp,
                            style = TextStyle.Default.copy(
                                color = primaryContainerLight,
                                drawStyle = Stroke(
                                    miter = 10f,
                                    width = 4.dp.value,
                                    join = StrokeJoin.Bevel
                                )
                            ),
                            modifier = Modifier
                                .padding(start = 20.dp, top = 28.dp, end = 41.dp)
                                .constrainAs(number) {
                                    top.linkTo(icon.top)
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
                            text = searchResults[index].title,
                            color = onPrimaryLight,
                            fontSize = 16.sp,
                            maxLines = 2,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(bottom = 5.dp)
                        )
                        Text(
                            text = searchResults[index].description,
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
        ScreenResults(sampleResults) {}
    }
}
