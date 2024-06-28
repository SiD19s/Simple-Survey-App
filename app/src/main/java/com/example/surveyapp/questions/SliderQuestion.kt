package com.example.surveyapp.questions

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surveyapp.R

@Composable
fun SliderQuestion(
    @StringRes titleResourcesId : Int,
    @StringRes startPoint : Int,
    @StringRes neutralPoint : Int,
    @StringRes endPoint : Int,
    modifier: Modifier = Modifier,
    onValueChange: (Float) -> Unit,
    value: Float?,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 3,



){
    QuestionsWrapper(
        Title = titleResourcesId,
        modifier = modifier
        ) {
        var sliderPositions by remember{ mutableStateOf(value ?: ((valueRange.endInclusive - valueRange.start) / 2)) }
        Row{
            Slider(
                value = sliderPositions,
                onValueChange = {
                    sliderPositions = it
                    onValueChange(it)
                },
                valueRange = valueRange,
                steps = steps,
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
            )
        }
        Row {
            Text(
                text = stringResource(id = startPoint),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
            Text(
                text = stringResource(id = neutralPoint),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
            Text(
                text = stringResource(id = endPoint),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
        }

    }
}

@Preview
@Composable
fun SliderQuestionPreview(){
    SliderQuestion(
        titleResourcesId = R.string.selfies,
        startPoint = R.string.strongly_dislike,
        neutralPoint = R.string.neutral,
        endPoint = R.string.strongly_like,
        value = 0.4f,
        onValueChange = {},
        modifier = Modifier.padding(vertical = 12.dp)
    )
}