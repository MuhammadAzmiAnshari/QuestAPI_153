package com.example.questapi.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi.applications.MahasiswaApplications

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                MahasiswaApplication().container.kontakRepository)
        }
        initializer {
            InsertViewModel(
                MahasiswaApplication().container.kontakRepository)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                MahasiswaApplication().container.kontakRepository)
        }
        initializer {
            UpdateViewModel(
                createSavedStateHandle(),
                MahasiswaApplication().container.kontakRepository)
        }
    }
}

fun CreationExtras.MahasiswaApplication(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)