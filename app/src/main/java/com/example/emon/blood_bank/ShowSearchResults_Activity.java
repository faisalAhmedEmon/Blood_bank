package com.example.emon.blood_bank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import Database.DatabaseHelper;



public class ShowSearchResults_Activity extends AppCompatActivity {

    private String location;
    private String bloodGroup;

    private DatabaseHelper db;
    private ArrayList<Donor> donorList;

    private ListView listVw;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_search_result_layout);
        db = new DatabaseHelper(this);

        listVw = (ListView) findViewById(R.id.SearchlistView);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        location = data.getString("Location");
        bloodGroup = data.getString("Blood");

        getData();
        showData();


    }

    private void getData()
    {
        // connecting to the database to get data
        SQLiteDatabase database = db.getReadableDatabase();

        donorList = new ArrayList<Donor>();

        // Taking cursor position to matched Phone and Password to match login.
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE "
                + DatabaseHelper.KEY_LOCATION + "=? AND " + DatabaseHelper.KEY_BLOODGROUP + "=?", new String[]{location, bloodGroup});

        // cursor.getCount() will count how many results are there in the database
        if (cursor.moveToFirst()) {

            do {

                // reading the value from database
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_AGE));
                String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_PHONE));
                String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_PASSWORD));
                String bloodGroup = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_BLOODGROUP));
                String location = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_LOCATION));
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_ID));

                Donor donor = new Donor(name , age , phone , password , bloodGroup , location );
                donor.setId(id);

                donorList.add(donor);

            } while (cursor.moveToNext());
        }
    }

    private void showData()
    {
        DonorAdapter itemsAdapter = new DonorAdapter(this, donorList);
        //itemsAdapter.addAll(donorList);
        //ArrayAdapter<Donor> itemsAdapter =
        //new ArrayAdapter<Donor>(this, android.R.layout.simple_list_item_1, donorList);
        listVw.setAdapter(itemsAdapter);

    }

}
