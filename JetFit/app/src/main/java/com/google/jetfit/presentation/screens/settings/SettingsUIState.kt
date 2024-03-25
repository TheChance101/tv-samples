package com.google.jetfit.presentation.screens.settings

import com.google.jetfit.R

data class SettingsUIState(
    val settingsMenuUIState: SettingsMenuUIState = SettingsMenuUIState()
) {

    val appSettings = Pair(
        R.string.app_settings,
        listOf(
            SettingsItemUIState(
                title = SettingsMenuUIState.AppSettings.UnitsPreference.name,
                value = SettingsMenuUIState.AppSettings.UnitsPreference.value
            ),
            SettingsItemUIState(
                title = SettingsMenuUIState.AppSettings.Language.name,
                value = SettingsMenuUIState.AppSettings.Language.value
            ),
            SettingsItemUIState(
                title = SettingsMenuUIState.AppSettings.VideoResolution.name,
                value = SettingsMenuUIState.AppSettings.VideoResolution.value
            ),
            SettingsItemUIState(
                title = SettingsMenuUIState.AppSettings.Subtitles.name,
                value = SettingsMenuUIState.AppSettings.Subtitles.value
            )
        )
    )

    val personalSettings = Pair(
        R.string.personal_settings,
        listOf(
            SettingsItemUIState(
                title = SettingsMenuUIState.PersonalSettings.AccountSettings.name,
                value = SettingsMenuUIState.PersonalSettings.AccountSettings.value
            ),
            SettingsItemUIState(
                title = SettingsMenuUIState.PersonalSettings.JetFitPremium.name,
                value = SettingsMenuUIState.PersonalSettings.JetFitPremium.value
            ),
            SettingsItemUIState(
                title = SettingsMenuUIState.PersonalSettings.AboutJetFit.name,
                value = SettingsMenuUIState.PersonalSettings.AboutJetFit.value
            )
        )
    )

}

data class SettingsItemUIState(
    val title: String,
    val value: String
)

data class SettingsMenuUIState(
    val appSettings: AppSettings = AppSettings.UnitsPreference,
    val personalSettings: PersonalSettings = PersonalSettings.AccountSettings
) {
    enum class AppSettings(val value: String) {
        UnitsPreference("Imperial"), Language("English (US)"), VideoResolution("Automatic up to 4k"), Subtitles(
            "On"
        )
    }

    enum class PersonalSettings(val value: String) {
        AccountSettings("Olivia"), JetFitPremium("3 month"), AboutJetFit("")
    }
}
