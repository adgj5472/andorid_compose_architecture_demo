package com.onion.signin.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CircularProgressBar(isDisplayed: Boolean, modifier: Modifier = Modifier) {
    if (isDisplayed) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}