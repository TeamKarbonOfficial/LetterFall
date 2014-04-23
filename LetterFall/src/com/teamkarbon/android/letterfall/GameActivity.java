package com.teamkarbon.android.letterfall;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceView;

public class GameActivity extends Activity {

	public TimerTask updateTask;
	public SurfaceView GraphicScreen;
	public UpdateHandler UpdHandler = new UpdateHandler();
	public Timer reusabletimer = new Timer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		GraphicScreen = (SurfaceView) findViewById(R.id.surfaceView1);
		updateTask = new TimerTask()
		{
			@Override
			public void run()
			{
				//Inside here is the messages to be send to the update handler every time it updates.
				//Idea: http://stackoverflow.com/questions/6475541/how-to-do-an-update-loop
				//Create a Android.os.Message to send (in case any data needs to be transferred over to
				//	the handler. Use Arg1 and Arg2 for 2 int values, or for more complex values,
				//	use Message.setData() function
				Message msg = new Message();
				UpdHandler.sendMessage(msg);
			}
		};
		//Let's keep the game at 50 fps, shall we?
		reusabletimer.schedule(updateTask, 20);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	public class UpdateHandler extends Handler {
		//Note: ARG1 => 
        @Override
        public void handleMessage(Message msg) {
            //Ensure that the updateTask runs over and over again.
        	reusabletimer.schedule(updateTask, 20);
        }
    }
}