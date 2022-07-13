package com.example.lesson_1_third;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        send.setOnClickListener(view -> {
           //Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            //startActivity(intent);

            if (!mail.getText().toString().isEmpty()&&!theme.getText().toString().isEmpty()&&!message.getText().toString().isEmpty()){
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{mail.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
                //intent.setType("message/rfc822");
                intent.setData(Uri.parse("mailto:"));
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Cannot support this action",Toast.LENGTH_SHORT).show();

                }
            }else{
                Toast.makeText(MainActivity.this,"Fill all the fields",Toast.LENGTH_SHORT).show();
            }



        });

    }
}