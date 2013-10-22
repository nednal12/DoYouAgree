package com.bmarohnic.doyouagree;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebViewInterface {
	Context _context;
	
	WebViewInterface(Context c)
	{
		_context = c;
	}
	
	@JavascriptInterface
	public void showToast(String toast)
	{
		Toast.makeText(_context, toast, Toast.LENGTH_LONG).show();
	}
}
