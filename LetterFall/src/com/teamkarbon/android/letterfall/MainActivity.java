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
		
		Typeface chantelli = Typeface.createFromAsset(getAssets(), "chantelli_antiqua.ttf");
		TitleView.setTypeface(chantelli);
		
		//MediaPlayer
		MediaPlayer MainMusic = MediaPlayer.create(MainActivity.this, R.raw.electrofantasia);
		try {
			MainMusic.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MainMusic.setLooping(true);
		MainMusic.start();
		
		//Intent
		Intent gameintent = new Intent(this, GameActivity.class);
		
		addListenerOnButtonPlay(gameintent);
		new Welcome(this).show();
	}

	//Additional Method for MediaPlayer
	public void PlayMainMusic(MediaPlayer MainMusic) {
		MainMusic.start();
	}
	
	//Additional Method for MediaPlayer
	public void StopMainMusic(MediaPlayer MainMusic) {
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
}
