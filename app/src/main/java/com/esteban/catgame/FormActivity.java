package com.esteban.catgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class FormActivity extends AppCompatActivity {

    EditText name, lastName, age, address;
    RadioGroup radioGroup;
    CheckBox checkBox;
    String color;
    String checkCats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = (EditText) findViewById(R.id.textName);
        lastName = (EditText) findViewById(R.id.textLastName);
        age = (EditText) findViewById(R.id.textAge);
        address = (EditText) findViewById(R.id.textAdress);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        checkBox = (CheckBox) findViewById(R.id.checkbox);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioBlue:
                        color = "azul";
                        break;

                    case R.id.radioGreen:
                        color = "verde";
                        break;

                    case R.id.radioOrange:
                        color = "naranja";
                        break;

                    case R.id.radioRed:
                        color = "rojo";
                        break;
                }
            }
        });
    }



    public void next(View view) {

        String sName = name.getText().toString();
        String sLastName = lastName.getText().toString();
        String sAge = age.getText().toString();
        String sAddress = address.getText().toString();
        if(checkBox.isChecked()){
            checkCats = "Si tiene gatos";
        }else{
            checkCats = "No tiene gatos";
        }

        Intent intent = new Intent(FormActivity.this, InstructionsActivity.class);
        intent.putExtra("name", sName);
        intent.putExtra("lastname", sLastName);
        intent.putExtra("age", sAge);
        intent.putExtra("address", sAddress);
        intent.putExtra("hasCats", checkCats);
        intent.putExtra("color", color);

        startActivity(intent);

    }
}
