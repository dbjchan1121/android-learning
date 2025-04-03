package com.example.demoproject.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import com.example.demoproject.R

class HtmlActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.html_activity)

        val webView: WebView = findViewById(R.id.webview)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }

        initWebConfig(webView)

//        webView.loadUrl("http://192.168.1.33:3000")
//        webView.loadUrl("file:///android_asset/h5/index.html")
        webView.loadUrl("file:///android_asset/virtual/index.html")


    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebConfig(webView: WebView?) {
        webView?.run {

            clearCache(true)
            settings.apply {
                javaScriptEnabled = true
                allowUniversalAccessFromFileURLs = true
                allowFileAccess = true
                allowFileAccessFromFileURLs = true
                //设置自适应屏幕，两者合用
                useWideViewPort = true //将图片调整到适合webview的大小
                loadWithOverviewMode = true // 缩放至屏幕的大小
                databaseEnabled = true// 开启本地数据库
                domStorageEnabled = true
                mixedContentMode =
                    WebSettings.MIXED_CONTENT_ALWAYS_ALLOW // 允许加载http网络图片（如果访问的链接是https，而网页里面的图片是http，那么就加载不出来，因此设置为允许加载）

                blockNetworkImage = false
                //缩放操作
                setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。
                builtInZoomControls = true //设置内置的缩放控件。若为false，则该WebView不可缩放
                displayZoomControls = false //隐藏原生的缩放控件
                allowFileAccess = true; //设置可以访问文件
                loadsImagesAutomatically = true //支持自动加载图片
                defaultTextEncodingName = "utf-8"//设置编码格式
                //textZoom = 100

            }
        }

    }
}