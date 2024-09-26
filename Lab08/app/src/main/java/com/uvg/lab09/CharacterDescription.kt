package com.uvg.lab09

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.uvg.lab09.util.CharacterDb

private val MyDb = CharacterDb()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDescription(onBack: () -> Unit, id: Int){
    Column (Modifier.fillMaxSize()){
        TopAppBar(
            title = { Text(text = "Characters") },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            val charashe = MyDb.getCharacterById(id)
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(charashe.image)
                    .crossfade(true)
                    .build(),
                contentDescription = charashe.name,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Text(text = charashe.name, style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
            , modifier = Modifier.padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))



            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            )
            {
                Text(text = "Species:")
                Text(text = charashe.species)
            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            )
            {
                Text(text = "Status:")
                Text(text = charashe.status)
            }
            Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            )
            {
                Text(text = "Gender:")
                Text(text = charashe.gender)
            }
        }
    }
}
