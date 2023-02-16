package com.onion.signin.ui.compose

import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.onion.signin.navigation.NavRoute
import com.onion.signin.presentation.viewmodel.ViewModelWebViewClient

object WebViewClientRoute : NavRoute<ViewModelWebViewClient> {
    override val route = "webViewClient/"

    @Composable
    override fun viewModel(): ViewModelWebViewClient = hiltViewModel()

    @Composable
    override fun Content(viewModel: ViewModelWebViewClient) = ComposeWebViewClient(viewModel)
}

@Composable
fun ComposeWebViewClient(viewModel: ViewModelWebViewClient) {
    // Declare a string that contains a url
    val mUrl = "https://www.google.com/"

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        val cookieManager: CookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        WebView(it).apply {
            settings.databaseEnabled = true
            settings.domStorageEnabled = true
            settings.javaScriptEnabled = true

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(mUrl)
        }
    }, update = {
        it.loadUrl(mUrl)
    })
}