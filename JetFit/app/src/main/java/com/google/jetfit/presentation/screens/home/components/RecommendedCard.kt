package com.google.jetfit.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.google.jetfit.R
import com.google.jetfit.data.entities.Recommended

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun RecommendedCard(
    modifier: Modifier,
    cards: List<Recommended>,
    onClick: (Recommended) -> Unit
) {
    val firstList = cards.split().first
    val secondList = cards.split().second

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            modifier = Modifier.padding(start = 58.dp),
            text = stringResource(R.string.recommended_for_you),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        TvLazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 58.dp)
        ) {
            items(firstList) { card ->
                RecommendedItem(
                    modifier = modifier,
                    item = card,
                    onClick = { onClick(card) }
                )
            }
        }

        TvLazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 58.dp)
        ) {
            items(secondList) { card ->
                RecommendedItem(
                    modifier = modifier,
                    item = card,
                    onClick = { onClick(card) }
                )
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun RecommendedItem(
    modifier: Modifier,
    item: Recommended,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.colors(Color.Transparent),
        onClick = onClick
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            AsyncImage(
                modifier = modifier.clip(MaterialTheme.shapes.extraLarge),
                model = item.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Column(Modifier.padding(bottom = 8.dp)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
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