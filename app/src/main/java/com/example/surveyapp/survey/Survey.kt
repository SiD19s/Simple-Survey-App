package com.example.surveyapp.survey

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.surveyapp.R
import com.example.surveyapp.questions.DateQuestion
import com.example.surveyapp.questions.MultipleChoiceQuestionPreview
import com.example.surveyapp.questions.MultiplechiceQuestion
import com.example.surveyapp.questions.Outfits
import com.example.surveyapp.questions.SingleChoiceQuestions
import com.example.surveyapp.questions.SliderQuestion
import com.example.surveyapp.questions.SliderQuestionPreview
import com.example.surveyapp.questions.photoQuestion

@Composable
fun FreeTimeQuestions(
    selectedAns: List<Int>,
    onOptionSelected:(selected:Boolean,answer:Int) -> Unit,
    modifier: Modifier = Modifier


){
    MultiplechiceQuestion(
        titleResourceID = R.string.in_my_free_time,
        directionsResourceID = R.string.select_all,
        possibleAns = listOf(
            R.string.read,
            R.string.work_out,
            R.string.draw,
            R.string.play_games,
            R.string.dance,
            R.string.watch_movies
        ),
        selectedAns = selectedAns,
        onOptionSelected = onOptionSelected,
        modifier = modifier

    )
}

@Composable
fun PickYourStyleQuestion(
    selectedAnswer: Outfits?,
    onOptionSelected:(Outfits)-> Unit,
    modifier: Modifier = Modifier
){
    SingleChoiceQuestions(
        titleResource = R.string.PickYourStyle,
        DirectionResource = R.string.select_one,
        possibleAns = listOf(
            Outfits(R.string.AcubiFashion,R.drawable.acubi_fashion),
            Outfits(R.string.Cyberpunk,R.drawable.cyberpunk),
            Outfits(R.string.Faitycore,R.drawable.fairycore),
            Outfits(R.string.Minimilist,R.drawable.minimilist),
            Outfits(R.string.OldMoney,R.drawable.old_money),
            Outfits(R.string.Street,R.drawable.street_style)
        ) ,
        selectedAns = selectedAnswer ,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}

@Composable
fun LastTimeQuestion(
    dateInMillis: Long?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
){
    DateQuestion(
        titleResourcesID = R.string.LastTime ,
        directionResourcesID = R.string.select_date,
        dateInMillis = dateInMillis,
        modifier = modifier,
        onClick = onClick
    )
}

@Composable
fun FeelingAboutSelfiesQuestion(
    onValueChange:(Float)-> Unit,
    value : Float?,
    modifier: Modifier = Modifier
){
    SliderQuestion(
        titleResourcesId = R.string.selfies,
        startPoint = R.string.strongly_dislike,
        neutralPoint = R.string.neutral,
        endPoint = R.string.strongly_like,
        onValueChange = onValueChange,
        value = value,
        modifier = modifier
    )
}

@Composable
fun TakeSelfieQuestion(
    ImageUri: Uri?,
    getNewImageUri : () -> Uri,
    onPhotoTaken:(Uri) -> Unit,
    modifier: Modifier = Modifier

){
    photoQuestion(
        titleResourcesId = R.string.selfie_skills,
        ImageUri = ImageUri,
        getNewImageUri = getNewImageUri,
        onPhotoTaken = onPhotoTaken,
        modifier = modifier


    )
}