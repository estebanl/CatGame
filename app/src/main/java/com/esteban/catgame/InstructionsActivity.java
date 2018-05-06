package com.esteban.catgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InstructionsActivity extends AppCompatActivity {

    TextView tName, tLastname, tAge, tAddress, tHasCats, tColor;
    String name, lastname, age, address, hasCats, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        name = getIntent().getStringExtra("name");
        lastname = getIntent().getStringExtra("lastname");
        age = getIntent().getStringExtra("age");
        address = getIntent().getStringExtra("address");
        hasCats = getIntent().getStringExtra("hasCats");
        color = getIntent().getStringExtra("color");

        tName = (TextView) findViewById(R.id.textViewName);
        tLastname = (TextView) findViewById(R.id.textViewLastName);
        tAge = (TextView) findViewById(R.id.textViewAge);
        tAddress = (TextView) findViewById(R.id.textViewAddress);
        tHasCats = (TextView) findViewById(R.id.textViewCats);
        tColor = (TextView) findViewById(R.id.textViewColor);

        tName.setText(name);
        tLastname.setText(lastname);
        tAge.setText(age);
        tAddress.setText(address);
        tHasCats.setText(hasCats);
        tColor.setText(color);

    }

    public void iniciar(View view) {

        Intent intent = new Intent(InstructionsActivity.this, MainActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }
}
