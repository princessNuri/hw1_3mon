package com.example.lesson_1_third;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText nextMail,nextTheme,nextMessage;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nextMail=findViewById(R.id.edittext_email);
        nextTheme=findViewById(R.id.edittext_theme);
        nextMessage=findViewById(R.id.edittext_message);
        back=findViewById(R.id.btn_back);
        back.setOnClickListener(view -> {
            Intent intent = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(intent);
        });
        Intent intent =getIntent();
        nextMail.setText(intent.getStringExtra(MainActivity.intentMail));
        nextTheme.setText(intent.getStringExtra(MainActivity.intentTheme));
        nextMessage.setText(intent.getStringExtra(MainActivity.intentMessage));

    }
}