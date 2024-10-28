package com.sysarcomp.shoppinglistapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.sysarcomp.shoppinglistapp.ui.utils.ShoppingItem


@Composable
fun Dialogg(
    innerPadding: PaddingValues,
    showDialog: MutableState<Boolean>,
    itemName: MutableState<String>,
    itemQuantity: MutableState<String>,
    sItems: MutableState<List<ShoppingItem>>
) {

    if (showDialog.value) {

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            confirmButton = { DialoggButtons(showDialog,itemName,itemQuantity,sItems) },
            title = {
                Text(
                    text = "Add shopping item"
                )
            },

            text = {

                DialogInputs(innerPadding,itemName, itemQuantity)
            }
        )


    }
}