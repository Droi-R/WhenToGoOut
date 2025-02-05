package com.whentogoout.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droker.domain.utils.RemoteErrorEmitter
import com.pss.domain.utils.ErrorType
import com.whentogoout.utils.ScreenState
import com.whentogoout.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel(), RemoteErrorEmitter {

    val mutableProgress = MutableLiveData<Int>(View.GONE)
    val mutableScreenState = SingleLiveEvent<ScreenState>()
    val mutableErrorMessage = SingleLiveEvent<String>()
    val mutableSuccessMessage = MutableLiveData<String>()
    val mutableErrorType = SingleLiveEvent<ErrorType>()


    override fun onError(errorType: ErrorType) {
        mutableErrorType.postValue(errorType)
    }

    override fun onError(msg: String) {
        mutableErrorMessage.postValue(msg)
    }
}