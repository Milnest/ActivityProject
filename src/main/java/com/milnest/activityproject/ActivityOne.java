package com.milnest.activityproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    private Button mSendButton;
    private Button mNewAppButton;
    public static String sStringToSendKey = "StringKey";
    public static String sStringMassToSendKey = "StringMassKey";
    public static String sIntToSendKey = "intKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        bindButtons();
    }

    private void bindButtons() {
        mSendButton = (Button)findViewById(R.id.sendButton);
        mNewAppButton = (Button) findViewById(R.id.newAppButton);
    }

    /** Отправляет данные во вторую активити. */
    private void sendDataToSecond() {
        Intent intentToSecond = new Intent(ActivityOne.this, ActivitySecond.class);

        //Формирование пар ключ-значение для отправки
        String stringToSend = "default string";
        sStringToSendKey = "StringKey";

        int intToSend = 1;
        sIntToSendKey = "intKey";

        String[] stringMassToSend = {"default string 0", "default string 1"};
        sStringMassToSendKey = "StringMassKey";

        //Отправка
        intentToSecond.putExtra(sStringToSendKey, stringToSend);
        intentToSecond.putExtra(sIntToSendKey, intToSend);
        intentToSecond.putExtra(sStringMassToSendKey, stringMassToSend);
        //Запуск activity
        startActivity(intentToSecond);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sendButton:
                sendDataToSecond();
                break;
            case R.id.newAppButton :
                openNewApp();
                break;
        }

    }

    private void openNewApp() {
        Uri address = Uri.parse("http://yandex.ru");
        Intent newAppIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(newAppIntent);
    }
}
