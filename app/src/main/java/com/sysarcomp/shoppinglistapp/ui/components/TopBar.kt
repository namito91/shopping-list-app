package com.sysarcomp.shoppinglistapp.ui.components


import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

@Composable
fun TopBar(innerPadding: PaddingValues, showDialog: MutableState<Boolean>) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
    ) {

        Button(
            onClick = { showDialog.value = true },
            modifier = Modifier.align(Alignment.Center)

        ) {

            Text(text = "Add item")
        }

    }


}