package builders.com;

  
import android.content.BroadcastReceiver;  
import android.content.Context;  
import android.content.Intent;  
import android.os.Vibrator;  
import android.widget.Toast;  
		  
		public class MyBroadcastReceiver extends BroadcastReceiver {  
		    @Override  
		    public void onReceive(Context context, Intent intent) {  
		        Toast.makeText(context, "CONSTRUCTION OVER!!",  
		                Toast.LENGTH_LONG).show();  
		        // Vibrate the mobile phone  
		       Vibrator vibrator = (Vibrator) context  
		                .getSystemService(Context.VIBRATOR_SERVICE);  
		        vibrator.vibrate(2000);  
		    }  
		  
		}  