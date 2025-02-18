package com.whentogoout.viewmode

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.droker.domain.model.GithubEntity
import com.droker.domain.usecase.GetUserRepoUseCase
import com.whentogoout.base.BaseViewModel
import com.whentogoout.utils.ScreenState
import com.whentogoout.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserRepoUseCase: GetUserRepoUseCase
) : BaseViewModel() {
    val eventUserRepo: LiveData<List<GithubEntity>> get() = _eventUserRepo
    private val _eventUserRepo = SingleLiveEvent<List<GithubEntity>>()


    fun getUserRepo(owner: String) = viewModelScope.launch {
        val response = getUserRepoUseCase.execute(this@MainViewModel, owner)
        if(response == null) mutableScreenState.postValue(ScreenState.ERROR) else {
            mutableScreenState.postValue(ScreenState.RENDER)
            _eventUserRepo.postValue(response!!)
        }
    }
}