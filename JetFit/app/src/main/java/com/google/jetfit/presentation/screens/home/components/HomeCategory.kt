package com.google.jetfit.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
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
import com.google.jetfit.data.entities.Category

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeCategory(
    categories: List<Category>,
    onClick: (Category) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 58.dp),
            text = stringResource(R.string.categories),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        TvLazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            contentPadding = PaddingValues(horizontal = 58.dp)
        ) {
            items(categories) { category ->
                CategoryCard(
                    category = category,
                    onClick = { onClick(category) }
                )
            }
        }
    }
}


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun CategoryCard(
    category: Category,
    onClick: () -> Unit
) {
    val gradiantColors = arrayOf(
        .6f to MaterialTheme.colorScheme.surfaceVariant,
        1f to Color.Transparent
    )
    Card(
        shape = CardDefaults.shape(MaterialTheme.shapes.medium),
        onClick = onClick,
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(280.dp, 80.dp)
                    .drawWithContent {
                        drawContent()
                        drawRect(Brush.horizontalGradient(colorStops = gradiantColors))
                    },
                model = category.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.padding(start = 18.dp)) {
                Text(
                    modifier = Modifier.width(180.dp),
                    text = category.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.width(200.dp),
                    text = category.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
