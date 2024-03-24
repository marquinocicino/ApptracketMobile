package com.example.proyecto2trck.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.apptracketmovil.model.Asset


@Composable
fun AssetsList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
        AssetRow(
            Asset(
                id = "1",
                name = "Bitcon",
                symbol = "btc",
                price = 65000.00,
                percentage = 13.4
            )
        )
        Divider()
        AssetRow(
            Asset(
                id = "2",
                name = "Etherum",
                symbol = "eth",
                price = 3500.00,
                percentage = -1.4
            )
        )
    }
}

@Composable
fun AssetRow(asset: Asset) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // https://assets.coincap.io/assets/icons/btc@2x.png

        Box(modifier = Modifier.padding(horizontal = 20.dp)){

        if (LocalInspectionMode.current){
            Icon(
                imageVector = Icons.Default.AccountCircle, contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(30.dp)
            )
        }else {

            AsyncImage(
                model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
                contentDescription = null
            )
        }
        }
        Column(

        ) {
            Text(
                text = asset.name,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = asset.symbol,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$${asset.price}",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color.White
        )
        Text(
            text = "${asset.percentage}%",
            fontSize = 14.sp,
            color = if (asset.percentage >= 0) Color.Green else Color.Red,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AssetRowPreview() {
    AssetsList()
}
