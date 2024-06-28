package com.example.surveyapp.signinsignup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignInViewModel(private val userRepository: UserRepository) : ViewModel(){

    fun signIn(
        email: String,
        password:String,
        onSignInComplete: () -> Unit
    ){
        userRepository.signIn(email,password)
        onSignInComplete()
    }

    fun signInAsGuest(
        onSignInComplete: ()-> Unit
    ){
        userRepository.signInAsGuest()
        onSignInComplete()
    }

}

class SignInViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}