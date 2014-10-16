package com.example.coffeeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Main extends Activity {
	// Field to hold Order data
	private Orders orders;
	private Drink curretnDrink;
	
	// Fields for User Interface Objects
	private Button btnHot;
	private Button btnCoffee;
	private Button btnFrap;
	private Button btnExpres;
	private Button btnTall; 
	private Button btnGrande;
	private Button btnVenti;
	private Spinner spinnerFlavor;
	private Spinner spinnerDairy;
	private Button btnAddDrink;
	private Button btnResetDrink;
	private TextView textDrinksAdded;
	private TextView textCurrentDrink;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Initialize Orders
		orders = new Orders();
		CurrentDrink = new Drink();
		
		// Bind to XML
		btnHot = (Button)findViewById(R.id.btnHot);
		btnCoffee = (Button)findViewById(R.id.btnCoffee);
		btnFrap = (Button)findViewById(R.id.btnFrap);
		btnExpres = (Button)findViewById(R.id.btnExpres);
		btnTall = (Button)findViewById(R.id.btnTall);
		btnGrande = (Button)findViewById(R.id.btnGrande);
		btnVenti = (Button)findViewById(R.id.btnVenti);
		spinnerFlavor = (Spinner)findViewById(R.id.spinnerFlavor);
		spinnerDairy = (Spinner)findViewById(R.id.spinnerDairy);
		btnAddDrink = (Button)findViewById(R.id.btnAddDrink);
		btnResetDrink = (Button)findViewById(R.id.btnResetDrink);
		textDrinksAdded = (TextView)findViewById(R.id.textDrinksAdded);
		textCurrentDrink = (TextView)findViewById(R.id.textCurrentDrink); 
		
		// Populate the Spinner for Flavor
		ArrayAdapter<CharSequence> flavorAdapter = ArrayAdapter.createFromResource(this,
				R.array.flavor_array, android.R.layout.simple_spinner_dropdown_item);
		
		// Specify the layout to use when the list of choices appears
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
