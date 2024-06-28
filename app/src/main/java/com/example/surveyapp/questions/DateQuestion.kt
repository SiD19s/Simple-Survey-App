package com.example.surveyapp.questions

import androidx.annotation.StringRes
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.jetsurvey.util.getDefaultDateInMillis
import com.example.surveyapp.R
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun DateQuestion(
    @StringRes titleResourcesID: Int,
    @StringRes directionResourcesID: Int,
    modifier: Modifier = Modifier,
    dateInMillis: Long?,
    onClick: () -> Unit,
){
    QuestionsWrapper(
        Title = titleResourcesID,
        directionResourcesID,
        modifier = modifier,


    ) {
    // not understood ths part deeply
        // All times are stored in UTC, so generate the display from UTC also
        val simpleDateFormatPattern = "EEE, MMM d"
        val dateFormat = SimpleDateFormat(simpleDateFormatPattern, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val dateString = dateFormat.format(dateInMillis ?: getDefaultDateInMillis())
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(vertical = 20.dp)
            .height(54.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
                .copy(alpha = 0.8f),
        ),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(1.dp,MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f))

    ) {
        Text(
            text = dateString,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.8f)
        )
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription =null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
            )


    }
    }
}


@Preview
@Composable
fun DateQuestionReview(){
    DateQuestion(
        titleResourcesID = R.string.takeaway,
        directionResourcesID = R.string.select_date,
        dateInMillis = 1672560000000, onClick = {} )
}