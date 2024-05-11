package com.example.bmicalculator

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity


class BmiTimelineActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bmi_timeline)

        val bmiTimelineView = findViewById<WebView>(R.id.bmiTimelineView)
        val webSettings = bmiTimelineView.getSettings()
        webSettings.javaScriptEnabled = true
        bmiTimelineView.loadUrl("file:///android_asset/html/bmi-time-changes.html")
    }
}