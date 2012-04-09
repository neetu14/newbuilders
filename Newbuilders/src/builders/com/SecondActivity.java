package builders.com;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity implements OnClickListener {
	
	private static final String TAG = null;
	Button buttonUpdate;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status1);
        
      
        
        setTitle(R.string.titlePrefs);
        //setTitle(R.string.titleTimeline); 
        setTitle(R.string.titleView);
       // setTitle(R.string.titleStart);
        //setTitle(R.string.titleStop);
    }
    
	
@Override
	    	public boolean onCreateOptionsMenu(Menu menu) {
	    		getMenuInflater().inflate(R.menu.menu, menu);
	    		return true;
	    	}
	        
	        @Override
	        public boolean onOptionsItemSelected(MenuItem item) {
	        	
	         switch(item.getItemId()){
	         
	         case R.id.itemPrefs:
	          startActivity(new Intent(this,BuyersActivity.class));
	          break;
	         
	          
	         case R.id.itemview:
		          startActivity(new Intent(this,DefaulterActivity.class));
		          break;
	          
	        /* case R.id.itemTimeline:
		          startActivity(new Intent(this,InstallmentActivity.class));
		          break;
		          
	         
		              
	         case R.id.itemstart:
	             Log.d(TAG, "onClick: starting srvice");
	             startService(new Intent(this,ServiceActivity.class));
	             break;
	           
	         case R.id.itemstop:
	             Log.d(TAG, "onClick: stopping srvice");
	             stopService(new Intent(this, ServiceActivity.class));
	             break;
		          
	         case R.id.itemsms:
	        	 startActivity(new Intent(this,SMS.class));
		          break; */   
		          
		          
	         }
	        	
	        	return  true;
	        }
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}

		
    }

