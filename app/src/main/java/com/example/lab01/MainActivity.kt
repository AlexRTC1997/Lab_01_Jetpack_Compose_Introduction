package com.example.lab01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab01.ui.theme.Lab01Theme

// TODO: Fix Edit route

// [1] Routes
sealed class Destination(val route: String) {
    object List : Destination("list")
    object Register : Destination("register")
    object Details : Destination("details/{attendeeId}") {
        fun createRoute(attendeeId: Int) = "details/$attendeeId"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val attendeesList = remember { mutableStateListOf<Attendee>() }

                    // [2] Use Navigation Composable
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController, attendeesList = attendeesList)
                }
            }
        }
    }
}

// [2] Navigation Composable
@Composable
fun NavigationAppHost(navController: NavHostController, attendeesList: MutableList<Attendee>) {
    val context = LocalContext.current

    // For each route, loads a Screen
    NavHost(navController = navController, startDestination = "list") {
        composable(Destination.List.route) { ListScreen(navController, attendeesList) }
        composable(Destination.Register.route) { RegisterScreen(navController, attendeesList) }
        composable(Destination.Details.route) { navBackStackEntry ->
            val attendeeId = navBackStackEntry.arguments?.getString("attendeeId")

            if (attendeeId == null) {
                Toast.makeText(context, "Attendee ID is required", Toast.LENGTH_LONG).show()
            } else {
                DetailsScreen(attendeeId = attendeeId.toInt(), attendeesList = attendeesList)
            }
        }
    }
}

// [3] Functions
fun registerAttendee(
    id: Int,
    fullName: String,
    registrationData: String,
    bloodType: String,
    phone: String,
    email: String,
    amountPaid: String,
    attendeesList: MutableList<Attendee>
) {
    attendeesList.add(Attendee(id, fullName, registrationData, bloodType, phone, email, amountPaid))
}

fun editAttendee(currentId: Int, fullName: String,
                 registrationData: String,
                 bloodType: String,
                 phone: String,
                 email: String,
                 amountPaid: String,
                 attendeesList: MutableList<Attendee>) {
    attendeesList.forEach { attendee ->
        if (attendee.id == currentId) {
            attendee.fullName = fullName
            attendee.registrationDate = registrationData
            attendee.bloodType = bloodType
            attendee.phone = phone
            attendee.email = email
            attendee.amountPaid = amountPaid
        }
    }
}

fun removeAttendee(currentId: Int, attendeesList: MutableList<Attendee>) {
    attendeesList.forEach { user ->
        if (user.id == currentId) {
            attendeesList.remove(user)
        }
    }
}

