package com.google.jetfit.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.google.jetfit.R
import com.google.jetfit.components.CustomCard
import com.google.jetfit.data.entities.Training

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun TrainingsRecommended(
    modifier: Modifier = Modifier,
    state: List<Training>,
    onClick: (String) -> Unit
) {
    val firstList = state.split().first
    val secondList = state.split().second

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            modifier = Modifier.padding(start = 32.dp),
            text = stringResource(R.string.recommended_for_you),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        ItemsTrainingsRecommended(
            modifier = modifier,
            items = firstList,
            onClick = onClick
        )
        ItemsTrainingsRecommended(
            modifier = modifier,
            items = secondList,
            onClick = onClick
        )
    }
}

@Composable
private fun ItemsTrainingsRecommended(
    modifier: Modifier = Modifier,
    items: List<Training>,
    onClick: (String) -> Unit
) {
    TvLazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(items) { training ->
            CustomCard(
                modifier = modifier.width(196.dp),
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