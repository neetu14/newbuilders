package builders.com;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class InstallmentActivity extends ListActivity {
	   private static final int ACTIVITY_CREATE1=0;
	   private static final int ACTIVITY_EDIT1=1;
	   private static final int INSERT_ID1= Menu.FIRST;
	   private static final int DELETE_ID1 = Menu.FIRST + 1;
	   private NotesDbAdapter1 mDbHelper1;
	   private Cursor mNotesCursor1;
	   /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.maini);
	        mDbHelper1 = new NotesDbAdapter1(this);
	        mDbHelper1.open();
	        fillData();
	        registerForContextMenu(getListView());
	   }
	   public void onBackPressed() {
	        moveTaskToBack(true);
	        this.finish();
	        return;
	   }
	   private void fillData() {
	        // Get all of the rows from the database and create the item list
	        mNotesCursor1 = mDbHelper1.fetchAllNotes();
	        startManagingCursor(mNotesCursor1);
	        // Create an array to specify the fields we want to display in the list (only TITLE)
	        String[] from = new String[]{NotesDbAdapter1.KEY_TITLE1};
	        // and an array of the fields we want to bind those fields to (in this case just text1)
	        int[] to = new int[]{R.id.text2};
	        // Now create a simple cursor adapter and set it to display
	        SimpleCursorAdapter notes1 = new SimpleCursorAdapter(this, R.layout.notes_rowi, mNotesCursor1, from, to);
	        setListAdapter(notes1);
	    }
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        super.onCreateOptionsMenu(menu);
	        menu.add(0, INSERT_ID1, 0, "update percentage of completion");
	        return true;
	    }
	    @Override
	    public boolean onMenuItemSelected(int featureId, MenuItem item) {
	        switch(item.getItemId()) {
	            case INSERT_ID1: createNote();
	                return true;
	        }
	        return super.onMenuItemSelected(featureId, item);
	    }
	    @Override
	    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	        super.onCreateContextMenu(menu, v, menuInfo);
	        menu.add(0, DELETE_ID1, 0, "Delete");
	    }
	    @Override
	    public boolean onContextItemSelected(MenuItem item) {
	        switch(item.getItemId()) {
	            case DELETE_ID1:
	                AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	                mDbHelper1.deleteNote(info.id);
	                fillData();
	                return true;
	        }
	        return super.onContextItemSelected(item);
	    }
	    private void createNote() {
	        Intent i = new Intent(this, installment.class);
	        startActivityForResult(i, ACTIVITY_CREATE1);
	    }
	    @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        Cursor c = mNotesCursor1;
	        c.moveToPosition(position);
	        Intent i = new Intent(this,  installment.class);
	        i.putExtra(NotesDbAdapter1.KEY_ROWID1, id);
	        i.putExtra(NotesDbAdapter1.KEY_TITLE1, c.getString(c.getColumnIndexOrThrow(NotesDbAdapter1.KEY_TITLE1)));
	        i.putExtra(NotesDbAdapter1.KEY_BODY1, c.getString(c.getColumnIndexOrThrow(NotesDbAdapter1.KEY_BODY1)));
	        startActivityForResult(i, ACTIVITY_EDIT1);
	    }
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
	        super.onActivityResult(requestCode, resultCode, intent);
	        Bundle extras =intent.getExtras();
	         switch(requestCode) {
	            case ACTIVITY_CREATE1:
	                String title = extras.getString(NotesDbAdapter1.KEY_TITLE1);
	                String body = extras.getString(NotesDbAdapter1.KEY_BODY1);
	                mDbHelper1.createNote(title, body);
	                fillData();
	                break;
	            case ACTIVITY_EDIT1:
	                Long rowId = extras.getLong(NotesDbAdapter1.KEY_ROWID1);
	                if (rowId != null) {
	                    String editTitle = extras.getString(NotesDbAdapter1.KEY_TITLE1);
	                    String editBody = extras.getString(NotesDbAdapter1.KEY_BODY1);
	                    //String editBody1 = extras.getString(NotesDbAdapter1.KEY_BODY);
	                    mDbHelper1.updateNote(rowId, editTitle, editBody);
	                }
	                fillData();
	                break;
	        }
	    }
	}