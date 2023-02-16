package com.onion.signin.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onion.signin.R
import com.onion.signin.navigation.NavRoute
import com.onion.signin.presentation.viewmodel.ViewModelSign

object SignRoute : NavRoute<ViewModelSign> {
    override val route = "sign/"

    @Composable
    override fun viewModel(): ViewModelSign = hiltViewModel()

    @Composable
    override fun Content(viewModel: ViewModelSign) = ComposeSign(viewModel)
}

@Composable
fun ComposeSign(viewModel: ViewModelSign) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(stringResource(R.string.sign_in_sign_text))
            }
        }
    }
}

