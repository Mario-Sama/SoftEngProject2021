package com.example.pandaemon.ui.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pandaemon.R

class DestinationFragment : Fragment() {

    private lateinit var destinationViewModel: DestinationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        destinationViewModel =
            ViewModelProvider(this).get(DestinationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_destination, container, false)
        val textView: TextView = root.findViewById(R.id.text_destination)
        destinationViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}