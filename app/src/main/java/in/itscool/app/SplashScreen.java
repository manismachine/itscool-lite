package in.itscool.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

	Preferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		pref = new Preferences(this);


		int SPLASH_TIME_OUT = 3000;
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity

				// check save pref
				String savedUrl = pref.getMainUrl();
				if (savedUrl.equalsIgnoreCase("")) {
					Intent i = new Intent(SplashScreen.this, UrlActivity.class);
					startActivity(i);
					finish();
				} else {
					SmartWebView.ASWV_URL = savedUrl;
					Intent i = new Intent(SplashScreen.this, MainActivity.class);
					startActivity(i);
					finish();
				}
			}
		}, SPLASH_TIME_OUT);
	}

}
