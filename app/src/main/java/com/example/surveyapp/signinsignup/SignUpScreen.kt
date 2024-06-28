package com.example.surveyapp.signinsignup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.jetsurvey.util.supportWideScreen
import com.example.surveyapp.R

@Composable
fun SignUpScreen(
    email: String?,
    onSignUpSubmitted: (email: String, password: String) -> Unit,
    onSignInAsGuest: () -> Unit,
    onNavUp: () -> Unit,
){
    Scaffold (
        topBar = {
           SignInSignUpTopAppBar(
               topAppBarText = stringResource(id = R.string.create_account),
               onNavUp = onNavUp
           )
        },
        content = {contentPadding ->
            SignInSignUpScreen(
                onSignInAsGuest = onSignInAsGuest,
                contentPadding = contentPadding,
                modifier = Modifier.supportWideScreen()
            ) {
                Column {
                    SignUpContent(
                        email = email,
                        onSignUpSubmitted
                    )
                }
            }
        }
    )
}

@Composable
fun SignUpContent (
    email: String?,
    onSignUpSubmitted: (email: String, password: String) -> Unit,
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val passwordFocusRequest = remember {FocusRequester()}
        val confirmationPasswordFocusRequest = remember {FocusRequester()}
        val emailState = remember {EmailState(email)}
        val passwordState = remember {PasswordState()}
        val confirmPasswordState = remember { ConfirmPasswordState(passwordState = passwordState) }

        Email(emailState, onImeAction = {passwordFocusRequest.requestFocus()})
        Spacer(modifier = Modifier.height(16.dp))

        Password(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            imeAction = ImeAction.Next,
            onImeAction = {confirmationPasswordFocusRequest.requestFocus()},
            modifier = Modifier.focusRequester(passwordFocusRequest)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Password(
            label = stringResource(id = R.string.confirm_password),
            passwordState = confirmPasswordState,
            onImeAction = {onSignUpSubmitted(emailState.text,passwordState.text)},
            modifier = Modifier.focusRequester(confirmationPasswordFocusRequest)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.terms_and_conditions),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.67f)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onSignUpSubmitted(emailState.text, passwordState.text) },
            modifier = Modifier.fillMaxWidth(),
            enabled = emailState.isValid &&
                    passwordState.isValid &&
                    confirmPasswordState.isValid
        ) {
            Text(text = stringResource(id = R.string.create_account))
        }

    }
}

@Preview(widthDp = 1024)
@Composable
fun SignUpPreview() {
        SignUpScreen(
            email = null,
            onSignUpSubmitted = { _, _ -> },
            onSignInAsGuest = {},
            onNavUp = {},
        )
}