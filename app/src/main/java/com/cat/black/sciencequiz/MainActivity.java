package com.cat.black.sciencequiz;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Header message updater: adds provided name
        TextView headerHallo = (TextView) findViewById(R.id.header_hello);
        String name = getIntent().getStringExtra("USER_NAME");
        headerHallo.setText(getString(R.string.header_hello, name));

        // Tints Results button while inactive on supported OS
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            (findViewById(R.id.button_result)).getBackground().setColorFilter(0xFFC5E1A5, PorterDuff.Mode.MULTIPLY);;
        }
    }

    // Custom Toast message creator
    Toast toast;
    private void popup (String msg) {
        // Layout inflater
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
        // Message text replace and format
        TextView text = (TextView) layout.findViewById(R.id.toast_txt);
        text.setShadowLayer(4, 2, 2, 0x80353535);
        text.setText(msg);
        // Anti-stack checker
        if(toast != null) toast.cancel();
        // Toast initializer
        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 192);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    // Lock answer changes method: true = unlocked, false = locked
    public void allowChanges(boolean clickable) {

        findViewById(R.id.q1_a).setClickable(clickable);
        findViewById(R.id.q1_b).setClickable(clickable);
        findViewById(R.id.q1_c).setClickable(clickable);
        findViewById(R.id.q1_d).setClickable(clickable);
        findViewById(R.id.q2_a).setClickable(clickable);
        findViewById(R.id.q2_b).setClickable(clickable);
        findViewById(R.id.q2_c).setClickable(clickable);
        findViewById(R.id.q2_d).setClickable(clickable);
        findViewById(R.id.q3_a).setClickable(clickable);
        findViewById(R.id.q3_b).setClickable(clickable);
        findViewById(R.id.q3_c).setClickable(clickable);
        findViewById(R.id.q3_d).setClickable(clickable);
        findViewById(R.id.q4_a).setClickable(clickable);
        findViewById(R.id.q4_b).setClickable(clickable);
        findViewById(R.id.q4_c).setClickable(clickable);
        findViewById(R.id.q4_d).setClickable(clickable);
        findViewById(R.id.q5_a).setClickable(clickable);
        findViewById(R.id.q5_b).setClickable(clickable);
        findViewById(R.id.q5_c).setClickable(clickable);
        findViewById(R.id.q5_d).setClickable(clickable);
        findViewById(R.id.q6_a).setClickable(clickable);
        findViewById(R.id.q6_b).setClickable(clickable);
        findViewById(R.id.q6_c).setClickable(clickable);
        findViewById(R.id.q6_d).setClickable(clickable);
        findViewById(R.id.q7_a).setClickable(clickable);
        findViewById(R.id.q7_b).setClickable(clickable);
        findViewById(R.id.q7_c).setClickable(clickable);
        findViewById(R.id.q7_d).setClickable(clickable);
        findViewById(R.id.q8_a).setClickable(clickable);
        findViewById(R.id.q8_b).setClickable(clickable);
        findViewById(R.id.q8_c).setClickable(clickable);
        findViewById(R.id.q8_d).setClickable(clickable);
        findViewById(R.id.q9_a).setClickable(clickable);
        findViewById(R.id.q9_b).setClickable(clickable);
        findViewById(R.id.q9_c).setClickable(clickable);
        findViewById(R.id.q9_d).setClickable(clickable);
        findViewById(R.id.q10_a).setClickable(clickable);
        findViewById(R.id.q10_b).setClickable(clickable);
        findViewById(R.id.q10_c).setClickable(clickable);
        findViewById(R.id.q10_d).setClickable(clickable);
    }

    // Number of correct answers counter
    int score = 0;

    // Check button action - build score, highlight errors, lock changes, show toast, unlock results
    public void checkCorrect(View v) {
        // Check for correct answers, build score (number of correct answers), highlight cards with errors in red
        score = 0;
        if (((RadioButton) findViewById(R.id.q1_b)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question1)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q2_a)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question2)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q3_c)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question3)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q4_c)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question4)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q5_d)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question5)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q6_a)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question6)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q7_c)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question7)).setCardBackgroundColor(0xffffebee);}
        if (((RadioButton) findViewById(R.id.q8_b)).isChecked()) {score += 1;}
        else {((CardView) findViewById(R.id.question8)).setCardBackgroundColor(0xffffebee);}
        if ((((CheckBox) findViewById(R.id.q9_a)).isChecked()) && (((CheckBox) findViewById(R.id.q9_c)).isChecked()) && !(((CheckBox) findViewById(R.id.q9_b)).isChecked()) && !(((CheckBox) findViewById(R.id.q9_d)).isChecked()))
        {score += 1;}
        else {((CardView) findViewById(R.id.question9)).setCardBackgroundColor(0xffffebee);}
        if ((((CheckBox) findViewById(R.id.q10_c)).isChecked()) && (((CheckBox) findViewById(R.id.q10_d)).isChecked()) && !(((CheckBox) findViewById(R.id.q10_a)).isChecked()) && !(((CheckBox) findViewById(R.id.q10_b)).isChecked()))
        {score += 1;}
        else {((CardView) findViewById(R.id.question10)).setCardBackgroundColor(0xffffebee);}
        // Lock answer changes after checked
        allowChanges(false);
        // Build toast message (add score), print on screen
        String final_message = getString(R.string.message_toast, String.valueOf(score));
        popup(final_message);
        // Unlock Results button, re-tint to standard color
        Button results = (Button) findViewById(R.id.button_result);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            results.getBackground().setColorFilter(0xFFAED581, PorterDuff.Mode.MULTIPLY);
        }
        results.setEnabled(true);
    }

    // Result button action - start result screen, pass name and score
    public void showResult (View v) {
        Intent i = new Intent(this, ResultScreen.class);
        i.putExtra("USER_NAME", getIntent().getStringExtra("USER_NAME"));
        i.putExtra("SCORE_VALUE", score);
        startActivity(i);
    }
}
