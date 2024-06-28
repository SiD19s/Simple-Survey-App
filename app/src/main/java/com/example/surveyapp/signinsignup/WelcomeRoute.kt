package com.example.surveyapp.signinsignup

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WelcomeRoute(
    onNavigateToSignIn: (email: String) -> Unit,
    onNavigateToSignUp: (email: String) -> Unit,
    onSignInAsGuest: () -> Unit,
){
    val welcomeViewModel : WelcomeViewModel = viewModel(factory = WelcomeViewModelFactory())
    WelcomeScreen(
        onSignInSignUp = {email ->
             welcomeViewModel.handleContinue(
                 email = email,
                 onNavigateToSignIn = onNavigateToSignIn,
                 onNavigateToSignUp = onNavigateToSignUp
             )
        },
        onSignInAsGuest = { welcomeViewModel.signInAsGuest(onSignInAsGuest) }
    )
}
