package com.sysarcomp.shoppinglistapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DialogInputs(
    innerPadding: PaddingValues,
    itemName: MutableState<String>,
    itemQuantity: MutableState<String>
) {

    Column {

        OutlinedTextField(
            value = itemName.value,
            onValueChange = { itemName.value = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            placeholder = { Text(text = "item name") }
        )

        OutlinedTextField(
            value = itemQuantity.value,
            onValueChange = { itemQuantity.value = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            placeholder = { Text(text = "item quantity") }
        )
    }
}