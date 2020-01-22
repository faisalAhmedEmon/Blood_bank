package com.example.emon.blood_bank;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile_Activity extends AppCompatActivity {

    TextView nameView;
    TextView ageView;
    TextView phoneView;
    TextView locationView;
    TextView bloodView;
    Button searchButton;

    private String id;
    private String name;
    private String age;
    private String phone;
    private String bloodGroup;
    private String location;


    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.profile_layout);
        OnClickButtonListener();

        nameView = (TextView) findViewById(R.id.nameView);
        ageView = (TextView) findViewById(R.id.ageView);
        phoneView = (TextView) findViewById(R.id.phoneView);
        locationView = (TextView) findViewById(R.id.locationView);
        bloodView = (TextView) findViewById(R.id.bloodView);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        name = data.get("Name").toString();
        age = data.get("Age").toString();
        phone = data.get("Phone").toString();
        bloodGroup = data.get("BloodGroup").toString();
        location = data.get("Location").toString();

        nameView.setText("Name: " + name);
        ageView.setText("Age: " + age);
        phoneView.setText("Phone: " + phone);
        locationView.setText("Location: " + location);
        bloodView.setText("Blood Group: " + bloodGroup);







    }

    public void OnClickButtonListener(){
        searchButton=(Button)findViewById(R.id.searchbtn);

        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentSearch = new Intent("com.example.emon.blood_bank.Search_Activity");
                        startActivity(intentSearch);
                    }
                }
        );
    }


}
