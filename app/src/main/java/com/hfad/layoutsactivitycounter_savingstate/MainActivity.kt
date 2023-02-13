package com.hfad.layoutsactivitycounter_savingstate

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
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

    class State(var counterValue: Int) : Parcelable {
        constructor(parcel: Parcel) : this(parcel.readInt()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(counterValue)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<State> {
            override fun createFromParcel(parcel: Parcel): State {
                return State(parcel)
            }

            override fun newArray(size: Int): Array<State?> {
                return arrayOfNulls(size)
            }
        }
    }

}


