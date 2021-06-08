package com.example.pandaemon.ui.appointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pandaemon.R

class AppointmentFragment : Fragment()  {
    //private  Button yes,no;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var appointmentViewModel = ViewModelProvider(this).get(AppointmentViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_appointment, container, false)
        val textView: TextView = root.findViewById(R.id.text_appointment)
        appointmentViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root




/*
        val gobackbutton = findViewById<Button>(R.id.no)
        gobackbutton.setOnClickListener {
            val intent = Intent(this, Drawer::class.java)
            startActivity(intent)
        }*/
/*
        val button: Button = findViewById(R.id.yes)
        button.setOnClickListener {
            // Do something in response to button click
            val intent = Intent(this, AppointmentsSuggestions::class.java)
            startActivity(intent)
        }
*/
            //val intent = Intent(activity, AppointmentsSuggestions::class.java)
            //startActivity(intent)

/*
        val gobackbutton = findViewById<Button>(R.id.yes)
        gobackbutton.setOnClickListener {
            val intent = Intent(this, AppointmentsSuggestions::class.java)
            startActivity(intent)


*/
    }



    //override fun onBackPressed() {
    //if(wb_webView.canGoBack()) wb_webView.goBack() else super.onBackPressed()
    //}
}