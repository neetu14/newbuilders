package builders.com;



import java.util.Timer;
import java.util.TimerTask;

import android.app.PendingIntent;
import android.app.Service;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class ServiceActivity extends Service {

	private static final String TAG = "ServiceActivity";
		//private Timer timer = new Timer();

		
		
	//1.
	@Override
	public void onCreate() {
			//super.onCreate();
		//my service started
		
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
	}
	
	//2.
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStartCommand");
		startServicee();
		return START_STICKY;  
	}

	
	private void startServicee() { 
	
			//timer.scheduleAtFixedRate( new TimerTask() {

			//public void run()
		
		
				//Log.i("Service", "new activity is called"); 
				
			/*	Intent callIntent = new Intent(Intent.ACTION_CALL); 
				callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
				
				callIntent.setClass(this,WhereAmIActivity.class);
				startActivity(callIntent);
			*/
				
			/*	Intent i = new Intent();
				i.setClass(this, WhereAmIActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);   */
				
		
			//Do whatever you want to do every “INTERVAL”

			}
			
			//}, 0,5);

			//; }
	
		
		//Intent mIntent2 = new Intent(this,WhereAmIActivity.class);
      //  startActivity(mIntent2);
        
       // WhereAmIActivity whereami=new WhereAmIActivity();
     //   whereami.getApplication();
        
    
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, " My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
	                        }

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}




