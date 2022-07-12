package com.example.lesson_1_third;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String intentMail = "mail";
    public static String intentTheme = "theme";
    public static String intentMessage = "message";
    private EditText mail,theme,message;
    private Button next,send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail = findViewById(R.id.mail);
        theme = findViewById(R.id.theme);
        message = findViewById(R.id.message);
        send = findViewById(R.id.btn_send);
        next = findViewById(R.id.btn_next);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(intentMail,mail.getText().toString());
                intent.putExtra(intentTheme,theme.getText().toString());
                intent.putExtra(intentMessage,message.getText().toString());
                startActivity(intent);
            }
        });
    }
}