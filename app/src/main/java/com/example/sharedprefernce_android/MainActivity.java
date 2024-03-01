    package com.example.sharedprefernce_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.btn);
        textView=findViewById(R.id.textView);
         displaySavedMessage();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString();
                displayAndSaveText(message);
            }
        });
    }

        private void displaySavedMessage() {
        SharedPreferences preferences=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1=preferences.getString("message","");
        textView.setText(s1);

        }

        private void displayAndSaveText(String message) {
        //display text
            textView.setText(message);
              //saving to shared preference
            SharedPreferences preferences=getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("message",message);
            editor.commit();
        }
    }