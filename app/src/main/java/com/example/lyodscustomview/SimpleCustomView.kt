package com.example.lyodscustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SimpleCustomView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // For simplicity, let's make the view 100x100 pixels
        val desiredWidth = 200
        val desiredHeight = 200

        // Set the measured dimensions
        setMeasuredDimension(
            resolveSize(desiredWidth, widthMeasureSpec),
            resolveSize(desiredHeight, heightMeasureSpec)
        )
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {

    }

    override fun onDraw(canvas: Canvas) {

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}