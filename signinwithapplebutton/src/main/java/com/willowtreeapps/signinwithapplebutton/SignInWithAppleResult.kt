package com.willowtreeapps.signinwithapplebutton

sealed class SignInWithAppleResult {
    data class Success(val authorizationCode: String, val state: String) : SignInWithAppleResult()

    data class Failure(val error: Throwable) : SignInWithAppleResult()

    object Cancel : SignInWithAppleResult()
}
