package com.cy.schoolnotify.comon_utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.cy.schoolnotify.R
import com.cy.schoolnotify.ui.theme.SNTypography
import com.cy.schoolnotify.ui.theme.SecondaryTextColor
import com.cy.schoolnotify.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTextFiled(
    value: String,
    modifier: Modifier = Modifier,
    label: String = "",
    singleLine: Boolean = true,
    focusedBorderColor: Color = SecondaryTextColor,
    focusedLabelColor: Color = SecondaryTextColor,
    unFocusedBorderColor: Color = SecondaryTextColor,
    unFocusedLabelColor: Color = SecondaryTextColor,
    cursorColor: Color = TextColor,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    shape: Shape = MaterialTheme.shapes.small,
    placeHolder: String = "",
    maxLen: Int = -1,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            if (maxLen > -1) {
                if (it.length <= maxLen)
                    onValueChange(it)
            } else {
                onValueChange(it)
            }
        },
        placeholder = {
            Text(
                text = placeHolder,
                style = SNTypography.bodyMedium
            )
        },
        label = if (label.isValidString()) {
            {
                Text(
                    text = label,
                    style = SNTypography.bodyMedium
                )
            }
        } else {
            null
        },
        singleLine = singleLine,
        textStyle = SNTypography.bodyMedium,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unFocusedBorderColor,
            focusedLabelColor = focusedLabelColor,
            unfocusedLabelColor = unFocusedLabelColor,
            cursorColor = cursorColor,
        ),

        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = imeAction,
            capitalization = capitalization
        ),
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        readOnly = readOnly,
        shape = shape,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    )
}

fun String?.isValidString(): Boolean {
    var input = this
    if (input.isNullOrEmpty() || input.equals(
            "null",
            ignoreCase = true
        )
    ) return false else {
        input = input.trim { it <= ' ' }
        if (input.isEmpty()) return false
    }
    return true
}

