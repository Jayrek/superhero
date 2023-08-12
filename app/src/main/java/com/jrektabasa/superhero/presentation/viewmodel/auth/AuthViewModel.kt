package com.jrektabasa.superhero.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.domain.use_case.auth.SignInWithGoogleUseCase
import com.jrektabasa.superhero.presentation.state.SignInUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
) : ViewModel() {
    private val _signInUiState = MutableStateFlow<SignInUiState?>(null)
    val signInUiState: StateFlow<SignInUiState?> = _signInUiState

    fun signInWithGoogle(idToken: String) {
        viewModelScope.launch {
            val result = signInWithGoogleUseCase.signInWithGoogle(idToken)
            _signInUiState.value = result
        }
    }
}