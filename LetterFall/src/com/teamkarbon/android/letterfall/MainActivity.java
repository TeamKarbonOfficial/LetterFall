package com.teamkarbon.android.letterfall;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	//Declare
	Button ButtonPlay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initialize
		ButtonPlay = (Button) findViewById(R.id.ButtonPlay);
		
		addListenerOnButtonPlay();
	}
	
	private void addListenerOnButtonPlay() {
		ButtonPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//My responsibility to fix this :) Leave it as a comment for now :P
				//Intent aboutintent = new Intent(this, AboutActivity.class);
				//startActivity(aboutintent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
