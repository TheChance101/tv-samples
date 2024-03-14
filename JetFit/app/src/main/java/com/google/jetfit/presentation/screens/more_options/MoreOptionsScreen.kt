package com.google.jetfit.presentation.screens.more_options

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.jetfit.R
import com.google.jetfit.presentation.screens.more_options.composable.BackRowSchema
import com.google.jetfit.presentation.screens.more_options.composable.MoreOptionsButton
import com.google.jetfit.presentation.screens.more_options.composable.TrainingDetails
import com.google.jetfit.presentation.theme.JetFitTheme


@Composable
fun MoreOptionsScreen(viewModel: MoreOptionsViewModel = hiltViewModel()) {
    MoreOptionsContent()
}

@Composable
private fun MoreOptionsContent() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TrainingDetails(
                title = "Total-body balance pilates",
                time = "34 Min  |  Intensity ••••",
                description = stringResource(id = R.string.training_desc)
            )
            Spacer(modifier = Modifier.height(50.dp))
            BackRowSchema()
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MoreOptionsButton(
                text = stringResource(R.string.start_workout),
                icon = R.drawable.ic_rounded_play
            )
            MoreOptionsButton(
                text = stringResource(R.string.add_to_favorites),
                icon = R.drawable.ic_outline_favorite
            )
            MoreOptionsButton(text = stringResource(R.string.more_info), icon = R.drawable.ic_info)
            MoreOptionsButton(
                text = stringResource(R.string.view_instructor),
                icon = R.drawable.ic_instructor
            )
            MoreOptionsButton(text = stringResource(R.string.share), icon = R.drawable.ic_share)
        }
    }
}

@Preview(device = Devices.TV_1080p)
@Composable
private fun MoreOptionsContentPreview() {
    JetFitTheme {
        MoreOptionsContent()
    }
}