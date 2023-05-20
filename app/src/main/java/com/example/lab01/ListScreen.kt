package com.example.lab01

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun ListScreen(navController: NavHostController) {
    val attendeesList = MutableList(30) { it }

    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                text = "Jetpack Compose Conference"
            )
        }

        LazyColumn(modifier = Modifier.background(Color.LightGray)) {
            items(attendeesList) {
                Row(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White)
                    .padding(4.dp)
                    .clickable {
                        navController.navigate(
                            Destination.Details.createRoute(
                                it
                            )
                        )
                    }
                ) {
                    Text(text = "Element $it")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
            onClick = { navController.navigate(Destination.Register.route) }
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }

}