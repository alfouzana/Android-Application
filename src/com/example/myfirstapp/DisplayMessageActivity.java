package com.example.myfirstapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.method.ScrollingMovementMethod;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayMessageActivity extends Activity {
	public static String message ="";
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		ArrayList<Integer> numberlist = new ArrayList<Integer>();
				
		numberlist = intent.getIntegerArrayListExtra(MainActivity.EXTRA_MESSAGE);
		
		int numberofinputs = intent.getIntExtra("listnumber",0);
		Boolean triger = false;
		
		
		if (numberofinputs >12 || numberofinputs <10)
		{
			message = "Error: Maximum number List is 12, Minimum is 10";
			numberlist.clear();
			
		
		}
		else
		{
		int[] num = new int[12];
		for(int i=0; i < numberofinputs;i++)
		{
			num[i] = numberlist.get(i);
		}
		
	
		
		
		for(int i = 0; i < numberofinputs;i++)
		{
			if (num[i]>100 || num[i] <=0)
			{
				message="Error: Please enter number range from 1 - 100";
				triger = true;
			}
		}
		
		if (!triger)
			BubbleSort(num);
		}
		

		 // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(12);
	    textView.setMovementMethod(new ScrollingMovementMethod());
	    textView.setText(message);

	    // Set the text view as the activity layout
	    setContentView(textView);

	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	
	private static void BubbleSort(int[] num) {
		message = "";
		 for (int i = 0; i < num.length; i++) {
			 
			 for (int x = 1; x < num.length - i; x++) {
		    	
		    	if (num[x - 1] > num[x]) {
		            int temp = num[x - 1];
		            num[x - 1] = num[x];
		            num[x] = temp;
		         		}
		    	
		    		
		        for (int w=0; w<num.length;w++)	
		    	message += " " + num[w];
		        message += "\n";   
		    }
		    message += i+" cycle done"+"\n";
		  }
		}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
