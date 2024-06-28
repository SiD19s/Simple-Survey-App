package com.example.surveyapp.signinsignup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel(){

    fun signUp(
        email: String,
        password:String,
        onSignUpComplete: () -> Unit
    ){
        userRepository.signUp(email,password)
        onSignUpComplete()
    }

    fun signInAsGuest(
        onSignInComplete: ()-> Unit
    ){
        userRepository.signInAsGuest()
        onSignInComplete()
    }

}

class SignUpViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}