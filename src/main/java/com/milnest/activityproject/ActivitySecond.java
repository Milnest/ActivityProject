package com.milnest.activityproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {

    private TextView mResultField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mResultField = findViewById(R.id.resultField);
        getDataFromFirst();
    }

    /** Получает данные и выводит их в TextView. */
    private void getDataFromFirst() {
        String recievedStringKey = ActivityOne.sStringToSendKey;
        String recievedString = getIntent().getStringExtra(recievedStringKey);
        mResultField.setText(recievedString);
        mResultField.append("\n");

        String recievedStringMassKey = ActivityOne.sStringMassToSendKey;
        String[] recievedStringMass = getIntent().getStringArrayExtra(recievedStringMassKey);
        for (String s: recievedStringMass
             ) {
            mResultField.append(s);
            mResultField.append("\n");
        }

        String recievedIntKey = ActivityOne.sIntToSendKey;
        int recievedInt = getIntent().getIntExtra(recievedIntKey, 0);
        mResultField.append(String.valueOf(recievedInt));
        mResultField.append("\n");
    }


}
