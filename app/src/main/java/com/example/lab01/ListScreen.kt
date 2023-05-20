package com.example.lab01

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun ListScreen(navController: NavHostController) {
    val attendeesList = remember { mutableStateListOf<Attendee>() }

    attendeesList.add(
        Attendee(
            1,
            "Alex Turpo Coila",
            "19/05/23",
            "A+",
            "954868",
            "aturpoco@unsa.edu.pe",
            "50"
        )
    )
    attendeesList.add(
        Attendee(
            2,
            "Alex Turpo Coila",
            "19/05/23",
            "A+",
            "954868",
            "aturpoco@unsa.edu.pe",
            "50"
        )
    )
    attendeesList.add(
        Attendee(
            3,
            "Alex Turpo Coila",
            "19/05/23",
            "A+",
            "954868",
            "aturpoco@unsa.edu.pe",
            "50"
        )
    )
    attendeesList.add(
        Attendee(
            4,
            "Alex Turpo Coila",
            "19/05/23",
            "A+",
            "954868",
            "aturpoco@unsa.edu.pe",
            "50"
        )
    )
    attendeesList.add(
        Attendee(
            5,
            "Alex Turpo Coila",
            "19/05/23",
            "A+",
            "954868",
            "aturpoco@unsa.edu.pe",
            "50"
        )
    )

    Column(modifier = Modifier.padding(20.dp)) {
        Row(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                text = "Jetpack Compose Conference"
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(attendeesList) {
                // TODO: Make a Attendee Card Composable
                Row(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.small)
                    .background(color = MaterialTheme.colorScheme.secondaryContainer)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .clickable {
                        navController.navigate(
                            Destination.Details.createRoute(
                                it.id
                            )
                        )
                    }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = "Attendee",
                                    modifier = Modifier.size(20.dp),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = it.fullName,
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.titleMedium,
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.Email,
                                    contentDescription = "Email",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = it.email,
                                    color = MaterialTheme.colorScheme.secondary,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.Phone,
                                    contentDescription = "Phone",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = it.phone,
                                    color = MaterialTheme.colorScheme.secondary,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.CheckCircle,
                                    contentDescription = "Blood Type",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = it.bloodType,
                                    color = MaterialTheme.colorScheme.secondary,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.DateRange,
                                    contentDescription = "Registration Date",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = it.registrationDate,
                                    color = MaterialTheme.colorScheme.secondary,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }

                        Text(
                            text = "$ ${it.amountPaid}",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )

                    }
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