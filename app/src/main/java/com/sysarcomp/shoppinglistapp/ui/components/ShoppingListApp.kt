package com.sysarcomp.shoppinglistapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sysarcomp.shoppinglistapp.ui.utils.ShoppingItem


@Composable
fun ShoppingListApp(innerPadding: PaddingValues) {

    // dialog control var
    val showDialog = remember {
        mutableStateOf(false)
    }

    // lista de tareas
    val sItems = remember {
        mutableStateOf(listOf<ShoppingItem>())
    }

    // dialog input field
    val itemName = remember {
        mutableStateOf("")
    }

    val itemQuantity = remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center
    ) {

        TopBar(innerPadding, showDialog)

        ItemsList(innerPadding, sItems)

        Dialogg(innerPadding, showDialog,itemName,itemQuantity,sItems)


    }


}