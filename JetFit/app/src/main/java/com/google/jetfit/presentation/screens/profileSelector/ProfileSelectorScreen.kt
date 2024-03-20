package com.google.jetfit.presentation.screens.profileSelector

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.google.jetfit.R
import com.google.jetfit.components.CustomOutlineButton

@Composable
fun ProfileSelectorScreen() {
    val viewModel: ProfileSelectorViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    val profileFocusRequester = remember { FocusRequester() }


    ProfileSelectorContent(
        state = state,
        profileFocusRequester = profileFocusRequester,
        interaction = viewModel
    )
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun ProfileSelectorContent(
    state: ProfileSelectorUiState,
    profileFocusRequester: FocusRequester,
    interaction: ProfileSelectorInteraction,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            stringResource(id = R.string.whos_working_out_today),
            style = MaterialTheme.typography.titleLarge,
        )

        TvLazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp, bottom = 24.dp)
                .height(204.dp)
                .focusRequester(profileFocusRequester),
            horizontalArrangement = Arrangement.Center,

            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(state.profiles) { profile ->
                ItemProfile(
                    profile,
                    onClick = interaction::onClickProfile,
                )
            }
        }

        CustomOutlineButton(
            text = stringResource(id = R.string.sign_in_with_a_different_user),
            textStyle = MaterialTheme.typography.labelLarge,
            onClick = interaction::onClickSignIn
        )


    }

}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun ItemProfile(
    state: ProfileUiState, onClick: (idProfile: String) -> Unit, modifier: Modifier = Modifier
) {
    var isItemProfileFocused by remember { mutableStateOf(false) }

    key(state.id) {
        val scaleAvatar = if (isItemProfileFocused) 160.dp else 120.dp
        val nameStyle =
            if (isItemProfileFocused) MaterialTheme.typography.labelLarge else MaterialTheme.typography.labelMedium

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .size(scaleAvatar)
                    .border(
                        width = 3.dp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = if (isItemProfileFocused) 1f else 0f),
                        shape = CircleShape,
                    )
                    .clip(CircleShape)
                    .onFocusChanged {
                        isItemProfileFocused = it.hasFocus
                    },
                onClick = {
                    onClick(state.id)
                },
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = state.avatar,
                    contentDescription = stringResource(id = R.string.image, state.name),
                    contentScale = ContentScale.Crop
                )

            }


            Text(
                text = state.name, style = nameStyle
            )
        }

    }

}

