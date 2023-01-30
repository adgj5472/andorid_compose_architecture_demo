package com.example.signin.ui.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.signin.R
import com.example.signin.navigation.NavRoute
import com.example.signin.presentation.viewmodel.ViewModelLogin
import com.example.signin.ui.theme.SigninTheme
import com.example.signin.ui.utils.CircularProgressBar

@Composable
fun ComposeLogin(
    navController: NavController,
    viewModel: ViewModelLogin = hiltViewModel()
) {
    val result = viewModel.state.collectAsState()
    val status = viewModel.loadingState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {
        CircularProgressBar(status.value)

        TxtField(
            label = { Text(stringResource(id = R.string.sign_in_account_text)) },
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        )
        TxtField(
            label = { Text(stringResource(id = R.string.sign_in_password_text)) },
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .width(300.dp)
        ) {
            Button(
                onClick = {
                    viewModel.doLogin()
                    navController.navigate(NavRoute.Sign.path)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite"
                )
                Text(stringResource(R.string.sign_in_login_in_text))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val listState = rememberLazyListState()
            LazyColumn(
                state = listState,
                modifier = Modifier.testTag("animal-list-testTag")
            ) {
                items(
                    items = result.value,
                    itemContent = { item ->
                        Text(text = item.id)
                    }
                )
            }
        }

//        Column(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            ExtendedFloatingActionButton(
//                onClick = { /* ... */ },
//                icon = {
//                    Icon(
//                        Icons.Filled.Favorite,
//                        contentDescription = "Favorite"
//                    )
//                },
//                text = { Text("Like") }
//            )
//            ConstraintLayoutContent()
//        }
    }
}

@Preview
@Composable
private fun CustomLinearProgressBar(){
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            color = Color.Red //progress color
        )
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TxtField(label: @Composable (() -> Unit)?, modifier: Modifier = Modifier) {
    val mutableState = remember { mutableStateOf("") }
    TextField(
        modifier = modifier,
        value = mutableState.value,
        onValueChange = {
            mutableState.value = it
        },
        label = label,
        trailingIcon = {

        }
    )
}

// @Preview function is use to see preview
// for our composable function in preview section
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SigninTheme {
        ConstraintLayout {
            val (account) = createRefs()
            TxtField(
                label = { Text(stringResource(id = R.string.sign_in_account_text)) },
                modifier = Modifier.constrainAs(account) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    SigninTheme {
        Button(onClick = {}) {
            Text(text = "123")
        }
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
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite"
                )
                Text(stringResource(R.string.sign_in_login_in_text))
            }
        }
    }
}