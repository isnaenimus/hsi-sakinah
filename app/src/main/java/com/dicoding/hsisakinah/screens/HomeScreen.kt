package com.dicoding.hsisakinah.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.hsisakinah.R
import com.dicoding.hsisakinah.ui.theme.*

@OptIn(ExperimentalLayoutApi::class)
@Composable
@Preview
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.img_sakinah),
                contentDescription = null,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )

            Card(
                modifier = Modifier
                    .padding(24.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(
                    containerColor = GrayCard
                ),
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)//.align(alignment = Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Isi form CV dulu yuk!",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Untuk bisa memulai pencarian pasangan, Antum harus mengisi form CV antum terlebih dahulu",
                        color = GrayText,
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(R.drawable.img_search_letter),
                        contentDescription = null,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .width(120.dp)
                            .height(160.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FlowRow(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        maxItemsInEachRow = 2
                    ) {
                        OutlinedButton(
                            shape = MaterialTheme.shapes.small,
                            border = BorderStroke(1.dp, BlueButton),
                            modifier = Modifier.weight(0.5f),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "Lewati",
                                color = BlueButton
                            )
                        }
                        FilledTonalButton(
                            shape = MaterialTheme.shapes.small,
                            colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                            modifier = Modifier.weight(0.5f),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "Isi CV",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
