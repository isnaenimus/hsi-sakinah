package com.dicoding.hsisakinah.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.dicoding.hsisakinah.ui.theme.GrayCard

@Composable
fun NormalTextComponent(value: String, color: Color, align: TextAlign, fontWeight: FontWeight) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = MaterialTheme.typography.titleMedium,
        color = color,
        textAlign = align,
        fontWeight = fontWeight,
    )
}

@Composable
fun ClickableTextComponent(
    value: String,
    color: Color,
    align: TextAlign,
    fontWeight: FontWeight,
    onClick: () -> Unit) {
   ClickableText(
       text = AnnotatedString(value),
       modifier = Modifier
           .fillMaxWidth(),
       style = TextStyle(
           color = color,
           textAlign = align,
           fontWeight = fontWeight,
           fontFamily = FontFamily.SansSerif,
           fontSize = 16.sp,
           lineHeight = 24.sp,
           letterSpacing = 0.2.sp,
       ),
       onClick = {
           onClick()
       }
   )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    label: String,
    value: String,
    onChange: (String) -> Unit) {

    TextField(
        value = value,
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = GrayCard
        ),
        keyboardOptions = KeyboardOptions.Default,
        singleLine = true,
        onValueChange = onChange
//        leadingIcon = {
//            Icon(painter = painterResource(id = R.drawable.ic_baseline_account_circle), contentDescription = "")
//        }
    )
}




