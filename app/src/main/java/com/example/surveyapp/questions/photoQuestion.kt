package com.example.surveyapp.questions

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.surveyapp.R

@Composable
fun photoQuestion(
    @StringRes titleResourcesId: Int,
    ImageUri: Uri?,
    getNewImageUri: () -> Uri,
    onPhotoTaken: (Uri) -> Unit,
    modifier: Modifier = Modifier

){
    val hasPhoto = ImageUri != null
    var newImageUri: Uri? by remember {
        mutableStateOf(null)
    }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = {
            if(it){
                onPhotoTaken(newImageUri!!)
            }
        }
    )
    val iconResource = if (hasPhoto) {
        R.drawable.swaphoriz
    } else {
        R.drawable.addphoto
    }

    QuestionsWrapper(
        Title = titleResourcesId,
        modifier = Modifier.padding(vertical = 16.dp)

    ) {
        OutlinedButton(
            onClick = { 
                newImageUri = getNewImageUri()
                cameraLauncher.launch(ImageUri!!)
            },
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues()
        ) {
            Column {
                if(hasPhoto){
                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(ImageUri)
                            .build(),
                        contentDescription = null ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(96.dp)
                            .aspectRatio(4 / 3f)
                    )
                }else{
                    DefaultPhoto(
                        modifier = Modifier.padding(
                            horizontal = 86.dp,
                            vertical = 74.dp
                        )
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.BottomCenter)
                        .padding(vertical = 26.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = iconResource), contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(
                        id = if(hasPhoto){
                            R.string.retake_photo
                            }else{
                                R.string.add_photo
                            }
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DefaultPhoto(
    modifier: Modifier  = Modifier
){
    val assetId = R.drawable.ic_selfie_light
    Image(painter = painterResource(id =assetId ),modifier = modifier, contentDescription = null)
}

@Preview
@Composable
fun photoQuestionPreview(){
    Surface {
        photoQuestion(
            titleResourcesId = R.string.selfie_skills,
            ImageUri = Uri.parse("https://example.bogus/wow"),
            getNewImageUri = { Uri.EMPTY },
            onPhotoTaken = {},

        )
    }
}