package com.example.pandaemon

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    private companion object{
        private const val TAG="MainActivity"
    }
    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

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
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.id.action_logout){
            Log.i(TAG,"Logged Out")
            auth.signOut()
            val logOutIntent = Intent(this, LoginActivity::class.java)
            logOutIntent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(logOutIntent)
        }
        return super.onOptionsItemSelected(item)
    }



}