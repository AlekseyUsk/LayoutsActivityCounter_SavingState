package com.hfad.layoutsactivitycounter_savingstate

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.hfad.layoutsactivitycounter_savingstate.databinding.ActivityMainBinding
import kotlin.properties.Delegates.notNull

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var counterValue by notNull<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        binding.counterBtnIncrement.setOnClickListener { increment() }

            if (savedInstanceState == null) {
                counterValue = 0
            } else {
                counterValue = savedInstanceState.getInt(KEY_COUTER)
            }
            renderState()
        }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUTER, counterValue)
    }

    private fun increment() {
        counterValue++
        renderState()
    }


    private fun renderState() {
        binding.textView.setText(counterValue.toString())
    }

}


