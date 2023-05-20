package com.example.lab01

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Button
import androidx.navigation.NavHostController

@Composable
fun ListScreen(navController: NavHostController) {
    val attendeesList = MutableList(10) { it }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
            ) {
                Button(
                    onClick = { navController.navigate(Destination.Register.route) }
                ) {
                    Text("Go to Register")
                }

                Column(modifier = Modifier.fillMaxWidth()) {
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
            }
        }
    }
}