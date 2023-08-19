package com.jrektabasa.superhero.domain.use_case.auth

import com.google.firebase.auth.AuthResult
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignInWithEmailAndPasswordUseCase @Inject constructor(
    private val repository: AuthRepository,
) {

    suspend fun execute(email: String, password: String): Result<AuthResult> {
        return repository.signInWithEmailAndPassword(email, password)
    }

}