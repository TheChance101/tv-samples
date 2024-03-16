package com.google.jetfit.presentation.screens.player.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.google.jetfit.presentation.theme.JetFitTheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun PlayerTitle(
    title: String,
    secondaryText: String,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = MaterialTheme.typography.headlineSmall,
    secondaryTextStyle: TextStyle = MaterialTheme.typography.labelLarge,
) {
    Column(modifier.fillMaxWidth()) {
        Text(
            title,
            style = titleStyle,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = secondaryText,
            style = secondaryTextStyle,
            color = MaterialTheme.colorScheme.onSurface.copy(0.60f),
        )
    }
}


@Preview(device = Devices.TV_1080p)
@Composable
fun PreviewPlayerTitle() {
    JetFitTheme {
        PlayerTitle(title = "Battle ropes HIIT", secondaryText = "Hugo Wright")
    }
}