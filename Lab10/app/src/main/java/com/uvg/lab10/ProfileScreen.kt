package com.uvg.lab10

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBack: () -> Unit){
    Column (Modifier.fillMaxSize()){
        TopAppBar(
            title = { Text(text = "Characters") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.piggy), contentDescription = "pfp",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(40.dp))

            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            )
            {
                Text(text = "Nombre:")
                Text(text = "June Herrera Watanabe")
            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            )
            {
                Text(text = "Carné:")
                Text(text = "231038")
            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            )
            {   
                OutlinedButton(onClick = onBack) {
                    Text(text = "Cerrar Sesión")
                }
            }
        }
    }
}
