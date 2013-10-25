package com.bmarohnic.doyouagree;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebViewInterface {
	Context _context;
	
	// Set the context equal to the calling activity.
	WebViewInterface(Context c)
	{
		_context = c;
	}
	
	// Display the native toast for whatever string is passed in.
	@JavascriptInterface
	public void showToast(String toast)
	{
		Toast.makeText(_context, toast, Toast.LENGTH_LONG).show();
	}
	
	// If the user does not agree to the terms and conditions, exit the app.
	@JavascriptInterface
	public void disagreeClick()
	{
		System.exit(0);
	}
	
	// Once the user has accepted the terms and conditions, allow them to proceed to the main activity.
	@JavascriptInterface
	public void openPictureActivity(String username)
	{
		Intent pictureActivity = new Intent(_context, PictureActivity.class);
		pictureActivity.putExtra("username", username);
		_context.startActivity(pictureActivity);
	}
	
	// Save the user name and password to SharedPreferences.
	// This will allow TermsActivity to check whether or not a user has previously agreed to the terms and conditions.
	@JavascriptInterface
	public void saveLogin(String username, String password)
	{
		SharedPreferences sharedPref = _context.getSharedPreferences(_context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		editor.commit();
		
	}
}
