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
public class installment extends Activity implements OnClickListener
{
   EditText editbox1;
   EditText editbox2;
   //EditText editbox3;
   
   Button saveb,backb;
   Editable s1,s2;
        
   Spannable str;
   Spannable str2;
   private Long mRowId;
   public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.new_texti);
        editbox1 =(EditText) findViewById(R.id.title);
        editbox2 =(EditText) findViewById(R.id.insertdata);
       // editbox3 =(EditText) findViewById(R.id.insertdata1);
        mRowId = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
                String title1 = extras.getString(NotesDbAdapter1.KEY_TITLE1);
                String body1 = extras.getString(NotesDbAdapter1.KEY_BODY1);
                //String body1 = extras.getString(NotesDbAdapter.KEY_BODY1);
                mRowId = extras.getLong(NotesDbAdapter1.KEY_ROWID1);
                if (title1 != null) {
                        editbox1.setText(title1);
                }
                if (body1 != null) {
                        editbox2.setText(body1);
                }
                
              /*  if (body1 != null) {
                    editbox3.setText(body1);
            }*/
        }
        
        saveb =(Button) findViewById(R.id.save);
        saveb.setOnClickListener(this);
        backb =(Button) findViewById(R.id.back);
        backb.setOnClickListener(this);
       
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
                bundle.putString(NotesDbAdapter1.KEY_TITLE1, editbox1.getText().toString());
                bundle.putString(NotesDbAdapter1.KEY_BODY1, editbox2.getText().toString());
               // bundle.putString(NotesDbAdapter.KEY_BODY1, editbox3.getText().toString());
                if (mRowId != null) {
                        bundle.putLong(NotesDbAdapter1.KEY_ROWID1, mRowId);
                }
                Intent mIntent = new Intent();
                mIntent.putExtras(bundle);
                setResult(RESULT_OK, mIntent);
                finish();
                break;
                
            
            
            case R.id.back :
                Intent mIntent2 = new Intent(this,InstallmentActivity.class);
                startActivity(mIntent2);
                finish();
                break;  
                
           
        }
    }
}

