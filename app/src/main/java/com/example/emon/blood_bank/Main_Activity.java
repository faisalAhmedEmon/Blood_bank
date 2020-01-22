package com.example.emon.blood_bank;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main_Activity extends AppCompatActivity {
    private Button signInButton;
    private Button registerButton;


    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.main_layout);
        OnClickButtonListener();
    }

    public void OnClickButtonListener(){
        signInButton=(Button)findViewById(R.id.signInBtn);
        registerButton=(Button)findViewById(R.id.registerBtn);


        signInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent_login =new Intent(Main_Activity.this , LogIn_Activity.class);
                        startActivity(intent_login);

                    }


                }

        );
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent("com.example.emon.blood_bank.Register_Activity");
                startActivity(intentRegister);
            }
        });






    }

}
