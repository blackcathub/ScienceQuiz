package com.cat.black.sciencequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LauncherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_screen);
    }

    public void starter (View v) {
        String name = ((EditText) findViewById(R.id.enter_name)).getText().toString();

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("USER_NAME", name);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
