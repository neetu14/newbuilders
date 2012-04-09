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

public class BuildersActivity extends Activity implements OnClickListener {
	
	Button buttonUpdate;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        
        buttonUpdate.setOnClickListener(this);
    }
    
    //hello.....
    
    void onClick(View v) {
		switch (v.getId()){
		case R.id.buttonUpdate:
			Intent i=new Intent(this,SecondActivity.class);
			startActivity(i);
			break;
		}
		}
    
}
    /*	@Override
    	public boolean onCreateOptionsMenu(Menu menu) {
    		getMenuInflater().inflate(R.menu.menu, menu);
    		return true;
    	}
        
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        	
         switch(item.getItemId()){
         case R.id.itemPrefs:
          startActivity(new Intent(this,SecondActivity.class));
          break;
         }
        	
        	return  true;
        }
        
        
        
        }*/
    
    	