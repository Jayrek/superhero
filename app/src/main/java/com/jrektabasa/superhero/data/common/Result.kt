package com.jrektabasa.superhero.data.common

val <T> T.exhaustive: T
    get() = this

sealed interface Result<out T> {
    data class Success<out T>(val data: T) : Result<T>
    data class Error(val message: String) : Result<Nothing>
}