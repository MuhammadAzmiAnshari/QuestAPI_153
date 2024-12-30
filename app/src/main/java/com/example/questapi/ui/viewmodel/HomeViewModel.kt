package com.example.questapi.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import com.example.questapi.model.Mahasiswa
import com.example.questapi.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewModel (private val mhs: MahasiswaRepository): ViewModel(){
    var mhsUiState : HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs(){
        viewModelScope.launch {
            mhsUiState = HomeUiState.Loading
            mhsUiState = try {
                HomeUiState.Success(mhs.getMahasiswa())
            }catch (e:Exception) {
                HomeUiState.Error
            }catch (e:Exception) {
                HomeUiState.Error
            }
        }
    }

    fun deleteMhs(nim:String) {
        viewModelScope.launch {
            try {
                mhs.deleteMahasiswa(nim)
            }catch(e: IOException){
                HomeUiState.Error
            }catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}