package com.example.numbertranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText getNumber;

    Button btn;
    TextView putWords;
    String convertedNumber;
    ImageButton speedBtn;
    TextToSpeech ttobj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getNumber = findViewById(R.id.getNumber);
        btn = findViewById(R.id.getWords);
        putWords = findViewById(R.id.putWords);
        speedBtn = findViewById(R.id.speechbtn);


        btn.setOnClickListener(v -> {

            String number = getNumber.getText().toString();
            if(number.isEmpty()){
                getNumber.setError("Required");
                return;
            }
            convertedNumber = NumToWords.toWords(number);
            putWords.setText(convertedNumber);
        });
        ttobj = new TextToSpeech(getApplicationContext(), status -> {
            if(status!=TextToSpeech.ERROR){
                ttobj.setLanguage(Locale.UK);
                ttobj.setPitch((float) 0);

            }
        });

        speedBtn.setOnClickListener(v -> {
            Toast.makeText(this, convertedNumber, Toast.LENGTH_SHORT).show();
            ttobj.speak(convertedNumber, TextToSpeech.QUEUE_FLUSH, null,null);

        });

    }

    public void onPause(){
        if(ttobj!=null){
            ttobj.stop();
            ttobj.shutdown();
        }
        super.onPause();
    }


}