package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Scanner;
public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void action_sort(View view)
    {
    	ArrayList<Integer> numberlist = new ArrayList<Integer>();
    	Intent intent = new Intent(this, DisplayMessageActivity.class); 	
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	int i =0;
    	
    	String message = editText.getText().toString();
    	Scanner s = new Scanner(message);
    	
    	
    	numberlist.clear();
    	while(s.hasNext())
    	{
    		
    		numberlist.add(s.nextInt());
    		i++;

    	}
    	intent.putIntegerArrayListExtra(EXTRA_MESSAGE, numberlist);
    	intent.putExtra("listnumber", i);
 
    	startActivity(intent);
    	
    }
    
}
