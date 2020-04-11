package com.example.square_squash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    private var barLeft: ImageView? = null

    // 位置
    private var yyy: Float = 0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        barLeft = findViewById(R.id.bar_left)  //上と左は同じでなければならない

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val frameLayout = findViewById<FrameLayout>(R.id.frame_layout)
        val location = IntArray(2)
        frameLayout.getLocationInWindow(location)
        val frameLayoutX = location[0].toFloat() //X座標
        val frameLayoutY = location[1].toFloat() //Y座標

        val barWidth = barLeft!!.width.toFloat()
        val barHeight = barLeft!!.height.div(2).toFloat()

        val displaylength = this.windowManager.defaultDisplay.width.toFloat()
        val displayTouchBegin = barHeight
        val displayTouchEnd = displaylength-barHeight

        val X = event.rawX
        val Y = event.rawY

        if (frameLayoutY+displayTouchBegin < Y && Y < frameLayoutY+displayTouchEnd ){
            if (event.action == MotionEvent.ACTION_MOVE) {
                barLeft!!.y = Y - frameLayoutY - barHeight
            }

        }
        return true
    }
}



//            if ( X<displaytouch1 && displaytouch1<Y && Y<displaytouch9 )