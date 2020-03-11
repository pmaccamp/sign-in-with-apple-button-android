package com.willowtreeapps.signinwithapplebutton.view

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Custom web client that waits for [urlToIntercept] to be triggered and, when that happens, injects
 * [javascriptToInject] into the web view.
 */
internal class UrlInterceptorWebViewClient(
    private val urlToIntercept: String,
    private val javascriptToInject: String
) : WebViewClient() {
    override fun onLoadResource(view: WebView?, url: String?) {
        if (url != null && url.contains(urlToIntercept)) {
            view?.stopLoading()
            view?.loadUrl("javascript: (function() { $javascriptToInject } ) ()")
        } else {
            super.onLoadResource(view, url)
        }
    }
}