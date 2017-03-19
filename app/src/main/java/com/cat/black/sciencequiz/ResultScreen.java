package com.cat.black.sciencequiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        // Header message updater - add name
        TextView headerGratz = (TextView) findViewById(R.id.header_gratz);
        String name = getIntent().getStringExtra("USER_NAME");
        headerGratz.setText(getString(R.string.header_congrats, name));

        // Label message updater - fill with score
        TextView scoreLabel = (TextView) findViewById(R.id.score_label);
        int score = getIntent().getIntExtra("SCORE_VALUE", 0);
        scoreLabel.setText(getString(R.string.message_score, String.valueOf(score)));

        // Graph image switch @score
        ImageView graphImage = (ImageView) findViewById(R.id.img_graph);
        if (score == 0) graphImage.setImageResource(R.drawable.r0);
        switch(score) {
            case 0:
                graphImage.setImageResource(R.drawable.r0);
                break;
            case 1:
                graphImage.setImageResource(R.drawable.r1);
                break;
            case 2:
                graphImage.setImageResource(R.drawable.r2);
                break;
            case 3:
                graphImage.setImageResource(R.drawable.r3);
                break;
            case 4:
                graphImage.setImageResource(R.drawable.r4);
                break;
            case 5:
                graphImage.setImageResource(R.drawable.r5);
                break;
            case 6:
                graphImage.setImageResource(R.drawable.r6);
                break;
            case 7:
                graphImage.setImageResource(R.drawable.r7);
                break;
            case 8:
                graphImage.setImageResource(R.drawable.r8);
                break;
            case 9:
                graphImage.setImageResource(R.drawable.r9);
                break;
            case 10:
                graphImage.setImageResource(R.drawable.r10);
                break;
        }
    }

    // Restart  to launcher activity method
    private void returnToHome () {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        startActivity(i);
    }

    // Return button action
    public void pressReturn (View v) {
        returnToHome();
    }

    // Send button action
    public void pressSend (View v) {
        // Create message input strings
        String name = getIntent().getStringExtra("USER_NAME");
        String score = String.valueOf(getIntent().getIntExtra("SCORE_VALUE", 0));
        // Create send intent
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        // Build subject and body messages, start intent
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.sendto_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.sendto_body, name, score));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        returnToHome();
    }
}
