package com.jrektabasa.superhero.data.common

val <T> T.exhaustive: T
    get() = this

sealed interface Result<out T> {
    data class Success<out T>(val data: T) : Result<T>
    data class Error(val message: String) : Result<Nothing>
}

fun <T> Result<T>.mapSuccess(transform: (T) -> T): Result<T> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Error -> this
    }
}

fun <T> Result<T>.mapError(transform: (String) -> String): Result<T> {
    return when (this) {
        is Result.Success -> this
        is Result.Error -> Result.Error(transform(message))
    }
}