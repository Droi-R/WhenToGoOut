package com.whentogoout.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.droker.domain.model.GithubEntity
import com.droker.domain.usecase.GetUserRepoUseCase
import com.whentogoout.base.BaseViewModel
import com.whentogoout.utils.ScreenState
import com.whentogoout.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserRepoUseCase: GetUserRepoUseCase
) : BaseViewModel() {

    private val _homeItems = MutableStateFlow<List<GithubEntity>>(emptyList())
    val homeItems: StateFlow<List<GithubEntity>> = _homeItems.asStateFlow()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()


    val eventUserRepo: LiveData<List<GithubEntity>> get() = _eventUserRepo
    private val _eventUserRepo = SingleLiveEvent<List<GithubEntity>>()


//    init {
//        getUserRepo("Droker")
//    }


    fun getUserRepo(owner: String) = viewModelScope.launch {
        _uiState.value = UiState.Loading
        val response = getUserRepoUseCase.execute(this@HomeViewModel, owner)
        if(response == null) _uiState.value = UiState.Error(mutableErrorMessage.value ?: "Unknown Error") else {
            _uiState.value = UiState.Success
            _homeItems.value = response
//            _eventUserRepo.postValue(response)
        }
    }
}

sealed class UiState {
    object Loading : UiState()
    object Success : UiState()
    data class Error(val message: String) : UiState()
}