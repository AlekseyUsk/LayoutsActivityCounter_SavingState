package com.hfad.layoutsactivitycounter_savingstate

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.hfad.layoutsactivitycounter_savingstate.databinding.ActivityMainBinding
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var state: State

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.counterBtnIncrement.setOnClickListener { increment() }

        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(counterValue = 0)
        renderState()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
    }

    private fun increment() {
       state.counterValue++
        renderState()
    }

    private fun renderState() {
        binding.textView.setText(state.counterValue.toString())
    }

    @Parcelize
    class State(var counterValue: Int) : Parcelable
}


