package com.matteopasotti.motionlayout_fifa19

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class ExampleActivity : AppCompatActivity() {

    private lateinit var container: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val layout = intent.getIntExtra("layout_file_id", R.layout.layout_01)
        setContentView(layout)

        container = findViewById(R.id.motionLayout)

        if(layout != R.layout.layout_01) {
            val debugMode = if (intent.getBooleanExtra("showPaths", false)) {
                MotionLayout.DEBUG_SHOW_PATH
            } else {
                MotionLayout.DEBUG_SHOW_NONE
            }
            (container as? MotionLayout)?.setDebugMode(debugMode)
        }

    }
}