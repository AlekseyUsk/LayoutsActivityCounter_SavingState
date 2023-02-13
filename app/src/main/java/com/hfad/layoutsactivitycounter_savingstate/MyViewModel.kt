package com.hfad.layoutsactivitycounter_savingstate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    val state : MutableLiveData<State> get() = stateLiveData
    private val stateLiveData = MutableLiveData<State>()

    fun initState(state : State){     // Инициализирует LiveData новым состоянием
        stateLiveData.value = state
    }

     fun increment() {
       val oldState = stateLiveData.value
        stateLiveData.value = oldState?.copy(
            counterValue = oldState.counterValue +1)
    }
    data class State(
        val counterValue : Int
    )
}