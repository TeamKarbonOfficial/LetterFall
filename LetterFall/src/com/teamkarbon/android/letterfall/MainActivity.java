package com.teamkarbon.android.letterfall;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	//Declare
	Button ButtonPlay;
	TextView TitleView;
	
	MediaPlayer MainMusic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		// SplashScreen (Not to use unless necessary)
    	//boolean Splash = false;
		//if (Splash = false) {
		//	Splash = true;
		//	Intent splashintent = new Intent(this, SplashScreen.class);
		//	startActivity(splashintent);
		//}
		
		//Initialize
		ButtonPlay = (Button) findViewById(R.id.ButtonPlay);
		TitleView = (TextView) findViewById(R.id.Title);
		
		/*
		 Below has been commented (Crashing Application)
		Typeface chantelli = Typeface.createFromAsset(getAssets(), "chantelli_antiqua.ttf");
		TitleView.setTypeface(chantelli);
		*/
		
		//Intent
		Intent gameintent = new Intent(this, GameActivity.class);
		
		setupMediaPlayer();
		addListenerOnButtonPlay(gameintent);
		new Welcome(this).show();
	}
	
	//MediaPlayer Set Up
	public void setupMediaPlayer() {
		MediaPlayer MainMusic = MediaPlayer.create(MainActivity.this, R.raw.electrofantasia);
		MainMusic.setLooping(true);
		MainMusic.start();
	}

	//Additional Method for MediaPlayer
	public void PlayMainMusic() {
		//MainMusic.start();
	}
	
	
	//Additional Method for MediaPlayer
	public void PauseMainMusic() {
		MainMusic.pause();
	}
	
	//Additional Method for MediaPlayer
	public void StopMainMusic() {
		MainMusic.stop();
		MainMusic.release();
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

	public void onPause() {
		super.onPause();
		//PauseMainMusic();
	}

	protected void onResume() {
		super.onResume();
		//PlayMainMusic();
	}
	
	protected void onDestroy() {
	    super.onDestroy();
	    //if(MainMusic != null) {
	    //	StopMainMusic();
	    //}
	}
}
