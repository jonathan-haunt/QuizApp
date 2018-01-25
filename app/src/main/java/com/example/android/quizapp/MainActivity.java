package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * This is quiz app. check correct answers and display the score .
     */
    int score = 0;
    CheckBox gif, jpeg, mp3, html, mysql, oracle, cobol, sybase;
    RadioButton sec, pro;
    EditText question3, question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gif = (CheckBox) findViewById(R.id.gif);
        jpeg = (CheckBox) findViewById(R.id.jpeg);
        mp3 = (CheckBox) findViewById(R.id.mp3);
        html = (CheckBox) findViewById(R.id.html);

        mysql = (CheckBox) findViewById(R.id.mysql);
        oracle = (CheckBox) findViewById(R.id.oracle);
        cobol = (CheckBox) findViewById(R.id.cobol);
        sybase = (CheckBox) findViewById(R.id.sybase);

        sec = (RadioButton) findViewById(R.id.security);
        pro = (RadioButton) findViewById(R.id.prolog);

        question4 = (EditText) findViewById(R.id.answer_name);
        question3 = (EditText) findViewById(R.id.answer_company_name);

    }

    // thais method calculate the score when calculateScore button click

    public void calculateScore(View view) {

// Figure out  the user check which check box

        boolean Gif = gif.isChecked();
        boolean Jpeg = jpeg.isChecked();
        boolean Mp3 = mp3.isChecked();
        boolean Html = html.isChecked();

        boolean Mysql = mysql.isChecked();
        boolean Oracle = oracle.isChecked();
        boolean Cobol = cobol.isChecked();
        boolean Sybase = sybase.isChecked();

        int total = calculatecheckbox(Gif, Jpeg, Mp3, Html, Mysql, Oracle, Cobol, Sybase);

// Figure out the user check which radio button

        boolean Sec = sec.isChecked();
        boolean Pro = pro.isChecked();

        int tot = calculateradiobox(Sec, Pro);

        String getQuestion4 = question4.getText().toString();
        String getQuestion3 = question3.getText().toString();

        String answerquz = checkanswer(getQuestion4, getQuestion3);

        Toast.makeText(this, finalscore(), Toast.LENGTH_SHORT).show();

        score = 0;
    }

    /**
     * this method check the check box quessions
     * the user checked the correct ansers or not.
     */

    private int calculatecheckbox(boolean gif, boolean jpeg, boolean mp3, boolean html, boolean mysql, boolean oracle, boolean cobol, boolean sybase) {

        if (jpeg && gif && !mp3 && !html)
            score++;
        if (mysql && oracle && sybase && !cobol)
            score++;
        return score;
    }

    /**
     * this method check the radio button quessions
     * the user checked the correct ansers or not.
     */
    private int calculateradiobox(boolean securuty, boolean prolo) {
        if (securuty)
            score++;
        if (prolo)
            score++;
        return score;
    }

    /**
     * this method check the edittext quessions
     * the user input the correct ansers or not.
     */

    private String checkanswer(String answe4, String answer3) {
        String dalta = getString(R.string.job);
        if (getString(R.string.j_gosling).equalsIgnoreCase(answe4))
            score++;

        else if (getString(R.string.gosling).equalsIgnoreCase(answe4))
            score++;
        if (getString(R.string.google).equalsIgnoreCase(answer3))
            score++;
        return dalta;
    }


    private String finalscore() {

        String priceMessage = getString(R.string.ur_score) + score + getString(R.string.outof6);
        return priceMessage;
    }


    //this method reset all feiled when the reset button click

    public void reset(View view) {
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.scrol);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        question3.setText(null);
        question4.setText(null);

        RadioGroup chiceGroup = (RadioGroup) findViewById(R.id.RGroup1);
        chiceGroup.clearCheck();
        chiceGroup = (RadioGroup) findViewById(R.id.RGroup2);
        chiceGroup.clearCheck();


        gif.setChecked(false);
        jpeg.setChecked(false);
        mp3.setChecked(false);
        html.setChecked(false);

        mysql.setChecked(false);
        oracle.setChecked(false);
        cobol.setChecked(false);
        sybase.setChecked(false);

    }

    //this method show all the correct answers when the answer button click .

    public void answer(View view) {
        ScrollView scrollToTop = (ScrollView) findViewById(R.id.scrol);
        scrollToTop.fullScroll(ScrollView.FOCUS_UP);

        question3.setText(R.string.google);
        question4.setText(R.string.j_gosling);

        RadioGroup chiceGroup = (RadioGroup) findViewById(R.id.RGroup1);
        chiceGroup.check(R.id.prolog);
        chiceGroup = (RadioGroup) findViewById(R.id.RGroup2);
        chiceGroup.check(R.id.security);

        gif.setChecked(true);
        jpeg.setChecked(true);
        mp3.setChecked(false);
        html.setChecked(false);
        mysql.setChecked(true);
        oracle.setChecked(true);
        sybase.setChecked(true);
        cobol.setChecked(false);

    }


}








