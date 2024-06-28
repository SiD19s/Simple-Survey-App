package com.example.surveyapp.questions

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surveyapp.R

@Composable
fun MultiplechiceQuestion(
    @StringRes titleResourceID:Int,
    @StringRes directionsResourceID:Int,
    modifier: Modifier = Modifier,
    possibleAns: List<Int>,
    selectedAns: List<Int>,
    onOptionSelected: (selected:Boolean,answer:Int) -> Unit,
){
    QuestionsWrapper(
        Title = titleResourceID,
        Direction = directionsResourceID,
        modifier = modifier
    ) {
        possibleAns.forEach{
            val selected = selectedAns.contains(it)
            CheckBoxRow(
                text = stringResource(id = it),
                selected =selected,
                onOptionSelected = {onOptionSelected(!selected,it)},
                modifier = Modifier.padding(vertical = 8.dp)
            )

        }
    }
}

@Composable
fun CheckBoxRow(
    text:String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onOptionSelected: ()-> Unit,
){
    Surface(
        shape = MaterialTheme.shapes.small,
        color = if(selected){
            MaterialTheme.colorScheme.primaryContainer
        }else{
            MaterialTheme.colorScheme.surface
        },
        border = BorderStroke(
            width = 1.dp,
            color = if(selected){
                MaterialTheme.colorScheme.primary
            }else{
                MaterialTheme.colorScheme.outline
            }
        ),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .selectable(
                selected,
                onClick = onOptionSelected,
                role = Role.RadioButton
            )
    )  {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(text = text, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Box(modifier = Modifier.padding(8.dp) ){
                Checkbox(checked = selected, onCheckedChange =null )

            }

        }

    }

}

@Preview
@Composable
fun MultipleChoiceQuestionPreview( )
{
    val possibleAns = listOf(R.string.read,R.string.work_out,R.string.draw)
    val selectedAnswers = remember { mutableStateListOf(R.string.work_out) }
    MultiplechiceQuestion(
        titleResourceID = R.string.in_my_free_time,
        directionsResourceID = R.string.select_all,
        possibleAns = possibleAns,
        selectedAns = selectedAnswers,
        onOptionSelected = {_,_ ->} // _,_ -> handles the action without needing the actual datatype parameters
    )
}