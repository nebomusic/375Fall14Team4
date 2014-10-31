package com.example.silvawinnproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Congratulatory extends Activity {
public Button buttonNext2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_congratulatory);
		buttonNext2= (Button)findViewById(R.id.buttonNext2);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_congratulatory);
	}
	
	// Function to switch Intents
	public void buttonNext2Clicked(View v) {
		switch (v.getId()) {
		case R.id.buttonNext2:
			Intent intentOne = new Intent(this, Sound.class);
			startActivity(intentOne);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.congratulatory, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
