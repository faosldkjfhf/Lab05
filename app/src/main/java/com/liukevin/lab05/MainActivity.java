package com.liukevin.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView text;
    TextView set1;
    int settings;
    TextView set2;
    Button button;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        text = findViewById(R.id.text);
        set1 = findViewById(R.id.set1);
        set2 = findViewById(R.id.set2);
        button = findViewById(R.id.button);
        count = 0;
        editor = sharedPreferences.edit();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        Log.i("onCreate", "onCreate");
        editor.apply();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("counter", 0);
                count = 0;
                set2.setText("Set 2: 0");
                set1.setText("Set 1: 0");
                editor.apply();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        settings = sharedPreferences.getInt("counter", 0);
        editor.putInt("counter", settings + 1);
        set2.setText("Set 2: " + sharedPreferences.getInt("counter", 0));
        count++;
        set1.setText("Set 1: " + count);
        editor.apply();
    }
}
