package com.example.pandaemon.ui.guidelines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pandaemon.R

class GuidelinesFragment : Fragment() {

    private lateinit var guidelinesViewModel: GuidelinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        guidelinesViewModel =
            ViewModelProvider(this).get(GuidelinesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_guidelines, container, false)
        val textView: TextView = root.findViewById(R.id.text_guidelines)
        guidelinesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}