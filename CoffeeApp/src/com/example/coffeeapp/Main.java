package com.example.coffeeapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Main extends Activity {
	// Field to hold Order data
	private Orders orders;
	private Drink currentDrink;
	
	// Fields for User Interface Objects
	private Button btnHot;
	private Button btnCoffee;
	private Button btnFrap;
	private Button btnExpres;
	private Button btnTall; 
	private Button btnFrappuccino;
	private Button btnEspresso;
	// private Button btnTall;
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
		currentDrink = new Drink();
		
		
		// Bind to XML
		btnHot = (Button)findViewById(R.id.btnHot);
		btnCoffee = (Button)findViewById(R.id.btnCoffee);
		btnFrappuccino = (Button)findViewById(R.id.btnFrappuccino);
		btnEspresso = (Button)findViewById(R.id.btnEspresso);
		btnTall = (Button)findViewById(R.id.btnTall);
		btnGrande = (Button)findViewById(R.id.btnGrande);
		btnVenti = (Button)findViewById(R.id.btnVenti);
		spinnerFlavor = (Spinner)findViewById(R.id.spinnerFlavor);
		spinnerDairy = (Spinner)findViewById(R.id.spinnerDairy);
		btnAddDrink = (Button)findViewById(R.id.btnAddDrink);
		btnResetDrink = (Button)findViewById(R.id.btnReset);
		textDrinksAdded = (TextView)findViewById(R.id.textDrinksAdded);
		textCurrentDrink = (TextView)findViewById(R.id.textCurrentDrink); 
		
		// Populate the Spinner for Flavor
				ArrayAdapter<CharSequence> flavorAdapter = ArrayAdapter.createFromResource(this,
						R.array.flavor_array, android.R.layout.simple_spinner_dropdown_item);
		// Populate the Spinner for Dairy
				ArrayAdapter<CharSequence> dairyAdapter = ArrayAdapter.createFromResource(this,
						R.array.dairy_array, android.R.layout.simple_spinner_dropdown_item);
				  
				dairyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerDairy.setAdapter(dairyAdapter);
				
			
 				flavorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerFlavor.setAdapter(flavorAdapter);
			 
	}
		
		// Button to add drink
		public void btnAddDrinkClicked(View v){
			// Set Flavor and Dairy from Spinners
			currentDrink.setFlavor(String.valueOf(spinnerFlavor.getSelectedItem()));
			currentDrink.setDairy(String.valueOf(spinnerDairy.getSelectedItem()));
			//Add Drink to Orders
			orders.addDrink(currentDrink);
			// currentDrink = new Drink(); // Erase and Load new Drink
			textDrinksAdded.setText(String.valueOf(orders.getNumDrinks()));
			displayDrink(orders.getNumDrinks()-1);
			currentDrink = new Drink();
			btnCoffee.setBackgroundColor(Color.LTGRAY);
			btnFrappuccino.setBackgroundColor(Color.LTGRAY);
			btnEspresso.setBackgroundColor(Color.LTGRAY);
			
			btnTall.setBackgroundColor(Color.LTGRAY);
			btnGrande.setBackgroundColor(Color.LTGRAY);
			btnVenti.setBackgroundColor(Color.LTGRAY);
			
			
		}
		
		public void btnResetDrinkClicked(View v){
			currentDrink = new Drink();
			btnCoffee.setBackgroundColor(Color.LTGRAY);
			btnFrappuccino.setBackgroundColor(Color.LTGRAY);
			btnEspresso.setBackgroundColor(Color.LTGRAY);
			
			btnTall.setBackgroundColor(Color.LTGRAY);
			btnGrande.setBackgroundColor(Color.LTGRAY);
			btnVenti.setBackgroundColor(Color.LTGRAY);
			
			 textCurrentDrink.setText(" ");
		}
		
		private void displayDrink(int i){
			String sOrder= "Just ordered: ";
			Drink dDrink = orders.getDrink(i);
			sOrder += String.valueOf(dDrink.getSize()) + " ounces of ";
			sOrder += dDrink.getType() + " with ";
			sOrder += dDrink.getFlavor() + " and ";
			sOrder += dDrink.getDairy() + ".";
			// Display the Drink
			textCurrentDrink.setText(sOrder);
		}

		
	 
		 

	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// Function for the Hot/Cold Button
	public void btnHotClicked(View v){
		if (btnHot.getText() == "Hot"){
			btnHot.setText("Cold");
			btnHot.setBackgroundColor(Color.BLUE);
			currentDrink.setHot(false);
		}
		else {
			btnHot.setText("Hot");
			btnHot.setBackgroundColor(Color.RED);
			currentDrink.setHot(true);
			
		
	}
}
	public void btnCoffeeClicked(View v){
		currentDrink.setType("Coffee");
		btnCoffee.setBackgroundColor(Color.YELLOW);
		btnFrappuccino.setBackgroundColor(Color.LTGRAY);
		btnEspresso.setBackgroundColor(Color.LTGRAY);
	}
public void btnFrappuccinoClicked(View v){
	currentDrink.setType("Frappuccino");
	btnCoffee.setBackgroundColor(Color.LTGRAY);
	btnFrappuccino.setBackgroundColor(Color.YELLOW);
    btnEspresso.setBackgroundColor(Color.LTGRAY);
}
public void btnEspressoClicked(View v){
	currentDrink.setType("Espresso");
	btnCoffee.setBackgroundColor(Color.LTGRAY);
	btnFrappuccino.setBackgroundColor(Color.LTGRAY);
	btnEspresso.setBackgroundColor(Color.YELLOW);
}
// Functions For Drink Sizes
public void btnTallClicked(View v){
	currentDrink.setSize(8);
	btnTall.setBackgroundColor(Color.GREEN);
	btnGrande.setBackgroundColor(Color.LTGRAY);
	btnVenti.setBackgroundColor(Color.LTGRAY);
}
public void btnGrandeClicked(View v){
	currentDrink.setSize(12);
	btnTall.setBackgroundColor(Color.LTGRAY);
	btnGrande.setBackgroundColor(Color.GREEN);
	btnVenti.setBackgroundColor(Color.LTGRAY);
}
public void btnVentiClicked(View v){
	currentDrink.setSize(20);
	btnTall.setBackgroundColor(Color.LTGRAY);
	btnGrande.setBackgroundColor(Color.LTGRAY);
	btnVenti.setBackgroundColor(Color.GREEN);
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
