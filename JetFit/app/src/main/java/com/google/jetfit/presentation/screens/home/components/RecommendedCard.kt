package com.google.jetfit.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.google.jetfit.R
import com.google.jetfit.components.CustomCard
import com.google.jetfit.data.entities.Training
import com.google.jetfit.presentation.theme.JetFitTheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TrainingsRecommended(
    state: List<Training>,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val firstList = state.split().first
    val secondList = state.split().second

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            modifier = modifier.padding(start = 58.dp),
            text = stringResource(R.string.recommended_for_you),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        ItemsTrainingsRecommended(
            state = firstList,
            onClick = onClick
        )
        ItemsTrainingsRecommended(
            state = secondList,
            onClick = onClick
        )

    }
}

@Composable
private fun ItemsTrainingsRecommended(
    state: List<Training>,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TvLazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(state) { training ->
            CustomCard(
                modifier = modifier,
                imageUrl = training.imageUrl,
                title = training.title,
                timeText = training.time,
                typeText = training.instructor,
                onClick = { onClick(training.id) }
            )
        }
    }
}

private fun <T> List<T>.split(): Pair<List<T>, List<T>> {
    if (this.isNotEmpty()) {
        val first = subList(0, (size / 2))
        val second = subList((size / 2), size)
        return Pair(first, second)
    }
    return Pair(listOf(), listOf())
}

@Preview
@Composable
private fun TrainingsRecommendedPreview() {
    JetFitTheme {
        TrainingsRecommended(
            state = listOf(
                Training(
                    id = "1",
                    instructor = "Intensity",
                    title = "Full body strength",
                    time = "26 Min",
                    imageUrl = "https://s3-alpha-sig.figma.com/img/c823/37df/f97a3d198ca7a463a530cdf43275e329?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=k9CLo2xpsEn07zCJElLridjmm4QdPO~oGTfQmSV1upDJZUteGoeHO~nvz8Jx7ZfZUiSyfg2rxMAWQPPgHncj9I-gHWgy9UTYWbiWuYq7ynct-4jdFdgPr1ltdoFsBRJR1~I05Js~YQi8rOUTdZy--9saib9eF~zGz10kC274EI2VT3V3xsF7XWErz2IDQ5LyDaO5rC1cS4S5H3tvzu20QlW8Kh73VaMMW70HydqB-rPrBEwljC9l3nIx8PK7BUHXxoNj0xPHOizXd6DN-JlHspxoU6N40wz4OfZc9oar-ZLGbT3mwHZrRdM0pUoHoIMr1flai50tU1t6jl-qw2QVPw__",

                    ),
            ),
            onClick = {}
        )
    }
}