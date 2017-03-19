package com.cat.black.sciencequiz;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
            (findViewById(R.id.button_result)).getBackground().setColorFilter(0xFFC5E1A5, PorterDuff.Mode.MULTIPLY);
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

    // Tint RadioButton/CheckBox and text to red
    public void paintRed (int bid) {
        CompoundButton button = (CompoundButton) findViewById(bid);
        // Recolor text
        int red = 0xFFFF6969;
        button.setTextColor(red);
        // Recolor button
        ColorStateList colorState = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled}
                },
                new int[] {
                        red
                }
        );
        if(Build.VERSION.SDK_INT>=21) {
            button.setButtonTintList(colorState);
        }
    }

    // Tint RadioButton/CheckBox and text to green
    public void paintGreen (int bid) {
        CompoundButton button = (CompoundButton) findViewById(bid);
        // Recolor text
        int green = 0xFF33691E;
        button.setTextColor(green);
        // Recolor button
        ColorStateList colorState = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_enabled}
                },
                new int[] {
                        green
                }
        );
        if(Build.VERSION.SDK_INT>=21) {
            button.setButtonTintList(colorState);
        }
    }

    // Tint card background to red
    public void tintRed (int cid) {
        CardView card = (CardView) findViewById(cid);
        card.setCardBackgroundColor(0xffffebee);
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
        else {tintRed(R.id.question1); paintRed(R.id.q1_a); paintRed(R.id.q1_c); paintRed(R.id.q1_d); paintGreen(R.id.q1_b);}
        if (((RadioButton) findViewById(R.id.q2_a)).isChecked()) {score += 1;}
        else {tintRed(R.id.question2); paintRed(R.id.q2_b); paintRed(R.id.q2_c); paintRed(R.id.q2_d); paintGreen(R.id.q2_a);}
        if (((RadioButton) findViewById(R.id.q3_c)).isChecked()) {score += 1;}
        else {tintRed(R.id.question3); paintRed(R.id.q3_a); paintRed(R.id.q3_b); paintRed(R.id.q3_d); paintGreen(R.id.q3_c);}
        if (((RadioButton) findViewById(R.id.q4_c)).isChecked()) {score += 1;}
        else {tintRed(R.id.question4); paintRed(R.id.q4_a); paintRed(R.id.q4_b); paintRed(R.id.q4_d); paintGreen(R.id.q4_c);}
        if (((RadioButton) findViewById(R.id.q5_d)).isChecked()) {score += 1;}
        else {tintRed(R.id.question5); paintRed(R.id.q5_a); paintRed(R.id.q5_b); paintRed(R.id.q5_c); paintGreen(R.id.q5_d);}
        if (((RadioButton) findViewById(R.id.q6_a)).isChecked()) {score += 1;}
        else {tintRed(R.id.question6); paintRed(R.id.q6_b); paintRed(R.id.q6_c); paintRed(R.id.q6_d); paintGreen(R.id.q6_a);}
        if (((RadioButton) findViewById(R.id.q7_c)).isChecked()) {score += 1;}
        else {tintRed(R.id.question7); paintRed(R.id.q7_a); paintRed(R.id.q7_b); paintRed(R.id.q7_d); paintGreen(R.id.q7_c);}
        if (((RadioButton) findViewById(R.id.q8_b)).isChecked()) {score += 1;}
        else {tintRed(R.id.question8); paintRed(R.id.q8_a); paintRed(R.id.q8_c); paintRed(R.id.q8_d); paintGreen(R.id.q8_b);}
        if ((((CheckBox) findViewById(R.id.q9_a)).isChecked()) && (((CheckBox) findViewById(R.id.q9_c)).isChecked()) && !(((CheckBox) findViewById(R.id.q9_b)).isChecked()) && !(((CheckBox) findViewById(R.id.q9_d)).isChecked()))
        {score += 1;}
        else {tintRed(R.id.question9); paintRed(R.id.q9_b); paintRed(R.id.q9_d); paintGreen(R.id.q9_a); paintGreen(R.id.q9_c);}
        if ((((CheckBox) findViewById(R.id.q10_c)).isChecked()) && (((CheckBox) findViewById(R.id.q10_d)).isChecked()) && !(((CheckBox) findViewById(R.id.q10_a)).isChecked()) && !(((CheckBox) findViewById(R.id.q10_b)).isChecked()))
        {score += 1;}
        else {tintRed(R.id.question10); paintRed(R.id.q10_a); paintRed(R.id.q10_b); paintGreen(R.id.q10_c); paintGreen(R.id.q10_d);}
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
