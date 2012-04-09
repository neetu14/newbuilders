package builders.com;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class NotesDbAdapter1 
{
    public static final String KEY_TITLE1 = "title";
    public static final String KEY_BODY1 = "body";
   // public static final String KEY_BODY1 = "body1";
    public static final String KEY_ROWID1 = "_id";
    private static final String TAG = "NotesDbAdapter1";
    private DatabaseHelper mDbHelper1;
    private SQLiteDatabase mDb1;
    private static final String DATABASE_CREATE1 = "create table notes (_id integer primary key autoincrement, " + "title text not null, body text not null);";
    private static final String DATABASE_NAME1 = "data";
    private static final String DATABASE_TABLE1 = "notes";
    private static final int DATABASE_VERSION1 = 2;
	//private static final String body1 = null;
    private final Context mCtx1;
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
                super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
                db.execSQL(DATABASE_CREATE1);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
       {
                Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
                db.execSQL("DROP TABLE IF EXISTS notes");
                onCreate(db);
        }
    }
    public NotesDbAdapter1(Context ctx) {
        this.mCtx1 = ctx;
    }
    public NotesDbAdapter1 open() throws SQLException {
        mDbHelper1 = new DatabaseHelper(mCtx1);
        mDb1 = mDbHelper1.getWritableDatabase();
        return this;
    }
    public void close() {
        mDbHelper1.close();
    }
    public long createNote(String title, String body) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE1, title);
        initialValues.put(KEY_BODY1, body);
      // initialValues.put(KEY_BODY1, body1);
        return mDb1.insert(DATABASE_TABLE1, null, initialValues);
    }
    public boolean deleteNote(long rowId) {
        return mDb1.delete(DATABASE_TABLE1, KEY_ROWID1 + "=" + rowId, null) > 0;
    }
    public void deleteAllNote() {
        mDb1.delete(DATABASE_TABLE1, null, null);
    }
    public Cursor fetchAllNotes() {
        return mDb1.query(DATABASE_TABLE1, new String[] {KEY_ROWID1, KEY_TITLE1, KEY_BODY1}, null, null, null, null, null);
    }
    public Cursor fetchNote(long rowId) throws SQLException {
        Cursor mCursor = mDb1.query(true, DATABASE_TABLE1, new String[] {KEY_ROWID1, KEY_TITLE1, KEY_BODY1}, KEY_ROWID1 + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
                mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateNote(long rowId, String title, String body) {
        ContentValues args = new ContentValues();
        args.put(KEY_TITLE1, title);
        args.put(KEY_BODY1, body);
        //args.put(KEY_BODY1, body1);
        return mDb1.update(DATABASE_TABLE1, args, KEY_ROWID1 + "=" + rowId, null) > 0;
    }
}