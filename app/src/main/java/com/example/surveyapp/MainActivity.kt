package com.example.surveyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.surveyapp.questions.DateQuestionReview
import com.example.surveyapp.questions.MultipleChoiceQuestionPreview
import com.example.surveyapp.questions.SingleChoiceQuestionPreview
import com.example.surveyapp.questions.SliderQuestionPreview
import com.example.surveyapp.questions.photoQuestion
import com.example.surveyapp.signinsignup.OrSignInAsGuest
import com.example.surveyapp.survey.SurveyQuestionsScreen
import com.example.surveyapp.survey.SurveyResult
import com.example.surveyapp.survey.SurveyScreenData
import com.example.surveyapp.survey.SurveyTopAppBar
import com.example.surveyapp.ui.theme.SurveyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SurveyAppTheme {
                SurveyAppNav()
            }
        }
    }
}

