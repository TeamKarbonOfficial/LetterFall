package com.teamkarbon.android.letterfall;

import java.util.Timer;
import java.util.TimerTask;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.SurfaceView;
import android.widget.TextView;

public class GameActivity extends Activity implements SensorEventListener {
	
	/*
	 Mass Commenting because it is crashing application
	 FIX Needed before uncommenting and committing
	 */

	private SensorManager SensorManager;
	private Sensor Acc;

	
	public TimerTask updateTask;
	public SurfaceView GraphicScreen;
	public UpdateHandler UpdHandler = new UpdateHandler();
	public Timer reusabletimer = new Timer();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		// Accelerometer
		SensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Acc = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		SensorManager.registerListener(this, Acc, SensorManager.SENSOR_DELAY_GAME);

		
		GraphicScreen = (SurfaceView) findViewById(R.id.surfaceView1);
		updateTask = new TimerTask() {
			@Override
			public void run() {
				// Inside here is the messages to be send to the update handler
				// every time it updates.
				// Idea:
				// http://stackoverflow.com/questions/6475541/how-to-do-an-update-loop
				// Create a Android.os.Message to send (in case any data needs
				// to be transferred over to
				// the handler. Use Arg1 and Arg2 for 2 int values, or for more
				// complex values,
				// use Message.setData() function
				Message msg = new Message();
				UpdHandler.sendMessage(msg);
			}
		};
		// Let's keep the game at 50 fps, shall we?
		new Timer().schedule(updateTask, 20);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	
	public class UpdateHandler extends Handler {
		// Note: ARG1 =>
		@Override
		public void handleMessage(Message msg) {
			// Ensure that the updateTask runs over and over again.
			new Timer().schedule(updateTask, 20);
		}
	}
	

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// Some calculations if user calibrate the sensor
		
	}

	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
		//Initialize
		TextView textViewX = (TextView) findViewById(R.id.textViewX);
		TextView textViewY = (TextView) findViewById(R.id.textViewY);
		TextView textViewZ = (TextView) findViewById(R.id.textViewZ);
		
	    Sensor mySensor = sensorEvent.sensor;
	    
	    if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
	        float x = sensorEvent.values[0];
	        float y = sensorEvent.values[1];
	        float z = sensorEvent.values[2];
	        
	        String xvalue = "X: " + Float.toString(x);
	        String yvalue = "Y: " + Float.toString(y);
	        String zvalue = "Z: " + Float.toString(z);
	        
	        textViewX.setText(xvalue);
	        textViewY.setText(yvalue);
	        textViewZ.setText(zvalue);
	    }
	}	
}