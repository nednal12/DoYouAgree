package com.bmarohnic.doyouagree;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class TermsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_terms);
		 
		WebView webView = (WebView) findViewById(R.id.webView);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webView.setWebChromeClient(new MyWebChromeClient());
		webView.addJavascriptInterface(new WebViewInterface(this), "JSInterface");
		
		
		// Android documentation does not make this very clear.
		// The requested page will load in the browser and not
		// in the WebView if the following is not present
//		webView.setWebViewClient(new WebViewClient());
		
		webView.loadUrl("file:///android_asset/webViewSource.html");
		
//		webView.loadUrl("http://ask.com");
//		String htmlString = "<html><body>You scored <b>192</b> points.</body></html>";
		
//		String htmlString = "<html><body><button type='button' onClick='ok.performClick();'>OK</button>";
		
//		webView.loadData(htmlString, "text/html", null);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.terms, menu);
		
		return true;
	}

}
