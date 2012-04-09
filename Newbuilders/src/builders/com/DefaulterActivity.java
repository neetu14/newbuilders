package builders.com;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckedTextView;

public class DefaulterActivity extends Activity implements OnClickListener{
	CheckedTextView n1;
	CheckedTextView n2;
	CheckedTextView n3;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defaulterlist);
        setTitle(R.string.titleView);
        addPreferencesFromResource(R.layout.defaulterlist);
        
        n1 = (CheckedTextView) findViewById(R.id.name1);
        n1.setOnClickListener(this);
        
        n2 = (CheckedTextView) findViewById(R.id.name2);
        n2.setOnClickListener(this);
        
        n3 = (CheckedTextView) findViewById(R.id.name3);
        n3.setOnClickListener(this);
        
        
    }
    
    
    private void addPreferencesFromResource(int defaulterlist) {
		// TODO Auto-generated method stub
		
	}

	public void onClick(View v) {
		
		 //String phno = "tel:9392438004";
		 //Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(phno));
		 Intent callIntent1 = new Intent(Intent.ACTION_CALL);
		    callIntent1.setData(Uri.parse("tel:896464323"));
		    startActivity(callIntent1);
	}
	
	public void onClick1(View v) {
		 Intent callIntent2 = new Intent(Intent.ACTION_CALL);
		    callIntent2.setData(Uri.parse("tel:85873507897"));
		    startActivity(callIntent2);
	}
	
	public void onClick2(View v) {
		 Intent callIntent3 = new Intent(Intent.ACTION_CALL);
		    callIntent3.setData(Uri.parse("tel:79876769823"));
		    startActivity(callIntent3);
		       
		       
		}
		}
	

