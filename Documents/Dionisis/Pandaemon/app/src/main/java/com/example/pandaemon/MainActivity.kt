package com.example.pandaemon

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.nav_header_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getresponse = findViewById<TextView>(R.id.getresponse)

        val uploadbutton = findViewById<Button>(R.id.uploadbutton)
        uploadbutton.setOnClickListener {
            val intent = Intent(this, UploadDataWindow::class.java)
            startActivity(intent)
        }

        val staysafebutton = findViewById<Button>(R.id.staysafebutton)
        staysafebutton.setOnClickListener {
            val intent = Intent(this, Drawer::class.java)
            startActivity(intent)
        }
        val dbtestbutton = findViewById<Button>(R.id.dbtestbutton)
        dbtestbutton.setOnClickListener {
            sendGetRequest();
        }

    }


        @SuppressLint("SetTextI18n")
        private fun sendGetRequest() {
            val queue = Volley.newRequestQueue(this)
            val url = "http://10.0.2.2/Pandaemon/getdata.php"
            println("peos")
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    getresponse.setText( "Response is:" +response)
            }, Response.ErrorListener { getresponse.text = "That didn't work!" })
            queue.add(stringRequest)
    }

}