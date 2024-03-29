package com.ss.gpacalculator.screen.settings

import androidx.lifecycle.ViewModel
import com.ss.gpacalculator.repository.settings.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    fun openTwitter() = settingsRepository.openTwitter()
}