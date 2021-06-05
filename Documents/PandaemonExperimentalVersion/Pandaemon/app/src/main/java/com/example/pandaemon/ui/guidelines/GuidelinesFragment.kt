package com.example.pandaemon.ui.guidelines

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pandaemon.R
import com.example.pandaemon.ui.appointment.AppointmentViewModel
import kotlinx.android.synthetic.main.fragment_guidelines.*

abstract class GuidelinesFragment : Fragment() {

    private lateinit var guidelinesViewModel: GuidelinesViewModel

    private lateinit var appointmentViewModel: AppointmentViewModel

    abstract var writer :String
    abstract var content :String
    abstract var title :String
    val pageurl= "https://covid19.gov.gr/"
    abstract var creationDate : Int // Η Ημερομηνία Δημιουργίας του Ραντεβού αναπαρίσταται σε μορφή integer 8 ψηφίων, μιας και δεν υπάρχει τύπος δεδομένων
    // για ημερομηνίες ξεχωριστά, και θα είναι της μορφής DDMMYYYY , όπου DD: τα 2 ψηφία μέρας , MM: τα 2 ψηφία του μήνα και YYYYY τα 4 ψηφία του έτους.
    var notificationStatus : Boolean = false //By default τα notification είναι ανενεργά.




/*
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_appointment)

        webViewSetup()

    }
*/

    //@RequiresApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup(){
        wb_webView2.webViewClient = WebViewClient()

        wb_webView2.apply {
            loadUrl(pageurl)
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        guidelinesViewModel =
            ViewModelProvider(this).get(GuidelinesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_guidelines, container, false)
      /* val textView: TextView = root.findViewById(R.id.text_guidelines) */
        guidelinesViewModel.text.observe(viewLifecycleOwner, Observer {
          /*  textView.text = it  */
        })
        return root
    }





}