package com.bmarohnic.doyouagree;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MyWebChromeClient extends WebChromeClient{

	@Override
	public boolean onJsConfirm(WebView view, String url, String message, JsResult result)
	{
		// WebChromeClient has the ability to control numerous features of the WebView.
		// However, I only needed the class to override the default functionality of displaying JS confirm dialog boxes.
		// The only thing needed to make this happen is to return false from the onJsConfirm method.
		return false;
	}

	
	
}
