package com.sysarcomp.shoppinglistapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sysarcomp.shoppinglistapp.ui.utils.ShoppingItem

@Composable
fun ItemsList(innerPadding: PaddingValues, sItems: MutableState<List<ShoppingItem>>) {

    var showDeleteDialog by remember { mutableStateOf(false) }
    var itemToDelete by remember { mutableStateOf<ShoppingItem?>(null) } // Estado para almacenar el item seleccionado


    LazyColumn(

        // hace que los items se agregen desde arriba de todo de la pantalla,
        // y define un espacio entre el boton de agregar item
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {

        items(sItems.value) {

            // chequeamos si el item esta siendo editado
                item ->
            if (item.isEditing) {

                ShoppingItemEditor(item = item, onEditComplete = {

                        editedName, editedQuantity ->

                    updateItem(
                        item,
                        editedName = editedName,
                        editedQuantity = editedQuantity,
                        sItems
                    )
                })
            } else {

                // si no se esta editando el item , lo mostramos,
                ShoppingListBox(item = item,

                    onEditClick = {

                        // buscamos que item estamos editando, y seteamos a true
                        sItems.value = sItems.value.map { it.copy(isEditing = it.id == item.id) }

                    }, onDeleteClick = {

                        showDeleteDialog = true
                        itemToDelete = item
                    })
            }
        }
    }


    if (showDeleteDialog) {

        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text(text = "Confirmar eliminación") },
            text = { Text("¿Estás seguro de que deseas eliminar este item?") },

            confirmButton = {
                Button(onClick = {
                    sItems.value -= itemToDelete!! // Quitamos el item seleccionado
                    showDeleteDialog = false // Cerramos el diálogo
                    itemToDelete = null // Reiniciamos el item seleccionado
                }) {
                    Text("Delete")
                }
            },

            dismissButton = {
                Button(onClick = { showDeleteDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}


fun updateItem(
    item: ShoppingItem,
    editedName: String,
    editedQuantity: Int,
    sItems: MutableState<List<ShoppingItem>>
) {

    // Actualizamos la lista de items, estableciendo isEditing a false en este item
    sItems.value = sItems.value.map { it.copy(isEditing = false) }

    // Encontramos el item que estamos editando
    val editedItem = sItems.value.find { it.id == item.id }

    // Actualizamos los valores del item editado
    editedItem?.let {
        it.name = editedName
        it.quantity = editedQuantity
    }
}

