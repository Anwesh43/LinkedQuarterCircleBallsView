package com.example.quartercircleballsview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.content.Context

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#9C27B0",
    "#FF5722",
    "#00C853",
    "#01579B"
).map {
    Color.parseColor(it)
}.toTypedArray()
val arcs : Int = 6
val parts : Int = 2
val scGap : Float = 0.02f / parts
val strokeFactpr : Float = 90f
val sizeFactor : Float = 4.8f
val delay : Long = 20
