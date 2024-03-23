package com.dicoding.hsisakinah.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.hsisakinah.R
import com.dicoding.hsisakinah.components.TextNormalComponent
import com.dicoding.hsisakinah.data.Datasource
import com.dicoding.hsisakinah.model.Partner
import com.dicoding.hsisakinah.ui.theme.GrayText
import com.dicoding.hsisakinah.ui.theme.RedIcon

@Composable
@Preview
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = stringResource(R.string.search_partner),
                style = MaterialTheme.typography.titleLarge
            )
            Image(
                painter = painterResource(R.drawable.ic_sort),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                alignment = Alignment.CenterEnd,
                contentDescription = "icon sort"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.search_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline,
            textAlign = TextAlign.Justify,
        )
        PartnerListShow()
    }
}

@Composable
fun PartnerListShow() {
    PartnerList(
        partnerList = Datasource().loadPartners()
    )
}

@Composable
fun PartnerList(partnerList: List<Partner>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(partnerList) { partner ->
            PartnerCard(
                partner = partner,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun PartnerCard(partner: Partner, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 25.dp
                    )
                    .drawBehind {
                        drawCircle(color = RedIcon, radius = this.size.maxDimension)
                    },
                text = partner.name.substring(0, 1),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
            Column {
                Text(
                    text = "${partner.name} (${partner.id})",
                    style = MaterialTheme.typography.titleMedium,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${partner.age} tahun",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_dot),
                        alignment = Alignment.Center,
                        contentDescription = "icon dot"
                    )
                    Text(
                        text = partner.home,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.CenterEnd,
                contentDescription = "icon arrow right"
            )
        }
    }
}

@Preview
@Composable
private fun PartnerCardPreview() {
    PartnerCard(Partner("Aisyah", "HSI-00001", 18, "Pekalongan"))
}


