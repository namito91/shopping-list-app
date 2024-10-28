package com.sysarcomp.shoppinglistapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sysarcomp.shoppinglistapp.ui.utils.ShoppingItem

@Composable
fun DialoggButtons(
    showDialog: MutableState<Boolean>,
    itemName: MutableState<String>,
    itemQuantity: MutableState<String>,
    sItems: MutableState<List<ShoppingItem>>
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(onClick = { addItem(itemName, itemQuantity, sItems,showDialog) }) {
            Text(text = "Add")
        }

        Button(onClick = { showDialog.value = false }) {
            Text(text = "Cancel")
        }
    }
}


fun addItem(
    itemName: MutableState<String>,
    itemQuantity: MutableState<String>,
    sItems: MutableState<List<ShoppingItem>>,
    showDialog: MutableState<Boolean>
) {

    if (itemName.value.isNotBlank() && itemQuantity.value.isNotBlank()) {

        val newItem = ShoppingItem(

            id = sItems.value.size + 1,
            name = itemName.value,
            quantity = itemQuantity.value.toInt()
        )

        sItems.value += newItem // agrega el nuevo elem a la lista

        showDialog.value = false // cerramos el alert dialog

        // reseteamos los valores,
        itemName.value = ""

        itemQuantity.value = ""
    }

}
