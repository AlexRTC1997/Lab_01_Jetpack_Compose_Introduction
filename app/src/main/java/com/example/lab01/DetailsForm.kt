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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun DetailsForm(
    attendee: Attendee
//    name: String,
//    funName: (String) -> Unit,
//    email: String,
//    funEmail: (String) -> Unit,
//                isEditing: Boolean,
//    funIsEditing: () -> Unit,
//    textButton: String,
//    funTextButton: (String) -> Unit,
//    userList: MutableList<User>,
//    funResetFields: () -> Unit
) {

    Row(
        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 20.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            text = "Edit Attendee"
        )
    }

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Full Name: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        singleLine = true,
        value = attendee.fullName
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Registration Date: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        singleLine = true,
        value = attendee.registrationDate
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Blood Type: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        singleLine = true,
        value = attendee.bloodType
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        label = { Text(text = "Phone: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        singleLine = true,
        value = attendee.phone
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = { Text(text = "Email: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        singleLine = true,
        value = attendee.email
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(text = "Amount paid: ") },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { },
        singleLine = true,
        value = attendee.amountPaid
    )

    Spacer(modifier = Modifier.padding(vertical = 16.dp))

    Button(
        modifier = Modifier.fillMaxWidth().height(48.dp),
        onClick = {
//            if (isEditing) {
//                editUser(name, email, userList)
//                funTextButton("Save")
//                funIsEditing()
//            } else {
//                registerUser(name, email, userList)
//            }
//            funResetFields()
        },
    ) {
        Text(color = MaterialTheme.colorScheme.primaryContainer, text = "Save")
    }
}