package com.example.jsonplaceholderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jsonplaceholderapp.ui.theme.AndroidLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val retrofit = Retrofit.Builder()
            .baseUrl(JsonPlaceholderService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(JsonPlaceholderService::class.java)
        val repository = UserRepository(api)

        setContent {
            JsonPlaceholderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val userViewModel: UserViewModel = viewModel(
                        factory = UserViewModelFactory(repository)
                    )

                    UserScreen(
                        viewModel = userViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}