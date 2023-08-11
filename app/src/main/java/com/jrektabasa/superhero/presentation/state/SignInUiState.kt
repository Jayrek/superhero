package com.jrektabasa.superhero.presentation.state

import com.google.firebase.auth.FirebaseUser

data class SignInUiState(
    val user: FirebaseUser? = null,
    val isSuccess: Boolean,
    val error: String = ""
)
