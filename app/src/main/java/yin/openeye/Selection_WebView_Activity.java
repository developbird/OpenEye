package yin.openeye;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Selection_WebView_Activity extends AppCompatActivity {
    private WebView mWebView;
    private String TAG = "Selection_WebView_Activity";
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_item_webview);
        mWebView = (WebView) findViewById(R.id.webView);
        init();
    }
        public void init() {

            //1、使用我们自己的WebView需要
            mWebView.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    Toast.makeText(Selection_WebView_Activity.this, "开始加载", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    Toast.makeText(Selection_WebView_Activity.this, "加载结束", Toast.LENGTH_SHORT).show();
                }
            });


            //2、设置我们自己的客户端可以启动JS程序
            WebSettings settings = mWebView.getSettings();
            settings.setJavaScriptEnabled(true);

            //3、设置WebView的事件处理客户端
            mWebView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    Log.e(TAG,"newProgress->"+newProgress);
                }
            });

            //4、加载
            mWebView.loadUrl("http://www.wandoujia.com/eyepetizer/article.html?nid=967&shareable=true");
           // mWebView.loadUrl("http://wwww.baidu.com");
        }

}
