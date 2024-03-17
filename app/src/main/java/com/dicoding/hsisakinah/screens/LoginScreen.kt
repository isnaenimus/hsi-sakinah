package com.dicoding.hsisakinah.screens

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.hsisakinah.R
import com.dicoding.hsisakinah.components.ClickableTextComponent
import com.dicoding.hsisakinah.components.NormalTextComponent
import com.dicoding.hsisakinah.components.TextFieldComponent
import com.dicoding.hsisakinah.data.Credentials
import com.dicoding.hsisakinah.ui.theme.BlueButton
import com.dicoding.hsisakinah.ui.theme.BlueLoginColor

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            var credentials by remember { mutableStateOf(Credentials()) }
            val context = LocalContext.current

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f, false)
            ) {
                Image(
                    painter = painterResource(R.drawable.img_sakinah),
                    contentDescription = null,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                )
                NormalTextComponent(
                    value = stringResource(R.string.nip),
                    color = Color.Black,
                    align = TextAlign.Start,
                    fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.height(10.dp))
                TextFieldComponent(
                    label = "",
                    value = credentials.nip,
                    onChange = { data -> credentials = credentials.copy(nip = data)}
                )
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComponent(
                    stringResource(R.string.password),
                    Color.Black,
                    TextAlign.Start,
                    FontWeight.Normal)
                Spacer(modifier = Modifier.height(10.dp))
                TextFieldComponent(
                    label = "",
                    value = credentials.password,
                    onChange = { data -> credentials = credentials.copy(password = data)}
                )
                Spacer(modifier = Modifier.height(20.dp))
                FilledTonalButton(
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueLoginColor),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        if (!checkCredentials(credentials, context)) credentials = Credentials()
                    },
//                enabled = credentials.isNotEmpty(),
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComponent(
                    stringResource(R.string.ask_access),
                    Color.Black,
                    TextAlign.Center,
                    FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(20.dp))
                ClickableTextComponent(
                    stringResource(R.string.call_ikhwan),
                    BlueLoginColor, TextAlign.Center,
                    FontWeight.Normal
                ) {
                    Toast.makeText(context, "Menghubungi CS Ikhwan...", Toast.LENGTH_SHORT).show()
                }
                Spacer(modifier = Modifier.height(20.dp))
                ClickableTextComponent(
                    stringResource(R.string.call_akhwat),
                    BlueLoginColor,
                    TextAlign.Center,
                    FontWeight.Normal
                ) {
                    Toast.makeText(context, "Mengubungi CS Akhwat...", Toast.LENGTH_SHORT).show()
                }
            }
            OutlinedButton(
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(1.dp, BlueLoginColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                onClick = {
                    Toast.makeText(context, "Menuju Halaman FAQ...", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = stringResource(R.string.look_faq),
                    color = BlueLoginColor,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

fun checkCredentials(credentials: Credentials, context: Context): Boolean {
    if (credentials.isEmpty()) {
        Toast.makeText(context, "NIP dan Password harus diisi...", Toast.LENGTH_SHORT).show()
        return false
    } else if (credentials.isNipEmpty()) {
        Toast.makeText(context, "NIP harus diisi...", Toast.LENGTH_SHORT).show()
        return false
    } else if (credentials.isPasswordEmpty()) {
        Toast.makeText(context, "Password harus diisi...", Toast.LENGTH_SHORT).show()
        return false
    } else {
        Toast.makeText(context, "Menuju Halaman Beranda...", Toast.LENGTH_SHORT).show()
        return true
    }
}

@Composable
@ReadOnlyComposable
fun textResource(@StringRes id: Int): CharSequence =
    LocalContext.current.resources.getText(id)

@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    LoginScreen()
}