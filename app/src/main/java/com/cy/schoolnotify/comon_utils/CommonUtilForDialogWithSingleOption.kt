package com.cy.schoolnotify.comon_utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.cy.schoolnotify.R
import com.cy.schoolnotify.ui.theme.BlueColor
import com.cy.schoolnotify.ui.theme.SecondaryTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonUtilForDialogWithSingleOption(
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    messageColor: Color
) {

    Dialog(onDismissRequest = { onConfirmation() }) {
        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Icon(
                    painter = if (dialogTitle == "Success") {
                        painterResource(id = R.drawable.success_icon_dialog)
                    } else {
                        painterResource(id = R.drawable.error_common_dialog_icon)
                    },
                    contentDescription = stringResource(
                        id = R.string.error_content_description
                    ),
                    tint = if (dialogTitle == "Success") {
                        Color.Green
                    } else {
                        Color.Red
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                HeadTitleTextWithBoldFont(
                    value = dialogTitle,
                    color = if (dialogTitle == "Success") {
                        BlueColor
                    } else {
                        Color.Red
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                BodyMediumTextWithSemiBoldFont(
                    value = dialogText,
                    color = messageColor,
                    textAlign = TextAlign.Justify
                )

                Spacer(modifier = Modifier.height(20.dp))
                TextButton(
                    onClick = {

                    }, border = BorderStroke(
                        1.dp, color = if (dialogTitle == "Success") {
                            BlueColor
                        } else {
                            Color.Red
                        }
                    )
                ) {
                    TitleMediumTextWithBoldFont(
                        value = "Ok", color = if (dialogTitle == "Success") {
                            BlueColor
                        } else {
                            Color.Red
                        }
                    )
                }

            }

        }

    }
}

@Preview
@Composable
fun PreviewCommonDialog() {
    CommonUtilForDialogWithSingleOption(
        onConfirmation = { },
        dialogTitle = "Error",
        dialogText = "Login Successful with Student account",
        messageColor = SecondaryTextColor
    )
}