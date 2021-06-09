package com.example.pandaemon

import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


fun main() {
    val ri1= RiskIndexStatistics("scrap", _hasHeatpoints = true, noOfReviews = 7)
    ri1.hasReviews= true
    ri1.hasHeatpoints= false
    ri1.reviewAverage= 1.5
    ri1.heatpointRating= 6.0
    ri1.hasHeatpoints= true
    ri1.hasLivePop= true
    ri1.livePopRating= 9.1
    ri1.hasLivePop= false
    val param1= RiskIndexParameters(username = "Woop123", hasLivePop = false)
    param1.hasLivePop=true
    param1.hasReviews=false
    ri1.calculateRiskIndex()

   // val textView = (R.id.text)
// ...

// Instantiate the RequestQueue.
   // val queue = Volley.newRequestQueue(this)
   // val url = "https://www.google.com"

// Request a string response from the provided URL.
    /*val stringRequest = StringRequest(
        Request.Method.GET, url,
        Response.Listener<String> { response ->
            // Display the first 500 characters of the response string.
            textView.text = "Response is: ${response.substring(0, 500)}"
        },
        Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
    queue.add(stringRequest)
*/
}