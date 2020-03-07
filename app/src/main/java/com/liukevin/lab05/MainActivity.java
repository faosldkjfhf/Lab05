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
    TextView set1;
    TextView onCreate1;
    TextView onCreate2;
    TextView onStart1;
    TextView onStart2;
    TextView onResume1;
    TextView onResume2;
    TextView onPause1;
    TextView onPause2;
    TextView onStop1;
    TextView onStop2;
    TextView onRestart1;
    TextView onRestart2;
    TextView onDestroy1;
    TextView onDestroy2;
    Counter counter;
    int settings;
    TextView set2;
    Button button;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        set1 = findViewById(R.id.set1);
        set2 = findViewById(R.id.set2);
        onCreate1 = findViewById(R.id.onCreate1);
        onCreate2 = findViewById(R.id.onCreate2);
        onStart1 = findViewById(R.id.onStart1);
        onStart2 = findViewById(R.id.onStart2);
        onResume1 = findViewById(R.id.onResume1);
        onResume2 = findViewById(R.id.onResume2);
        onPause1 = findViewById(R.id.onPause1);
        onPause2 = findViewById(R.id.onPause2);
        onStop1 = findViewById(R.id.onStop1);
        onStop2 = findViewById(R.id.onStop2);
        onRestart1 = findViewById(R.id.onRestart1);
        onRestart2 = findViewById(R.id.onRestart2);
        onDestroy1 = findViewById(R.id.onDestroy1);
        onDestroy2 = findViewById(R.id.onDestroy2);
        counter = new Counter();
        button = findViewById(R.id.button);
        count = 0;
        editor = sharedPreferences.edit();
        counter.setCreate(counter.getCreate() + 1);
        counter.addValue("create");
        onCreate1.setText("onCreate(): " + counter.getCreate());
        onCreate2.setText("onCreate(): " + sharedPreferences.getInt("create", 0));
        onStart2.setText("onStart(): " + sharedPreferences.getInt("start", 0));
        onResume2.setText("onResume(): " + sharedPreferences.getInt("resume", 0));
        onPause2.setText("onPause(): " + sharedPreferences.getInt("pause", 0));
        onStop2.setText("onStop(): " + sharedPreferences.getInt("stop", 0));
        onRestart2.setText("onRestart(): " + sharedPreferences.getInt("restart", 0));
        onDestroy2.setText("onDestroy(): " + sharedPreferences.getInt("destroy", 0));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("create", 0);
                editor.putInt("start", 0);
                editor.putInt("resume", 0);
                editor.putInt("pause", 0);
                editor.putInt("stop", 0);
                editor.putInt("restart", 0);
                editor.putInt("destroy", 0);
                editor.apply();

                counter.setCreate(0);
                counter.setDestroy(0);
                counter.setPause(0);
                counter.setRestart(0);
                counter.setResume(0);
                counter.setStart(0);
                counter.setStop(0);

                onCreate1.setText("onCreate(): 0");
                onCreate2.setText("onCreate(): 0");

                onPause1.setText("onPause(): 0");
                onPause2.setText("onPause(): 0");

                onRestart1.setText("onRestart(): 0");
                onRestart2.setText("onRestart(): 0");

                onStart1.setText("onStart(): 0");
                onStart2.setText("onStart(): 0");

                onStop1.setText("onStop(): 0");
                onStop2.setText("onStop(): 0");

                onDestroy1.setText("onDestroy(): 0");
                onDestroy2.setText("onDestroy(): 0");

                onResume1.setText("onResume(): 0");
                onResume2.setText("onResume(): 0");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        counter.setStart(counter.getStart() + 1);
        counter.addValue("start");
        onStart1.setText("onStart(): " + counter.getStart());
        onStart2.setText("onStart(): " + sharedPreferences.getInt("start", 0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter.setResume(counter.getResume() + 1);
        counter.addValue("resume");
        onResume1.setText("onResume(): " + counter.getResume());
        onResume2.setText("onResume(): " + sharedPreferences.getInt("resume", 0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        counter.setPause(counter.getPause() + 1);
        counter.addValue("pause");
        onPause1.setText("onPause(): " + counter.getPause());
        onPause2.setText("onPause(): " + sharedPreferences.getInt("pause", 0));
    }

    @Override
    protected void onStop() {
        super.onStop();
        counter.setStop(counter.getStop() + 1);
        counter.addValue("stop");
        onStop1.setText("onStop(): " + counter.getStop());
        onStop2.setText("onStop(): " + sharedPreferences.getInt("stop", 0));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        counter.setRestart(counter.getRestart() + 1);
        counter.addValue("restart");
        onRestart1.setText("onRestart(): " + counter.getRestart());
        onRestart2.setText("onRestart(): " + sharedPreferences.getInt("restart", 0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        counter.setDestroy(counter.getDestroy() + 1);
        counter.addValue("destroy");
        onDestroy1.setText("onDestroy(): " + counter.getDestroy());
        onDestroy2.setText("onDestroy(): " + sharedPreferences.getInt("destroy", 0));
    }

    private class Counter {
        int create, start, resume, pause, stop, restart, destroy;
        public Counter() {
            create = 0;
            start = 0;
            resume = 0;
            pause = 0;
            stop = 0;
            restart = 0;
            destroy = 0;
        }

        public void addValue(String key) {
            editor.putInt(key, sharedPreferences.getInt(key, 0) + 1);
            editor.apply();
        }

        public void setCreate(int value) {
            this.create = value;
        }

        public void setDestroy(int destroy) {
            this.destroy = destroy;
        }

        public void setRestart(int restart) {
            this.restart = restart;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setResume(int resume) {
            this.resume = resume;
        }

        public void setPause(int pause) {
            this.pause = pause;
        }

        public void setStop(int stop) {
            this.stop = stop;
        }

        public int getCreate() {
            return create;
        }

        public int getStart() {
            return start;
        }

        public int getStop() {
            return stop;
        }

        public int getRestart() {
            return restart;
        }

        public int getResume() {
            return resume;
        }

        public int getPause() {
            return pause;
        }

        public int getDestroy() {
            return destroy;
        }
    }
}

