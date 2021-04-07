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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawQuarterCircleBalls(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val size : Float = Math.min(w, h) / sizeFactor
    val r : Float = size / (arcs + 2)
    val gap : Float = 90f / (arcs - 1)
    save()
    translate(w / 2, h / 2)
    paint.style = Paint.Style.STROKE
    drawArc(RectF(-size, -size, size, size), 0f, 90f * sf1, false, paint)
    paint.style = Paint.Style.FILL
    for (j in 0..(arcs - 1)) {
        save()
        rotate(gap * j)
        drawCircle(size, 0f, r * sf2, paint)
        restore()
    }
    restore()
}
fun Canvas.drawQCBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactpr
    drawQuarterCircleBalls(scale, w, h, paint)
}

class QuarterCircleBallsView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}