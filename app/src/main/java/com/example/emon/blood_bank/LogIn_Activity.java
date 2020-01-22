package com.example.emon.blood_bank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DatabaseHelper;

public class LogIn_Activity extends AppCompatActivity {
    public Button signInButton;
    public EditText username_Text,password_Text;

    String Username_, Password_;
    DatabaseHelper db;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_layout);
        db = new DatabaseHelper(this);

        username_Text= (EditText) findViewById(R.id.username_login);
        password_Text=(EditText)findViewById(R.id.password_login);
        signInButton= (Button)findViewById(R.id.signInBtn_);
        SubmitButton();




    }

    private void getLoginData()
    {
        Username_= username_Text.getText().toString();
        Password_ = password_Text.getText().toString();
    }

    private void checkLoginData()
    {
        // connecting to the database to get data
        SQLiteDatabase database = db.getReadableDatabase();

        // Taking cursor position to matched Phone and Password to match login.
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE "
                + DatabaseHelper.KEY_USERNAME + "=? AND " + DatabaseHelper.KEY_PASSWORD + "=?" , new String[]{Username_ , Password_});

        // cursor.getCount() will count how many results are there in the database
        if(cursor.getCount() > 0 && cursor != null)
        {
            cursor.moveToFirst();

            // reading the value from database
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_AGE));
            String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_PHONE));
            String bloodGroup = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_BLOODGROUP));
            String location = cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_LOCATION));
            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_ID));

            // Showing a Toast notification
            Toast.makeText(LogIn_Activity.this, "Login Success", Toast.LENGTH_SHORT).show();



            Intent intent = new Intent(LogIn_Activity.this , Profile_Activity.class);
            // putting all the information the intent which will be caught
            // in the profile class. Format - "Variable name" , value
            intent.putExtra("Name" , name);
            intent.putExtra("Age" , age);
            intent.putExtra("Phone" , phone);
            intent.putExtra("BloodGroup" , bloodGroup);
            intent.putExtra("Location" , location);
            intent.putExtra("ID" , id);
            startActivity(intent);



            // stopping back button press to no to let go back to login page again
            finish();

        }
        else
        {
            Toast.makeText(LogIn_Activity.this, "Login Failed , Try Again", Toast.LENGTH_SHORT).show();
        }

    }

    private void SubmitButton()
    {
        signInButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getLoginData();
                // if we keep Mobile and password blank and press next then nothing should happen.
                // user must put something in these text box.
                try
                {
                    checkLoginData();
                }
                catch (SQLiteException e)
                {
                    Log.d("Error : " , e.getStackTrace().toString());
                }
            }
        });
    }




}
