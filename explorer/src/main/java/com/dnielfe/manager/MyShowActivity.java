package com.dnielfe.manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dnielfe.manager.dialogs.CreateShowDialog;
//import static android.provider.AlarmClock.EXTRA_MESSAGE;
//import com.dnielfe.R;

public class MyShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_show);

//        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(CreateShowDialog.EXTRA_MESSAGE);
//
//        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

}