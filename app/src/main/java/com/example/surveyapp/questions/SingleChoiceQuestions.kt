package com.example.surveyapp.questions

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surveyapp.R

data class Outfits(@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int)

@Composable
fun SingleChoiceQuestions(
    @StringRes titleResource:Int,
    @StringRes DirectionResource:Int,
    possibleAns: List<Outfits>,
    selectedAns: Outfits?,
    onOptionSelected: (Outfits) -> Unit,
    modifier: Modifier = Modifier,
){

    QuestionsWrapper(titleResource,DirectionResource,modifier.selectableGroup()) {
        possibleAns.forEach{
            val selected = it == selectedAns
            RadioButtionWithImage(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = it.stringResourceId),
                imageResourceId = it.imageResourceId,
                selected = selected,
                onOptionSelected = {onOptionSelected(it) })
        }

    }
}

@Composable
fun RadioButtionWithImage(
    text: String,
    @DrawableRes imageResourceId: Int,
    selected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier,
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
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription =null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .padding(start = 0.dp, end = 8.dp)
                )
            Spacer(Modifier.width(8.dp))

            Text(text, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)

            Box(Modifier.padding(8.dp)) {
                RadioButton(selected = selected, onClick = { /*TODO*/ })
            }

        }

    }
}
@Preview
@Composable
fun SingleChoiceQuestionPreview() {
    val possibleAnswers = listOf(
        Outfits(R.string.AcubiFashion,R.drawable.acubi_fashion),
        Outfits(R.string.Cyberpunk,R.drawable.cyberpunk),
        Outfits(R.string.Faitycore,R.drawable.fairycore),
        Outfits(R.string.Minimilist,R.drawable.minimilist),
        Outfits(R.string.OldMoney,R.drawable.old_money),
        Outfits(R.string.Street,R.drawable.street_style)
    )
    var selectedAnswer by remember { mutableStateOf<Outfits?>(null) }
    SingleChoiceQuestions(
        titleResource = R.string.PickYourStyle,
        DirectionResource = R.string.select_one,
        possibleAns = possibleAnswers,
        selectedAns = selectedAnswer,
        onOptionSelected = {selectedAnswer = it},
    )

}