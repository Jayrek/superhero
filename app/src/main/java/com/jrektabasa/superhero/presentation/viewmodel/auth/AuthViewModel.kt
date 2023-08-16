package com.jrektabasa.superhero.presentation.viewmodel.auth

import android.content.IntentSender
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.UserResponse
import com.jrektabasa.superhero.domain.use_case.auth.SignInWithGoogleUseCase
import com.jrektabasa.superhero.domain.use_case.auth.SignInWithIntentUseCase
import com.jrektabasa.superhero.presentation.state.SignInUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase,
    private val signInWithIntentUseCase: SignInWithIntentUseCase
) : ViewModel() {
    private val _signInUiState = MutableStateFlow(SignInUiState())
    val signInUiState = _signInUiState.asStateFlow()

    private val _userResponse = MutableStateFlow<Result<UserResponse>?>(null)
    val userResponse = _userResponse.asStateFlow()

    private val _intentSender = MutableStateFlow<Result<IntentSender?>?>(null)
    val intentSender = _intentSender.asStateFlow()

    fun signInWithGoogle(){
        viewModelScope.launch {
            val result = signInWithGoogleUseCase.execute()
            _intentSender.value = result
        }
    }

    fun signInWithIntent(activityResult: ActivityResult){
        viewModelScope.launch {
          val result = activityResult.data?.let { signInWithIntentUseCase.execute(it) }
            _userResponse.value = result
        }
    }
}