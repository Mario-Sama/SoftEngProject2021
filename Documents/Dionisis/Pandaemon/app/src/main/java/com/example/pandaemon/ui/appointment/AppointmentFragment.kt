package com.example.pandaemon.ui.appointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pandaemon.R

class AppointmentFragment : Fragment() {

    private lateinit var appointmentViewModel: AppointmentViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        appointmentViewModel =
                ViewModelProvider(this).get(AppointmentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_appointment, container, false)
        val textView: TextView = root.findViewById(R.id.text_appointment)
        appointmentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

        
    }






       //  val intent = Intent(this, Hospitals::class.java)
       // startActivity(intent)


    }
