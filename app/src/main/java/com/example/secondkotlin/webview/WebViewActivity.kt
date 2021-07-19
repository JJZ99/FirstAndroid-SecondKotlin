package com.example.secondkotlin.webview

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.secondkotlin.databinding.ActivityWebViewBinding

/**
 * 在main下创建assets资源文件夹，将资源文件放在里面
 *
 * 加载本地视图或者网络视图
 * 加载网络资源时可以把它看成一个小网页，有很多回退或前进的方法
 */
class WebViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWebViewBinding

    var a :Int = 4


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //有些网页要支持JavaScript才能运行
        binding.wvLoc.settings.javaScriptEnabled = true
        binding.wvNet.settings.javaScriptEnabled = true

        binding.wvNet.webViewClient = object : WebViewClient(){
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d("WebView","onPageStart...")
            }
            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                //加载完后弹出一个对话框
                //mWvMain2.loadUrl("javascript:alert('hello')")
                //或者这样也可以弹出对话框
                binding.wvNet.evaluateJavascript("javascript:alert('hello')",null)

                //js调用java代码的方法
                //mWvMain2.addJavascriptInterface()
                Log.d("WebView","nPageFinish...")
            }
        }
        binding.wvNet.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }
            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                setTitle("你就害怕")
            }
        }


        //加载本地，参数可以是对话框
        binding.wvLoc.loadUrl("file:///android_asset/test.html")
        binding.wvNet.loadUrl("https://m.baidu.com")

    }

    /**
     * 按下返回键 默认是退出当前activity，如果希望是webview内页面后退
     * */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.wvLoc.canGoBack()) {
            binding.wvNet.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}