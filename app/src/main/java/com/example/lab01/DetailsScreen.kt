package com.example.lab01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(attendeeId: Int, attendeesList: MutableList<Attendee>) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp, 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        var attendee = attendeesList[attendeeId]

        DetailsForm(attendee = attendee)
    }
}
