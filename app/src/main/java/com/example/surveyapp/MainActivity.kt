package com.example.surveyapp

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.jetsurvey.theme.JetsurveyTheme
import com.example.compose.jetsurvey.theme.SurveyAppTheme
import com.example.compose.jetsurvey.util.getDefaultDateInMillis
import com.example.surveyapp.R.*
import com.example.surveyapp.questions.DateQuestion
import com.example.surveyapp.questions.DateQuestionReview
import com.example.surveyapp.questions.MultipleChoiceQuestionPreview
import com.example.surveyapp.questions.SingleChoiceQuestionPreview
import com.example.surveyapp.questions.SliderQuestionPreview
import com.example.surveyapp.questions.photoQuestion
import com.example.surveyapp.signinsignup.OrSignInAsGuest
import com.example.surveyapp.survey.PhotoUriManager
import com.example.surveyapp.survey.SurveyQuestionsScreen
import com.example.surveyapp.survey.SurveyResult
import com.example.surveyapp.survey.SurveyScreenData
import com.example.surveyapp.survey.SurveyTopAppBar
import com.example.surveyapp.survey.SurveyViewModel
import com.example.surveyapp.survey.SurveyViewModelFactory
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            JetsurveyTheme {
                SurveyAppNav()
            }

        }
    }
}



