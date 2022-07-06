package com.fahlepyrizal01.core.utils

sealed class Resource<T>(val data: T? = null, private val message: String? = null) {

    private var loadingHasBeenHandled = false
    private var successHasBeenHandled = false
    private var errorHasBeenHandled = false

    fun getLoadingStateIfNotHandled() = if (loadingHasBeenHandled) {
        null
    } else {
        loadingHasBeenHandled = true
    }

    fun getSuccessStateIfNotHandled(): T? = if (successHasBeenHandled) {
        null
    } else {
        successHasBeenHandled = true
        data
    }

    fun getErrorStateIfNotHandled() = if (errorHasBeenHandled) {
        null
    } else {
        errorHasBeenHandled = true
        message
    }

    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

}