package com.google.jetfit.presentation.screens.more_options

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.jetfit.R
import com.google.jetfit.data.entities.TrainingE
import com.google.jetfit.presentation.screens.more_options.composable.BackRowSchema
import com.google.jetfit.presentation.screens.more_options.composable.MoreOptionsButton
import com.google.jetfit.presentation.screens.more_options.composable.TrainingDetails
import com.google.jetfit.presentation.theme.JetFitTheme


@Composable
fun MoreOptionsScreen(
    viewModel: MoreOptionsViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    MoreOptionsContent(state = state, onBackPressed = onBackPressed)
}

@Composable
private fun MoreOptionsContent(state: MoreOptionsUiState, onBackPressed: () -> Unit) {
    BackHandler(onBack = onBackPressed)
    when (state) {
        MoreOptionsUiState.Error -> Log.d("Tarek", "Error")
        MoreOptionsUiState.Loading -> Log.d("Tarek", "Loading")
        is MoreOptionsUiState.Ready -> {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    TrainingDetails(
                        title = state.trainingDetails.title,
                        time = state.formatTimeAndTypeTraining(),
                        description = state.trainingDetails.description
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    BackRowSchema(onClickBack = onBackPressed)
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
                    MoreOptionsButton(
                        text = stringResource(R.string.more_info),
                        icon = R.drawable.ic_info
                    )
                    MoreOptionsButton(
                        text = stringResource(R.string.view_instructor),
                        icon = R.drawable.ic_instructor
                    )
                    MoreOptionsButton(
                        text = stringResource(R.string.share),
                        icon = R.drawable.ic_share
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.TV_1080p)
@Composable
private fun MoreOptionsContentPreview() {
    JetFitTheme {
        MoreOptionsContent(
            onBackPressed = {},
            state = MoreOptionsUiState.Ready(
                trainingDetails = TrainingE(
                    id = "1",
                    instructor = "Danielle Orlando",
                    type = "Intensity",
                    title = "Total-body balance pilates",
                    time = "34 Min",
                    description = "Andrea's signature low-impact, total-body class in just 30 minutes. Hit every muscle group with barre and Pilates moves that leave you feeling strong, refreshed, and energized",
                    imageUrl = "https://s3-alpha-sig.figma.com/img/4a55/976b/4326c161fb1a8e1619b6b935a7d72898?Expires=1711324800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=FrisEgVcxRsPdV5~7TFJuogCRC1DGQncvd7W3eEWrE3raW3WU-NFGMg9-G3rrUAanAM8doc5Ce842G-vEyVzC~eQyY8Sl2X9RJW199oajHOcVq4QBhjWmJBbSiQiJjEm5sqGgyPSUvpWd2D-5b1d7GeSFvRPAnmR-nfnHTlmtGkc3c1y4awXIyWPvzRAxqEwJN~3lsPxAOA~4c7YM5h9tJbM7GbBru~NOdU1cP5tRF52~~H0xgebbcOU1hst5UHvDph-7zsViDPCOWvAJrAwKLF8Jzd1Ts-1BiHsVqFVROTu6eA4pj9t7u7omBGcc0XplFfJobo7YG8pFKJSwKPOrQ__"
                )
            )
        )
    }
}