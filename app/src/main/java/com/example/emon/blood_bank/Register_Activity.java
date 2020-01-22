package com.example.emon.blood_bank;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import Database.DatabaseHelper;

import static Database.DatabaseHelper.DATABASE_NAME;
import static Database.DatabaseHelper.DATABASE_VERSION;


public class Register_Activity extends AppCompatActivity {
    public static final int PICK_IMAGE =100;

    DatabaseHelper db;

    Button buttonUploadImage, saveButton;
    ImageView umageView;
    EditText nameText,ageText,locationText,emailText,contactNoText,userNameText,passwordText;


    Spinner bloodGropuSpinner;

    private String name;
    private String age;
    private String phoneNumber;
    private  String username;
    private String password;

    private String bloodGroup;
    private String location;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        db = new DatabaseHelper(this);








        umageView=(ImageView)findViewById(R.id.imgView);
        // buttonUploadImage=(Button)findViewById(R.id.btnUploadImage);

       /* buttonUploadImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openGallery();

            }
        }); */
        nameText=(EditText)findViewById(R.id.name_txt);
        ageText=(EditText)findViewById(R.id.age_txt);
        userNameText= (EditText)findViewById(R.id.username_) ;
        passwordText= (EditText) findViewById(R.id.password_) ;
         locationText=(EditText)findViewById(R.id.location_txt);
         //emailText=(EditText)findViewById(R.id.email_txt);
         contactNoText=(EditText)findViewById(R.id.contactNo_txt);
        bloodGropuSpinner=(Spinner)findViewById(R.id.blgGrpSpinner);
        saveButton= (Button)findViewById(R.id.saveBtn);

        addData();



    }

    private void getData(){

        name=nameText.getText().toString();
        age=ageText.getText().toString();
        phoneNumber=contactNoText.getText().toString();
        username=userNameText.getText().toString();
        password=passwordText.getText().toString();
        bloodGroup=bloodGropuSpinner.getSelectedItem().toString();
        location=locationText.getText().toString();

    }

    public void addData(){
        saveButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                       boolean inserted= db.insertData(
                                nameText.getText().toString(),
                                ageText.getText().toString(),
                                contactNoText.getText().toString(),
                                userNameText.getText().toString(),
                                passwordText.getText().toString(),
                                bloodGropuSpinner.getSelectedItem().toString(),
                                locationText.getText().toString()

                        );

                        if(inserted==true)
                            Toast.makeText(Register_Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Register_Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );

    }




    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            umageView.setImageURI(selectedImage);



        }


    }

}
