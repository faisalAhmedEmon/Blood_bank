package com.example.emon.blood_bank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class Search_Activity extends AppCompatActivity {

    private EditText SearchLocationTxt;
    private Spinner SearchBloodGroupSpinner;
    private Button SearchSubmitBtn;

    private String location;
    private String bloodGroup;


    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.search_layout);

        SearchLocationTxt=(EditText)findViewById(R.id.searchLocationText);
        SearchBloodGroupSpinner=(Spinner)findViewById(R.id.searchBloodGroupSpinner);
        SearchSubmitBtn=(Button)findViewById(R.id.searchSubmitBtn);

        eventHandler();


    }

    private void eventHandler()
    {
        SearchSubmitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getData();
            }
        });
    }

    private void getData()
    {
        location = SearchLocationTxt.getText().toString();
        bloodGroup = SearchBloodGroupSpinner.getSelectedItem().toString();
     //   inputIsInValid = invalidDataCheck.hasNums(location);

       // if( inputIsInValid )
       // {
            //SearchLocationTxt.setText("");
       //     SearchLocationTxt.setError("Location Invalid");
            //SearchLocationTxt.setHintTextColor(255);
       // }
      //  else
       // {
            Intent intent = new Intent(this, ShowSearchResults_Activity.class);
            intent.putExtra("Location" , location);
            intent.putExtra("Blood" , bloodGroup);
            startActivity(intent);
     //   }
    }



}
