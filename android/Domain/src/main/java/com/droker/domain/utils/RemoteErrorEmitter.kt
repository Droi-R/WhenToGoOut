package com.droker.domain.utils

import com.pss.domain.utils.ErrorType

interface RemoteErrorEmitter {
    fun onError(msg: String)
    fun onError(errorType: ErrorType)
}