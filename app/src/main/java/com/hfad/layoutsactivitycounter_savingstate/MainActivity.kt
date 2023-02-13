package com.hfad.layoutsactivitycounter_savingstate

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hfad.layoutsactivitycounter_savingstate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.counterBtnIncrement.setOnClickListener { viewModel.increment() }

        if (viewModel.state.value == null) {
            viewModel.initState(
                MyViewModel.State(
                    counterValue = 0))
        }
        viewModel.state.observe(this, Observer {
            renderState(it)
        })
    }

    private fun renderState(state: MyViewModel.State) {
        binding.textView.setText(state.counterValue.toString())
    }
}



