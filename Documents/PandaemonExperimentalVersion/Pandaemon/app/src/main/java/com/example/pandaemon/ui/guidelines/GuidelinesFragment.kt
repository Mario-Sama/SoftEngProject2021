package com.example.pandaemon.ui.guidelines

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebViewFragment
import androidx.fragment.app.Fragment
import com.example.pandaemon.R
//import com.example.pandaemon.util.logDebug
import kotlinx.android.synthetic.main.fragment_guidelines.*

/*
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



    //try 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guidelines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebView: WebView = view.findViewById(R.id.wb_webView2)
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }

        myWebView.loadUrl("https://covid19.gov.gr/")
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.useWideViewPort = true


    }




    //try 2
/*
    @RequiresApi(Build.VERSION_CODES.O)
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

        webViewSetup()

        return root

    }

    //@RequiresApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    fun webViewSetup(){
        wb_webView2.webViewClient = WebViewClient()

        wb_webView2.apply {
            loadUrl("https://covid19.gov.gr/")
            wb_webView2.settings.javaScriptEnabled = true
            wb_webView2.settings.safeBrowsingEnabled = true
        }

    }
*/
}

 */



class GuidelinesFragment : Fragment() {

    companion object {
        val KEY_URL = "https://covid19.gov.gr/"
        fun newInstance(url: String): GuidelinesFragment {
            val fragment = GuidelinesFragment()
            val args = Bundle()
            args.putString(KEY_URL, url)
            fragment.arguments = args
            return fragment
        }
    }

    interface OnWebViewCreatedListener {
        fun onWebViewCreated()
    }

    private var mUrl: String? = null
    private var mOnWebViewCreatedListener: OnWebViewCreatedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_guidelines, container, false)
        // not using ButterKnife to ensure WebView is private
        mUrl = requireArguments().getString(KEY_URL)
        if (TextUtils.isEmpty(mUrl)) {
            throw IllegalArgumentException("Empty URL passed to WebViewFragment!")
        }
        //logDebug { "Loading URL: " + mUrl!! }

        // enable remote debugging
        if (0 != (ApplicationInfo.FLAG_DEBUGGABLE and (activity?.applicationInfo?.flags ?: 0))
            && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        return view
    }

    fun setOnWebViewCreatedListener(listener: OnWebViewCreatedListener) {
        mOnWebViewCreatedListener = listener
    }

    @SuppressLint("JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settings = wb_webView2.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        wb_webView2.webViewClient = DefaultWebViewClient()
        mUrl?.let { wb_webView2.loadUrl(it) }

        mOnWebViewCreatedListener?.onWebViewCreated()
    }

    override fun onResume() {
        super.onResume()
        wb_webView2.onResume()
    }

    override fun onPause() {
        super.onPause()
        wb_webView2.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // don't hold on to the listener (which could potentially be an Activity)
        mOnWebViewCreatedListener = null
        // destroy the WebView completely
        if (wb_webView2 != null) {
            // the WebView must be removed from the view hierarchy before calling destroy
            // to prevent a memory leak (#75)
            // See https://developer.android.com/reference/android/webkit/WebView.html#destroy%28%29
            (wb_webView2.parent as ViewGroup).removeView(wb_webView2)
            wb_webView2.removeAllViews()
            wb_webView2.destroy()
        }
    }

    // our custom methods
    val currentUrl: String?
        get() {
            if (wb_webView2 == null) {
                return null
            }
            var currentLoadedUrl: String? = wb_webView2.originalUrl
            if (currentLoadedUrl == null) {
                currentLoadedUrl = mUrl
            }
            return currentLoadedUrl
        }

    val currentTitle: String?
        get() {
            if (wb_webView2 == null) {
                return null
            }
            return wb_webView2.title
        }

    fun evaluateJavascript(javascript: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            wb_webView2.evaluateJavascript(javascript, null)
        } else {
            wb_webView2.loadUrl("javascript:" + javascript)
        }
    }

    @SuppressLint("JavascriptInterface", "AddJavascriptInterface")
    fun setJSInterface(jsInterface: Any, name: String) {
        wb_webView2.addJavascriptInterface(jsInterface, name)
    }

    fun setWebViewClient(webViewClient: DefaultWebViewClient) {
        wb_webView2.webViewClient = webViewClient
    }

    fun setWebChromeClient(webChromeClient: DefaultWebChromeClient) {
        wb_webView2.webChromeClient = webChromeClient
    }

    fun onBackPressed(): Boolean {
        if (wb_webView2.canGoBack()) {
            wb_webView2.goBack()
            return true
        }
        return false
    }

    open class DefaultWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }
    }

    class DefaultWebChromeClient : WebChromeClient()    // no-op

}