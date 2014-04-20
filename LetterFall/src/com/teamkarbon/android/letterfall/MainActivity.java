package com.teamkarbon.android.letterfall;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	//Declare
	Button ButtonPlay;
	TextView TitleView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initialize
		ButtonPlay = (Button) findViewById(R.id.ButtonPlay);
		TitleView = (TextView) findViewById(R.id.Title);
		
		//Intent
		Intent gameintent = new Intent(this, GameActivity.class);
		
		//Do sth to change the font.
		addListenerOnButtonPlay(gameintent);
		new Welcome(this).show();
	}
	
	private void addListenerOnButtonPlay(final Intent gameintent) {
		ButtonPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(gameintent);
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
