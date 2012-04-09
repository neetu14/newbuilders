package builders.com;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class paidbuyer extends Activity implements OnClickListener
{
   EditText editbox1;
   EditText editbox2;
  // EditText editbox3;
  // EditText editbox4;
   Button saveb,backb,smsb,percentb;
   Editable s1,s2;
        
   Spannable str;
   Spannable str2;
   private Long mRowId;
   public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.new_text);
        editbox1 =(EditText) findViewById(R.id.title);
        editbox2 =(EditText) findViewById(R.id.insertdata);
        //editbox3 =(EditText) findViewById(R.id.insertdata);
       // editbox4 =(EditText) findViewById(R.id.insertdata2);
        mRowId = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
                String title = extras.getString(NotesDbAdapter.KEY_TITLE);
                String body = extras.getString(NotesDbAdapter.KEY_BODY);
                //String body1 = extras.getString(NotesDbAdapter.KEY_BODY);
                //String body2 = extras.getString(NotesDbAdapter.KEY_BODY2);
                mRowId = extras.getLong(NotesDbAdapter.KEY_ROWID);
                if (title != null) {
                        editbox1.setText(title);
                }
                if (body != null) {
                        editbox2.setText(body);
                }
                
               /* if (body1 != null) {
                    editbox3.setText(body1);
            }*/
               /* if (body2 != null) {
                    editbox4.setText(body1);
            }*/  
                
        }
        
        saveb =(Button) findViewById(R.id.save);
        saveb.setOnClickListener(this);
        backb =(Button) findViewById(R.id.back);
        backb.setOnClickListener(this);
        smsb =(Button) findViewById(R.id.sms);
        smsb.setOnClickListener(this);
        percentb =(Button) findViewById(R.id.timer);
        percentb.setOnClickListener(this);
        
   }
   public void onBackPressed() {
        moveTaskToBack(true);
        return;
   }
   public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.save :
                Bundle bundle = new Bundle();
                bundle.putString(NotesDbAdapter.KEY_TITLE, editbox1.getText().toString());
                bundle.putString(NotesDbAdapter.KEY_BODY, editbox2.getText().toString());
               // bundle.putString(NotesDbAdapter.KEY_BODY, editbox3.getText().toString());
               // bundle.putString(NotesDbAdapter.KEY_BODY2, editbox4.getText().toString());
                if (mRowId != null) {
                        bundle.putLong(NotesDbAdapter.KEY_ROWID, mRowId);
                }
                Intent mIntent = new Intent();
                mIntent.putExtras(bundle);
                setResult(RESULT_OK, mIntent);
                finish();
                break;
                
                
            /*case R.id.delete :
                if(editbox2.getSelectionEnd() > editbox2.getSelectionStart()) 
                {
                        s1 = (Editable) editbox2.getText().subSequence(editbox2.getSelectionStart(), editbox2.getSelectionEnd());
                }else
                {
                        s1 = (Editable) editbox2.getText().subSequence(editbox2.getSelectionEnd(), editbox2.getSelectionStart());
                }
                editbox2.getText().replace(Math.min(editbox2.getSelectionStart(), editbox2.getSelectionEnd()), Math.max(editbox2.getSelectionStart(), editbox2.getSelectionEnd()),"", 0, 0);
                break;*/
            
            
            case R.id.back :
                Intent mIntent2 = new Intent(this,BuyersActivity.class);
                startActivity(mIntent2);
                finish();
                break;  
            
           case R.id.sms:
    			Intent i=new Intent(this,SMS.class);
    			startActivity(i);
    			break; 
    		
           case R.id.timer:
   			Intent i5 =new Intent(this,percentageActivity.class);
   			startActivity(i5);
   			break;
           
        }
    }
}
