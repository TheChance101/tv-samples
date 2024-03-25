package com.google.jetfit.presentation.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.ListItem
import androidx.tv.material3.ListItemDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.google.jetfit.R
import com.google.jetfit.presentation.theme.surfaceContainerHigh

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state = viewModel.settingsUIState.collectAsState()

    SettingsContent(state = state.value)

}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun SettingsContent(
    state: SettingsUIState
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.settings),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 64.dp, start = 32.dp)
        )

        TvLazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = stringResource(id = state.appSettings.first),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            items(state.appSettings.second) {
                SettingsItem(item = it)
            }

            item {
                Text(
                    text = stringResource(id = state.personalSettings.first),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            items(state.personalSettings.second) {
                SettingsItem(item = it)
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun SettingsItem(
    item: SettingsItemUIState
) {
    ListItem(
        selected = false,
        onClick = {},
        leadingContent = {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
            )
        },
        trailingContent = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.value,
                    style = MaterialTheme.typography.titleMedium
                )
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    modifier = Modifier.size(ListItemDefaults.IconSize),
                    contentDescription = "back icon"
                )
            }
        },
        headlineContent = {},
        colors = ListItemDefaults.colors(
            containerColor = surfaceContainerHigh.copy(alpha = 0.3f),
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedContentColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = ListItemDefaults.shape(shape = RoundedCornerShape(8.dp)),
    )
}

val settingsItemsTitle = listOf(
    "Units preference",
    "Language",
    "Video Resolution",
    "Subtitles",
)