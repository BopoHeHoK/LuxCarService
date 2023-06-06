package com.test.luxcarservice.app.presentation.screen.profile_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProfileSettingsViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileSettingsViewModel(

        ) as T
    }
}