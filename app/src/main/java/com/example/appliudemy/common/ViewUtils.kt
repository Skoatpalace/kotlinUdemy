package com.example.appliudemy.common

import android.content.Context
import android.view.View
import android.widget.Toast
import java.time.Duration

fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

fun Context.toast(text: String, duration: Int = Toast.LENGTH_LONG){
    Toast.makeText(this, text, duration).show()
}