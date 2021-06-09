package com.example.pandaemon.ui.appointment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppointmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Υπολογίζουμε προτιμέστερη Νοσοκομειακή Μονάδα βάσει της Τοποθεσίας σου . . ."
    }
    val text: LiveData<String> = _text
}