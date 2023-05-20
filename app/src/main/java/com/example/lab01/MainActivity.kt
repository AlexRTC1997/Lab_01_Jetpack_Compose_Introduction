package com.example.lab01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab01.ui.theme.Lab01Theme

// [1] Routes
sealed class Destination(val route: String) {
    object List: Destination("list")
    object Register: Destination("register")
    object Details: Destination("details/{attendeeId}") {
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

                    // [2] Use Navigation Composable
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                                    }
            }
        }
    }
}

// [2] Navigation Composable
@Composable
fun NavigationAppHost(navController: NavHostController) {
    val context = LocalContext.current

    // For each route, loads a Screen
    NavHost(navController = navController, startDestination = "list") {
        composable(Destination.List.route) { ListScreen(navController) }
        composable(Destination.Register.route) { RegisterScreen(navController) }
        composable(Destination.Details.route) { navBackStackEntry -> 
            val attendeeId = navBackStackEntry.arguments?.getString("attendeeId")
            
            if (attendeeId == null) {
                Toast.makeText(context, "Attendee ID is required", Toast.LENGTH_LONG).show()
            } else {
                DetailsScreen(attendeeId = attendeeId.toInt())
            }
        }
    }
}
