package com.sysarcomp.shoppinglistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sysarcomp.shoppinglistapp.ui.components.ShoppingListApp
import com.sysarcomp.shoppinglistapp.ui.theme.ShoppingListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            ShoppingListAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    ShoppingListApp(innerPadding)
                }
            }
        }
    }

}




