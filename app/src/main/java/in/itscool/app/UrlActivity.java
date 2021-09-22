package in.itscool.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UrlActivity extends AppCompatActivity {

	EditText urlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        urlText = findViewById(R.id. regUrl);

    }

	public void enterButtonClick(View view) {
    	String enteredUrl = urlText.getText().toString();
    	if (enteredUrl.length()>1 && enteredUrl.contains("itscoolapp.in")){

    		// save to sharedpref
			Preferences pref = new Preferences(this);
			pref.setMainUrl(enteredUrl);
			SmartWebView.ASWV_URL = enteredUrl;
			Intent i = new Intent(UrlActivity.this, MainActivity.class);
			startActivity(i);
			// close this activity
			finish();
		}else{
    		urlText.setError("invalid url");
		}
	}
}
