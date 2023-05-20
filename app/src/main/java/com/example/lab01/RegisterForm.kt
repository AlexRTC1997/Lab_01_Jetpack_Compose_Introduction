@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lab01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun RegisterForm(attendeesList: MutableList<Attendee>){
    var fullName by remember { mutableStateOf("") }
    var registrationDate by remember { mutableStateOf("") }
    var bloodType by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var amountPaid by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 20.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            text = "Register Attendee"
        )
    }

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Full Name: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { fullName = it },
        singleLine = true,
        value = fullName
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Registration Date: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { registrationDate = it },
        singleLine = true,
        value = registrationDate
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Blood Type: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { bloodType = it },
        singleLine = true,
        value = bloodType
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        label = { Text(text = "Phone: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { phone = it },
        singleLine = true,
        value = phone
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(text = "Email: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { email = it },
        singleLine = true,
        value = email
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(text = "Amount paid: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { amountPaid = it },
        singleLine = true,
        value = amountPaid
    )

    Spacer(modifier = Modifier.padding(vertical = 24.dp))

    Button(
        modifier = Modifier.fillMaxWidth().height(48.dp),
        onClick = {
            val id = attendeesList.size + 1
            registerAttendee(id, fullName, registrationDate, bloodType, phone, email, amountPaid, attendeesList)

            fullName = ""
            registrationDate = ""
            bloodType = ""
            phone = ""
            email = ""
            amountPaid = ""
        },
    ) {
        Text(color = MaterialTheme.colorScheme.primaryContainer, text = "Save")
    }
}