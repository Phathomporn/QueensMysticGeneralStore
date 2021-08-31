package com.example.queensmysticgeneralstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText("Hello Queens");

        final TextView tvQueens = (TextView) findViewById(R.id.TvQueens);
        tvQueens.setMovementMethod((LinkMovementMethod.getInstance())); //can click link to web
        tvQueens.setText(Html.fromHtml("<b>My Queens are back!: </b> <a href=\"https://twitter.com/RVsmtown\">https://twitter.com/RVsmtown</a>"));

        final EditText editTextHello = (EditText) findViewById(R.id.editTextHello);
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if(i == EditorInfo.IME_ACTION_DONE) {
                    //copy text in Editor text
                    tvHello.setText(editTextHello.getText());
                    return true;
                }
                return false;
            }
        });

        Button btnCopy = (Button) findViewById(R.id.btnCopy);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //copy number to Hello Queen
                tvHello.setText(editTextHello.getText());
            }
        });



    }
}
