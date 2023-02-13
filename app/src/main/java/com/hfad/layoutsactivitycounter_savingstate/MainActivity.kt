package com.hfad.layoutsactivitycounter_savingstate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hfad.layoutsactivitycounter_savingstate.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var state: State


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.counterBtnIncrement.setOnClickListener { increment() }

        state = if (savedInstanceState == null) {
            State(
                counterValue = 0
            )
        } else {
            savedInstanceState.getSerializable(KEY_STATE) as State
        }
        renderState()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY_STATE, state)
    }

    private fun increment() {
       state.counterValue++
        renderState()
    }

    private fun renderState() {
        binding.textView.setText(state.counterValue.toString())
    }

    class State(var counterValue: Int) : Serializable

}


