package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;

    public static final String DATABASE_NAME="DonorManagement";

    public static final String TABLE_NAME="Donor";

    public static final String KEY_NAME="name";
    public static final String KEY_AGE="age";
    public static final String KEY_PHONE="phone";
    public static final String KEY_USERNAME="username";

    public static final String KEY_PASSWORD="password";
    public static final String KEY_BLOODGROUP="bloodGroup";
    public static final String KEY_LOCATION="location";

    public static final String KEY_ID="id";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
                + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME +" TEXT,"
                + KEY_AGE +" INTEGER,"
                + KEY_PHONE + " TEXT,"
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_BLOODGROUP + " TEXT,"
                + KEY_LOCATION + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData( String name, String age, String phoneNo, String username, String password, String bloodGrp ,String location) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(KEY_NAME, name);
        value.put(KEY_AGE, age);
        value.put(KEY_PHONE, phoneNo);
        value.put(KEY_USERNAME, username);
        value.put(KEY_PASSWORD, password);
        value.put(KEY_BLOODGROUP, bloodGrp);
        value.put(KEY_LOCATION, location);

        long result = db.insert(TABLE_NAME, null, value);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

    }


}
