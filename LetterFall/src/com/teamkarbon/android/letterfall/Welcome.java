package com.teamkarbon.android.letterfall;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Welcome {

	private String PREFIX = "Welcome_";
	private Activity mActivity; 

	public Welcome(Activity context) {
		mActivity = context; 
	}

     public void show() {

		final String key = PREFIX;
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mActivity);
        boolean hasBeenShown = prefs.getBoolean(key, false);
        if(hasBeenShown == false){

        	// Title
            String title = "New?";
            
            // message
            String message = "It seems that this is your first time using this application! Would you like to go through a informative but short tutorial?";

            AlertDialog.Builder builder = new AlertDialog.Builder(mActivity)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton("Yes!", new Dialog.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Mark this as read
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean(key, true);
                            editor.commit();
                            dialogInterface.dismiss();
            				//startActivity(helpintent);
                        }
						
                    })
                    .setNegativeButton("No", new Dialog.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// Go straight to MainActivity
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean(key, true);
                            editor.commit();
						}
                    	
                    });
            builder.create().show();
        }
    }
}