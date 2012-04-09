package builders.com;





import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class BuyersActivity extends ListActivity   {
	   private static final int ACTIVITY_CREATE=0;
	   private static final int ACTIVITY_EDIT=1;
	   private static final int INSERT_ID = Menu.FIRST;
	   private static final int DELETE_ID = Menu.FIRST + 1;
	   //private static final int DELETE_ID = Menu.FIRST + 2;
	//private static final String body1 = null;
	//private static final String editBody1 = null;
	   private NotesDbAdapter mDbHelper;
	   private Cursor mNotesCursor;
	   /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       setContentView(R.layout.main);
	        mDbHelper = new NotesDbAdapter(this);
	        mDbHelper.open();
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
	        mNotesCursor = mDbHelper.fetchAllNotes();
	        startManagingCursor(mNotesCursor);
	        // Create an array to specify the fields we want to display in the list (only TITLE)
	        String[] from = new String[]{NotesDbAdapter.KEY_TITLE};
	        // and an array of the fields we want to bind those fields to (in this case just text1)
	        int[] to = new int[]{R.id.text1};
	        // Now create a simple cursor adapter and set it to display
	        SimpleCursorAdapter notes = new SimpleCursorAdapter(this, R.layout.notes_row, mNotesCursor, from, to);
	        setListAdapter(notes);
	    }
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        super.onCreateOptionsMenu(menu);
	        menu.add(0, INSERT_ID, 0, "add buyer");
	        return true;
	    }
	    @Override
	    public boolean onMenuItemSelected(int featureId, MenuItem item) {
	        switch(item.getItemId()) {
	            case INSERT_ID:
	                createNote();
	                return true;
	        }
	        return super.onMenuItemSelected(featureId, item);
	    }
	    @Override
	    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
	        super.onCreateContextMenu(menu, v, menuInfo);
	        menu.add(0, DELETE_ID, 0, "Delete");
	    }
	    @Override
	    public boolean onContextItemSelected(MenuItem item) {
	        switch(item.getItemId()) {
	            case DELETE_ID:
	                AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	                mDbHelper.deleteNote(info.id);
	                fillData();
	                return true;
	        }
	        return super.onContextItemSelected(item);
	    }
	    private void createNote() {
	        Intent i = new Intent(this, paidbuyer.class);
	        startActivityForResult(i, ACTIVITY_CREATE);
	    }
	    @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        Cursor c = mNotesCursor;
	        c.moveToPosition(position);
	        Intent i = new Intent(this, paidbuyer.class);
	        i.putExtra(NotesDbAdapter.KEY_ROWID, id);
	        i.putExtra(NotesDbAdapter.KEY_TITLE, c.getString(c.getColumnIndexOrThrow(NotesDbAdapter.KEY_TITLE)));
	        i.putExtra(NotesDbAdapter.KEY_BODY, c.getString(c.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY)));
	       // i.putExtra(NotesDbAdapter.KEY_BODY, c.getString(c.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY)));
	        //i.putExtra(NotesDbAdapter.KEY_BODY2, c.getString(c.getColumnIndexOrThrow(NotesDbAdapter.KEY_BODY2)));
	        startActivityForResult(i, ACTIVITY_EDIT);
	    }
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
	        super.onActivityResult(requestCode, resultCode, intent);
	        Bundle extras =intent.getExtras();
	         switch(requestCode) {
	            case ACTIVITY_CREATE:
	                String title = extras.getString(NotesDbAdapter.KEY_TITLE);
	                String body = extras.getString(NotesDbAdapter.KEY_BODY);
	                //String body1 = extras.getString(NotesDbAdapter.KEY_BODY);
	               // String body2 = extras.getString(NotesDbAdapter.KEY_BODY2);
	                mDbHelper.createNote(title, body);
	                fillData();
	                break;
	            case ACTIVITY_EDIT:
	                Long rowId = extras.getLong(NotesDbAdapter.KEY_ROWID);
	                if (rowId != null) {
	                    String editTitle = extras.getString(NotesDbAdapter.KEY_TITLE);
	                    String editBody = extras.getString(NotesDbAdapter.KEY_BODY);
	                    String editBody1 = extras.getString(NotesDbAdapter.KEY_BODY);
	                   // String editBody2 = extras.getString(NotesDbAdapter.KEY_BODY2);
	                    mDbHelper.updateNote(rowId, editTitle, editBody);
	                }
	                fillData();
	                break;
	        }
	    }
	}